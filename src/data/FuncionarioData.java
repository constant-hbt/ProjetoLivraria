package data;
//Pode herdar ou criar o objeto

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.TelefoneModel;
import model.FuncionarioModel;

public class FuncionarioData extends Conexao {

    public FuncionarioData() throws Exception {
    }

    public boolean incluir(FuncionarioModel obj) throws Exception {
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
        if (ps.executeUpdate() > 0) {
            int id = 0;
            String sqlId = "Select max (pes_idPessoa) as pes_idPessoa from pessoa";
            PreparedStatement ps2 = getConexao().prepareStatement(sqlId);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                id = rs.getInt("pes_idPessoa");
            }
            String sqlFunc = "insert into funcionario (func_idPessoa, func_login, func_senha, func_nome, func_cargo, func_sexo, func_cpf, func_rg, func_datanasc) "
                    + "values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps3 = getConexao().prepareStatement(sqlFunc);
            ps3.setInt(1, id);
            ps3.setString(2, obj.getLogin());
            ps3.setString(3, obj.getSenha());
            ps3.setString(4, obj.getNome());
            ps3.setString(5, obj.getCargo());
            ps3.setString(6, obj.getSexo());
            ps3.setString(7, obj.getCpf());
            ps3.setString(8, obj.getRg());
            ps3.setDate(9, formataData(obj.getData_nasc()));

            if (ps3.executeUpdate() == 0) {
                getConexao().rollback();
            } else {
                int idTel = 0;
                String sqlIdTel = "Select max (pes_idPessoa) as pes_idPessoa from pessoa";
                PreparedStatement ps4 = getConexao().prepareStatement(sqlIdTel);
                ResultSet rs2 = ps4.executeQuery();
                if (rs2.next()) {
                    idTel = rs2.getInt("pes_idPessoa");
                }
                for (TelefoneModel tel : obj.getTelefones()) {
                    String sqlTel = "Insert into pessoa_telefone "
                            + "(ptel_idPessoa,ptel_numtel,ptel_dddtel,ptel_tipotel) "
                            + "values (?,?,?,?)";
                    PreparedStatement ps5 = getConexao().prepareStatement(sqlTel);
                    ps5.setInt(1, idTel);
                    ps5.setInt(2, tel.getNumero());
                    ps5.setInt(3, tel.getDdd());
                    ps5.setString(4, tel.getTipo_tel());
                    if (ps5.executeUpdate() == 0) {
                        getConexao().rollback();
                    }
                }
            }
            getConexao().commit();
            getConexao().setAutoCommit(true);
            return true;
        } else {
            return false;
        }
        //return ps.executeUpdate()>0;
    }

    public ArrayList<FuncionarioModel> pesquisar(String pesq) throws Exception {
        ArrayList<FuncionarioModel> dados = new ArrayList<>();
        String sql = "Select * from funcionario where func_nome like'" + pesq + "%'";
        //PrepareStament ps = getConexao().prepareStatement(sql);
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String sql2 = "Select * from pessoa where pes_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        while (rs.next()) {
            FuncionarioModel func = new FuncionarioModel();
            func.setId(rs.getInt("func_idPessoa"));
            func.setLogin(rs.getString("func_login"));
            func.setSenha(rs.getString("func_senha"));
            func.setNome(rs.getString("func_nome"));
            func.setCargo(rs.getString("func_cargo"));
            func.setSexo(rs.getString("func_sexo"));
            func.setCpf(rs.getString("func_cpf"));
            func.setRg(rs.getString("func_rg"));
            func.setData_nasc(formatDateUser(rs.getString("func_datanasc")));
            ps2.setInt(1, func.getId());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                func.setObservacoes(rs2.getString("pes_obs"));
                func.setCidade(rs2.getString("pes_cidade"));
                func.setCep(rs2.getString("pes_cep"));
                func.setBairro(rs2.getString("pes_bairro"));
                func.setRua(rs2.getString("pes_rua"));
                func.setNumero(rs2.getString("pes_nro"));
                func.setComplemento(rs2.getString("pes_complemento"));
                func.setEstado(rs2.getString("pes_estado"));
                func.setEmail(rs2.getString("pes_email"));
            }
            String sql3 = "Select * from pessoa_telefone where ptel_idPessoa=?";
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps3.setInt(1, func.getId());
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                TelefoneModel tel = new TelefoneModel();
                tel.setDdd(rs3.getInt("ptel_dddtel"));
                tel.setNumero(rs3.getInt("ptel_numtel"));
                tel.setTipo_tel(rs3.getString("ptel_tipotel"));
                func.adicionarTelefone(tel);
            }
            dados.add(func);
        }
        return dados;
    }

    public boolean excluir(int id) throws Exception {
        getConexao().setAutoCommit(false);
        String sql2 = "Delete from pessoa_telefone where ptel_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        ps2.setInt(1, id);
        if (ps2.executeUpdate() > 0) {
            String sql = "Delete from funcionario where func_idPessoa=?";
            String sql3 = "Delete from pessoa where pes_idPessoa=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps.setInt(1, id);
            ps3.setInt(1, id);
            if (ps.executeUpdate() > 0 && ps3.executeUpdate() > 0) {
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            } else {
                getConexao().rollback();
                getConexao().setAutoCommit(true);
                return false;
            }
        }
        throw new Exception("Erro ao excluir usuário!");
    }

    public boolean alterar(FuncionarioModel obj) throws Exception {
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

        String sql2 = "update funcionario set func_login =?, func_senha =?, func_nome =?, func_cargo =?, func_sexo =?, func_cpf =?, func_rg =?, func_datanasc =? where func_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        ps2.setString(1, obj.getLogin());
        ps2.setString(2, obj.getSenha());
        ps2.setString(3, obj.getNome());
        ps2.setString(4, obj.getCargo());
        ps2.setString(5, obj.getSexo());
        ps2.setString(6, obj.getCpf());
        ps2.setString(7, obj.getRg());
        ps2.setDate(8, formataData(obj.getData_nasc()));
        ps2.setInt(9, obj.getId());
        if (ps.executeUpdate() > 0 && ps2.executeUpdate() > 0) {
            String sql3 = "Delete from pessoa_telefone where ptel_idPessoa=?";
            PreparedStatement ps3 = getConexao().prepareStatement(sql3);
            ps3.setInt(1, obj.getId());
            ps3.executeUpdate();
            for (TelefoneModel tel : obj.getTelefones()) {
                String sqlTel = "Insert into pessoa_telefone "
                        + "(ptel_idPessoa,ptel_dddtel,ptel_numtel,ptel_tipotel) "
                        + "values (?,?,?,?)";
                PreparedStatement ps4 = getConexao().prepareStatement(sqlTel);
                ps4.setInt(1, obj.getId());
                ps4.setInt(2, tel.getDdd());
                ps4.setInt(3, tel.getNumero());
                ps4.setString(4, tel.getTipo_tel());
                if (ps4.executeUpdate() == 0) {
                    getConexao().rollback();
                }
            }
            getConexao().commit();
            getConexao().setAutoCommit(true);
            return true;
        }
        throw new Exception("Erro ao atualizar usuário");
    }

    public FuncionarioModel validarLogin(String login, String senha) throws Exception {
        FuncionarioModel obj = null;
        String sql = "select * from funcionario where func_login=? and func_senha=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        String sql2 = "select * from pessoa where pes_idPessoa=?";
        PreparedStatement ps2 = getConexao().prepareStatement(sql2);
        while (rs.next()) {
            obj = new FuncionarioModel();
            obj.setId(rs.getInt("func_idPessoa"));
            obj.setLogin(login);
            obj.setSenha(senha);
            obj.setNome(rs.getString("func_nome"));
            obj.setCargo(rs.getString("func_cargo"));
            obj.setSexo(rs.getString("func_sexo"));
            obj.setCpf(rs.getString("func_cpf"));
            obj.setRg(rs.getString("func_rg"));
            obj.setData_nasc(rs.getString("func_datanasc"));
            ps2.setInt(1, obj.getId());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                obj.setObservacoes(rs2.getString("pes_obs"));
                obj.setCidade(rs2.getString("pes_cidade"));
                obj.setCep(rs2.getString("pes_cep"));
                obj.setBairro(rs2.getString("pes_bairro"));
                obj.setRua(rs2.getString("pes_rua"));
                obj.setNumero(rs2.getString("pes_nro"));
                obj.setComplemento(rs2.getString("pes_complemento"));
                obj.setEstado(rs2.getString("pes_estado"));
            }
        }
        return obj;
    }

    public static java.sql.Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public static String formatDateUser(String data) {
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
    
    public boolean verificaLoginEx(String user, String senha) throws SQLException{
        try{
            String sql = "Select func_login, func_senha from funcionario "
                    + "where func_login=? and func_senha=?";
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            boolean existe = false;
            while(rs.next()){
                if(rs.getString("func_login").equals(user) && rs.getString("func_senha").equals(senha)){
                    existe = true;
                }
            }
            return existe;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
