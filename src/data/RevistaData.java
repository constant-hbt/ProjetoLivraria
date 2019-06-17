
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.RevistaModel;
import model.SituacaoModel;

public class RevistaData extends Conexao{
    public RevistaData() throws Exception{}
    public boolean incluir (RevistaModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        Conexao c = new Conexao();
        try{
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
                String sqlRev = "insert into revista (rev_idMidia, rev_quantpag) "
                        + "values (?,?)";
                
                PreparedStatement ps3 = getConexao().prepareStatement(sqlRev);
                ps3.setInt(1, id);
                ps3.setInt(2, obj.getQtd_pag());
                
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }  
        return false;
    }
    
    public ArrayList<RevistaModel> pesquisar(String pesq) throws Exception{
        ArrayList<RevistaModel> dados = new ArrayList<>();
        String sql = "Select * from midia m inner join revista r ON(m.mid_idmidia = r.rev_idmidia) where m.mid_titulo like'" + pesq + "%' order by m.mid_titulo";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sql2 = "Select * from revista where rev_idMidia=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        String sqlSit = "Select * from situacao where sit_id = ?";
        PreparedStatement ps3 = getConexao().prepareStatement(sqlSit);
        while(rs.next()){
            RevistaModel rev = new RevistaModel();
            SituacaoModel sit = new SituacaoModel();
            rev.setId(rs.getInt("mid_idMidia"));
            sit.setId(rs.getInt("mid_idSituacao"));
            rev.setAno(rs.getInt("mid_ano"));
            rev.setTitulo(rs.getString("mid_titulo"));
            rev.setDescricao(rs.getString("mid_descricao"));
            rev.setQuant(rs.getInt("mid_quant"));
            rev.setCusto(rs.getDouble("mid_custo"));
            rev.setPreco_unit(rs.getDouble("mid_precounit"));
            ps2.setInt(1, rev.getId());
            ps3.setInt(1, sit.getId());
            ResultSet rs3 = ps3.executeQuery();
            while(rs3.next()){
                sit.setDescricao(rs3.getString("sit_desc"));
                rev.setSituacao(sit);
            }
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                rev.setQtd_pag(rs2.getInt("rev_quantpag"));
            }
            dados.add(rev);
        }
        return dados;
    } 
    /*
    public boolean excluir(int id) throws Exception{
        getConexao().setAutoCommit(false);
        String sql = "Delete from revista where rev_idMidia=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        if(ps.executeUpdate()>0){
            String sql2 = "Delete from midia where mid_idMidia=?";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setInt(1, id);
            if(ps2.executeUpdate() > 0){
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else{
                getConexao().rollback();
                getConexao().setAutoCommit(true);
                return false;
            }
        }throw new Exception ("Erro ao excluir usuário!");
    }
    */
    public boolean alterar (RevistaModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        try{
            String sql = "update midia set mid_idSituacao = ?, mid_ano =?, mid_titulo =?, mid_descricao =?, mid_quant =?, mid_custo =?, mid_precounit =? where mid_idMidia=?";
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
                String sql2 = "update revista set rev_quantpag =? where rev_idMidia=?";
                PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                ps2.setInt(1, obj.getQtd_pag());
                ps2.setInt(2, obj.getId());
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
}
