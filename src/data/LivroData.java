/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.LivroModel;
import model.SituacaoModel;
/**
 *
 * @author Henrique Borges
 */
public class LivroData extends Conexao{
    public LivroData() throws Exception{}
    public boolean incluir (LivroModel obj) throws Exception{
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
                String sqlLivro = "insert into livro (li_idMidia, li_quantpag, li_isbn, li_larg, li_alt, li_prof, li_idioma) "
                        + "values (?,?,?,?,?,?,?)";
                
                PreparedStatement ps3 = getConexao().prepareStatement(sqlLivro);
                ps3.setInt(1, id);
                ps3.setInt(2, obj.getQtd_pag());
                ps3.setInt(3, obj.getIsbn());
                ps3.setDouble(4, obj.getLargura());
                ps3.setDouble(5, obj.getAltura());
                ps3.setDouble(6, obj.getProfundidade());
                ps3.setString(7, obj.getIdioma());
                
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else return false;
            //return ps.executeUpdate()>0;
    }
    
    public ArrayList<LivroModel> pesquisar(String pesq) throws Exception{
        ArrayList<LivroModel> dados = new ArrayList<>();
        String sql = "Select * from midia m inner join livro l ON(m.mid_idmidia = l.li_idmidia) where m.mid_titulo like'" + pesq + "%' order by m.mid_titulo";
        String sql_sit = "Select * from situacao where sit_id = ?";
        PreparedStatement ps_sit = getConexao().prepareStatement(sql_sit);
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sql2 = "Select * from livro where li_idMidia=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        while(rs.next()){
            LivroModel livro = new LivroModel();
            SituacaoModel sit = new SituacaoModel();
            livro.setId(rs.getInt("mid_idMidia"));
            sit.setId(rs.getInt("mid_idSituacao"));
            livro.setAno(rs.getInt("mid_ano"));
            livro.setTitulo(rs.getString("mid_titulo"));
            livro.setDescricao(rs.getString("mid_descricao"));
            livro.setQuant(rs.getInt("mid_quant"));
            livro.setCusto(rs.getDouble("mid_custo"));
            livro.setPreco_unit(rs.getInt("mid_precounit"));
            ps_sit.setInt(1, sit.getId());
            ResultSet rs_sit = ps_sit.executeQuery();
            while(rs_sit.next()){
                sit.setDescricao(rs_sit.getString("sit_desc"));
                livro.setSituacao(sit);
            }
            ps2.setInt(1, livro.getId());
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                livro.setQtd_pag(rs2.getInt("li_quantpag"));
                livro.setIsbn(rs2.getInt("li_isbn"));
                livro.setLargura(rs2.getDouble("li_larg"));
                livro.setAltura(rs2.getDouble("li_alt"));
                livro.setProfundidade(rs2.getDouble("li_prof"));
                livro.setIdioma(rs2.getString("li_idioma"));
            }
            dados.add(livro);
        }
        return dados;
    } 
    /*
    public boolean excluir(int id) throws Exception{
        getConexao().setAutoCommit(false);
        String sql = "Delete from livro where li_idMidia=?";
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
    public boolean alterar (LivroModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        try{
            String sql = "update midia set mid_idSituacao = ?, mid_ano =?, mid_titulo =?, mid_descricao=?, mid_quant =?, mid_custo = ?, mid_precounit =? where mid_idMidia=?";
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
                String sql2 = "update livro set li_quantpag =?, li_isbn =?, li_larg =?, li_alt =?, li_prof =?, li_idioma =? where li_idMidia=?";
                PreparedStatement ps2 = getConexao().prepareStatement(sql2);
                ps2.setInt(1, obj.getQtd_pag());
                ps2.setInt(2, obj.getIsbn());
                ps2.setDouble(3, obj.getLargura());
                ps2.setDouble(4, obj.getAltura());
                ps2.setDouble(5, obj.getProfundidade());
                ps2.setString(6, obj.getIdioma());
                ps2.setInt(7, obj.getId());
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
