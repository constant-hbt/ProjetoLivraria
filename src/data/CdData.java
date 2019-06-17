package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.CdModel;
import model.SituacaoModel;

public class CdData extends Conexao{
    public CdData() throws Exception{}
    public boolean incluir (CdModel obj) throws Exception{
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

            //Para receber a instrução  sql que quer executar, sem ele nao funciona
            if(ps.executeUpdate()>0){
                int id = 0;
                String sqlId = "Select max (mid_idMidia) as mid_idMidia from midia";
                PreparedStatement ps2 = getConexao().prepareStatement(sqlId);
                ResultSet rs = ps2.executeQuery();
                if(rs.next()) id=rs.getInt("mid_idMidia");
                String sqlRev = "insert into cd (cd_idMidia, cd_quantmusicas, cd_duracao) "
                        + "values (?,?,?)";
                
                PreparedStatement ps3 = getConexao().prepareStatement(sqlRev);
                ps3.setInt(1, id);
                ps3.setInt(2, obj.getQuant_musicas());
                ps3.setTime(3, formataHora(obj.getDuracao()));
                
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else return false;
            //return ps.executeUpdate()>0;
    }
    
    public ArrayList<CdModel> pesquisar(String pesq) throws Exception{
        ArrayList<CdModel> dados = new ArrayList<>();
        String sql = "Select * from midia m inner join cd c ON(m.mid_idmidia = c.cd_idmidia) where m.mid_titulo like'" + pesq + "%' order by m.mid_titulo";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sql2 = "Select * from cd where cd_idMidia=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        String sqlSit = "Select * from situacao where sit_id = ?";
        PreparedStatement psSit = getConexao().prepareStatement(sqlSit);
        while(rs.next()){
            CdModel cd = new CdModel();
            SituacaoModel sit = new SituacaoModel();
            cd.setId(rs.getInt("mid_idMidia"));
            
            sit.setId(rs.getInt("mid_idSituacao"));
            cd.setAno(rs.getInt("mid_ano"));
            cd.setTitulo(rs.getString("mid_titulo"));
            cd.setDescricao(rs.getString("mid_descricao"));
            cd.setQuant(rs.getInt("mid_quant"));
            cd.setCusto(rs.getDouble("mid_custo"));
            cd.setPreco_unit(rs.getInt("mid_precounit"));
            psSit.setInt(1, sit.getId());
            ResultSet rs_sit = psSit.executeQuery();
            while(rs_sit.next()){
                sit.setDescricao(rs_sit.getString("sit_desc"));
                cd.setSituacao(sit);
            }
            ps2.setInt(1, cd.getId());
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                cd.setQuant_musicas(rs2.getInt("cd_quantmusicas"));
                cd.setDuracao(rs2.getString("cd_duracao"));
            }
            dados.add(cd);
        }
        return dados;
    } 
    /*
    public boolean excluir(int id) throws Exception{
        
        try{
            String sql = "Delete from cd where cd_idMidia=?";
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
    public boolean alterar (CdModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        try{
            String sql = "update midia set mid_idSituacao = ?, mid_ano =?, mid_titulo =?, mid_descricao = ?, mid_quant =?, mid_custo = ?, mid_precounit =? where mid_idMidia=?";
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
                String sql2 = "update cd set cd_quantmusicas =?, cd_duracao =? where cd_idMidia=?";
                PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                ps2.setInt(1, obj.getQuant_musicas());
                ps2.setTime(2, formataHora(obj.getDuracao()));
                ps2.setInt(3, obj.getId());
                if(ps2.executeUpdate() > 0){
                    getConexao().commit();
                    getConexao().setAutoCommit(true);
                    return true;
                }
            }
            getConexao().rollback();
            getConexao().setAutoCommit(true);
            return false;
        }catch(Exception e){
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
    
    public static String horaString(Date hora) throws Exception{
        if(hora ==null)
            return null;
        try{
            SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
            String horaFormatada = formatador.format(hora);
            return horaFormatada;
        }catch(Exception e){
            throw e;
        }
    }
}
