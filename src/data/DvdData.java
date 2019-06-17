package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.DvdModel;
import model.SituacaoModel;

public class DvdData extends Conexao{
    public DvdData() throws Exception{}
    public boolean incluir (DvdModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        Conexao c = new Conexao();
      
            String sql = "insert into midia (mid_idSituacao, mid_ano, mid_titulo, mid_descricao, mid_quant, mid_custo, mid_precounit)"
                    + "values(?,?,?,?,?,?,?)";
           
            PreparedStatement ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, obj.getSituacao().getId());
            ps.setInt(2, obj.getAno());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getDescricao());
            ps.setInt(5, obj.getQuant());
            ps.setDouble(6, obj.getCusto());
            ps.setDouble(7, obj.getPreco_unit());

            if(ps.executeUpdate()>0){
                int id = 0;
                String sqlId = "Select max (mid_idMidia) as mid_idMidia from midia";
                PreparedStatement ps2 = getConexao().prepareStatement(sqlId);
                ResultSet rs = ps2.executeQuery();
                if(rs.next()) id=rs.getInt("mid_idMidia");
                String sqlRev = "insert into dvd (dvd_idMidia, dvd_duracao) "
                        + "values (?,?)";
                
                PreparedStatement ps3 = getConexao().prepareStatement(sqlRev);
                ps3.setInt(1, id);
                ps3.setTime(2, formataHora(obj.getDuracao()));
                
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else return false;
    }
    
    public ArrayList<DvdModel> pesquisar(String pesq) throws Exception{
        ArrayList<DvdModel> dados = new ArrayList<>();
        String sql = "Select * from midia m inner join dvd d ON(m.mid_idmidia = d.dvd_idmidia) where m.mid_titulo like'" + pesq + "%' order by m.mid_titulo";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sqlSit = "Select * from situacao where sit_id = ?";
        PreparedStatement psSit = getConexao().prepareStatement(sqlSit);
        String sql2 = "Select * from dvd where dvd_idMidia=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        while(rs.next()){
            DvdModel dvd = new DvdModel();
            SituacaoModel sit = new SituacaoModel();
            dvd.setId(rs.getInt("mid_idMidia"));
            sit.setId(rs.getInt("mid_idSituacao"));
            dvd.setAno(rs.getInt("mid_ano"));
            dvd.setTitulo(rs.getString("mid_titulo"));
            dvd.setDescricao(rs.getString("mid_descricao"));
            dvd.setQuant(rs.getInt("mid_quant"));
            dvd.setCusto(rs.getDouble("mid_custo"));
            dvd.setPreco_unit(rs.getDouble("mid_precounit"));
            psSit.setInt(1, sit.getId());
            ResultSet rs_sit = psSit.executeQuery();
            while(rs_sit.next()){
                sit.setDescricao(rs_sit.getString("sit_desc"));
                dvd.setSituacao(sit);
            }
            ps2.setInt(1, dvd.getId());
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                dvd.setPreco_unit(rs.getInt("mid_precounit"));
                dvd.setDuracao(rs2.getString("dvd_duracao"));
            }
            dados.add(dvd);
        }
        return dados;
    } 
    /*
    public boolean excluir(int id) throws Exception{
        
        try{
            String sql = "Delete from dvd where dvd_idMidia=?";
            String sql3 = "Delete from midia where mid_idMidia=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps.setInt(1, id);
            ps3.setInt(1, id);
            if(ps.executeUpdate()>0 && ps3.executeUpdate()>0){
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else{
                getConexao().rollback();
                getConexao().setAutoCommit(true);
                return false;
            }
        }catch(Exception e){
            throw new Exception("Erro ao excluir usuário!\n" + e.getMessage());
        }
    }
    */
    public boolean alterar (DvdModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        try{
            String sql = "update midia set mid_idSituacao = ?, mid_ano =?, mid_titulo =?, mid_descricao =?, mid_quant =?, mid_custo = ?, mid_precounit =? where mid_idMidia=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setInt(1, obj.getSituacao().getId());
            ps.setInt(2, obj.getAno());
            ps.setString(3, obj.getTitulo());
            ps.setString(4, obj.getDescricao());
            ps.setInt(5, obj.getQuant());
            ps.setDouble(6, obj.getCusto());
            ps.setDouble(7, obj.getPreco_unit());
            ps.setInt(8, obj.getId());
            
            if(ps.executeUpdate() > 0){
                
                String sql2 = "update dvd set dvd_duracao =? where dvd_idMidia=?";
                PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                ps2.setTime(1, formataHora(obj.getDuracao()));
                ps2.setInt(2, obj.getId());
                if(ps2.executeUpdate() > 0){
                    
                    getConexao().commit();
                    getConexao().setAutoCommit(true);
                    return true;
                }
            }
            getConexao().rollback();
            return false;
            
        }catch(SQLException e){
            throw new Exception("Erro ao atualizar usuário\n" + e.getMessage());
        }
    }
    
    public static Time formataHora(String hora) throws Exception { 
        if (hora == null || hora.equals(""))
            return null;
 	
         Date time = null;
         Time horaf = null;
         try {
             SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
             time = formatter.parse(hora);
             horaf = new Time(time.getTime());
         } catch (ParseException e) {            
             throw e;
         }
         return horaf;
    }
}
