
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.TelefoneModel;
import model.ClienteJuridicoModel;

public class ClienteJuriData extends Conexao{
    public ClienteJuriData() throws Exception{}
    public boolean incluir (ClienteJuridicoModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        Conexao c = new Conexao();

            String sql = "insert into pessoa (pes_obs, pes_cidade, pes_cep, pes_bairro, pes_rua, pes_nro, pes_complemento, pes_estado, pes_email)"
                    + "values(?,?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = c.getConexao().prepareStatement(sql);
            ps.setString(1, obj.getObservacoes());
            ps.setString(2, obj.getCidade());
            ps.setString(3, obj.getCep());
            ps.setString(4, obj.getBairro());
            ps.setString(5, obj.getRua());
            ps.setString(6, obj.getNumero());
            ps.setString(7, obj.getComplemento());
            ps.setString(8, obj.getEstado());
            ps.setString(9, obj.getEmail());

            //Para receber a instrução  sql que quer executar, sem ele nao funciona
            if(ps.executeUpdate() > 0){
            int id = 0;
            String sqlId = "Select max (pes_idPessoa) as pes_idPessoa from pessoa";
            PreparedStatement ps2 = getConexao().prepareStatement(sqlId);
            ResultSet rs = ps2.executeQuery();
            if(rs.next()) id=rs.getInt("pes_idPessoa");
            String sqlCli = "insert into cliente (cli_id) values (?)";
            PreparedStatement pscli = getConexao().prepareStatement(sqlCli);
            pscli.setInt(1, id);
            //Para receber a instrução  sql que quer executar, sem ele nao funciona
            if(pscli.executeUpdate()>0){
                String sqlClij = "insert into cli_juridico (clij_idPessoa, clij_cnpj, clij_nomefantasia, clij_razaosocial) "
                        + "values (?,?,?,?)";
                
                PreparedStatement ps3 = getConexao().prepareStatement(sqlClij);
                ps3.setInt(1, id);
                ps3.setString(2, obj.getCnpj());
                ps3.setString(3, obj.getNome_fant());
                ps3.setString(4, obj.getRazao_social());
                
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                else{
                    int idTel = 0;
                    String sqlIdTel = "Select max (pes_idPessoa) as pes_idPessoa from pessoa";
                    PreparedStatement ps4 = getConexao().prepareStatement(sqlIdTel);
                    ResultSet rs2 = ps4.executeQuery();
                    if(rs2.next()){
                        idTel=rs2.getInt("pes_idPessoa");
                    }
                    for(TelefoneModel tel: obj.getTelefones()){
                        String sqlTel = "Insert into pessoa_telefone " 
                               + "(ptel_idPessoa,ptel_numtel,ptel_dddtel,ptel_tipotel) "
                                + "values (?,?,?,?)";
                        PreparedStatement ps5 = getConexao().prepareStatement(sqlTel);
                        ps5.setInt(1, idTel);
                        ps5.setInt(2, tel.getNumero());
                        ps5.setInt(3, tel.getDdd());
                        ps5.setString(4, tel.getTipo_tel());
                        if(ps5.executeUpdate() == 0)
                            getConexao().rollback();
                    }
                }
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
        }
        return false;
            //return ps.executeUpdate()>0;
    }
    
    public ArrayList<ClienteJuridicoModel> pesquisar(String pesq) throws Exception{
        ArrayList<ClienteJuridicoModel> dados = new ArrayList<>();
        String sql = "Select * from cli_juridico where clij_nomefantasia like'" + pesq+"%'";
        //PrepareStament ps = getConexao().prepareStatement(sql);
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sql2 = "Select * from pessoa where pes_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        while(rs.next()){
            ClienteJuridicoModel clij = new ClienteJuridicoModel();
            clij.setId(rs.getInt("clij_idPessoa"));
            clij.setCnpj(rs.getString("clij_cnpj"));
            clij.setNome_fant(rs.getString("clij_nomefantasia"));
            clij.setRazao_social(rs.getString("clij_razaosocial"));
            ps2.setInt(1, clij.getId());
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                clij.setObservacoes(rs2.getString("pes_obs"));
                clij.setCidade(rs2.getString("pes_cidade"));
                clij.setCep(rs2.getString("pes_cep"));
                clij.setBairro(rs2.getString("pes_bairro"));
                clij.setRua(rs2.getString("pes_rua"));
                clij.setNumero(rs2.getString("pes_nro"));
                clij.setComplemento(rs2.getString("pes_complemento"));
                clij.setEstado(rs2.getString("pes_estado"));
                clij.setEmail(rs2.getString("pes_email"));
            }
            String sql3 = "Select * from pessoa_telefone where ptel_idPessoa=?";
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps3.setInt(1, clij.getId());
            ResultSet rs3 = ps3.executeQuery();
            while(rs3.next()){
                TelefoneModel tel = new TelefoneModel();
                tel.setDdd(rs3.getInt("ptel_dddtel"));
                tel.setNumero(rs3.getInt("ptel_numtel"));
                tel.setTipo_tel(rs3.getString("ptel_tipotel"));
                clij.adicionarTelefone(tel);
            }
            dados.add(clij);
        }
        return dados;
    } 
    
    public boolean excluir(int id) throws Exception{
        getConexao().setAutoCommit(false);
        String sql2 = "Delete from pessoa_telefone where ptel_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        ps2.setInt(1, id);
        if(ps2.executeUpdate()>0){
            String sql = "Delete from cli_juridico where clij_idPessoa=?";
            String sqlCli = "Delete from cliente where cli_id=?";
            String sql3 = "Delete from pessoa where pes_idPessoa=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            PreparedStatement pscli = getConexao().prepareStatement(sqlCli);
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps.setInt(1, id);
            pscli.setInt(1, id);
            ps3.setInt(1, id);
            if(ps.executeUpdate()>0 && pscli.executeUpdate()>0 && ps3.executeUpdate()>0){
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
            else{
                getConexao().rollback();
                getConexao().setAutoCommit(true);
                return false;
            }
        }throw new Exception("Erro ao excluir usuário!");
    }
    
    public boolean alterar (ClienteJuridicoModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        String sql = "update pessoa set pes_obs =?, pes_cidade =?, pes_cep =?, pes_bairro =?, pes_rua =?, pes_nro =?, pes_complemento =?, pes_estado =?, pes_email = ? where pes_idPessoa=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, obj.getObservacoes());
        ps.setString(2, obj.getCidade());
        ps.setString(3, obj.getCep());
        ps.setString(4, obj.getBairro());
        ps.setString(5, obj.getRua());
        ps.setString(6, obj.getNumero());
        ps.setString(7, obj.getComplemento());
        ps.setString(8, obj.getEstado());
        ps.setString(9, obj.getEmail());
        ps.setInt(10, obj.getId());
        
        String sql2 = "update cli_juridico set clij_cnpj =?, clij_nomefantasia =?, clij_razaosocial =? where clij_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        ps2.setString(1, obj.getCnpj());
        ps2.setString(2, obj.getNome_fant());
        ps2.setString(3, obj.getRazao_social());
        ps2.setInt(4, obj.getId());
        if(ps.executeUpdate()>0 && ps2.executeUpdate()>0){
            String sql3 = "Delete from pessoa_telefone where ptel_idPessoa=?";
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps3.setInt(1, obj.getId());
            ps3.executeUpdate();
            for(TelefoneModel tel: obj.getTelefones()){
                    String sqlTel = "Insert into pessoa_telefone " 
                           + "(ptel_idPessoa,ptel_dddtel,ptel_numtel,ptel_tipotel) "
                            + "values (?,?,?,?)";
                    PreparedStatement ps4 = getConexao().prepareStatement(sqlTel);
                    ps4.setInt(1, obj.getId());
                    ps4.setInt(2, tel.getDdd());
                    ps4.setInt(3, tel.getNumero());
                    ps4.setString(4, tel.getTipo_tel());
                    if(ps4.executeUpdate() == 0)
                        getConexao().rollback();
                }
            getConexao().commit();
            getConexao().setAutoCommit(true);
            return true;
        }
        throw new Exception("Erro ao atualizar usuário");
    }
    
    public static String formatDateUser(String data){  
         SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");  
         Date d1 = null;  
         try {  
             d1 = f.parse(data);              
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
           
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
           
         data = format.format(d1);  
           
         return data;         
           
     } 
}
