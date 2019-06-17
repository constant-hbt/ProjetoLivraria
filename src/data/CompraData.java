package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.CompraModel;
import model.ItensCompraModel;
import model.MidiaModel;


public class CompraData extends Conexao{
    public CompraData() throws Exception{}
    public boolean finalizarCompra (CompraModel obj) throws Exception{
        getConexao().setAutoCommit(false);
        Conexao c = new Conexao();
            
        String sqlCompra = "insert into compra (c_idCli, c_idFuncionario, c_data, c_hora, c_desconto, c_valortotal, c_formapag)"
                + "values(?,?,?,?,?,?,?)";

        PreparedStatement ps = c.getConexao().prepareStatement(sqlCompra);
        ps.setInt(1, obj.getIdPessoa());
        ps.setInt(2, obj.getIdFuncionario());
        ps.setDate(3, formataData(pegarData()));
        ps.setTime(4, formataHora(pegarHora()));
        ps.setDouble(5, obj.getDesconto());
        ps.setDouble(6, obj.getValortotal());
        ps.setString(7, obj.getFormapag());

        //Para receber a instrução  sql que quer executar, sem ele nao funciona
        if(ps.executeUpdate()>0){
            int idCompra = 0;
            String sqlIdCompra = "Select max (c_idCompra) as c_idCompra from compra";
            PreparedStatement ps2 = getConexao().prepareStatement(sqlIdCompra);
            ResultSet rs = ps2.executeQuery();
            while(rs.next()) idCompra=rs.getInt("c_idCompra");
            obj.setIdCompra(idCompra);
            
            for(ItensCompraModel item: obj.getItensCompra()){
                String sqlItens = "insert into itens_compra (ic_idcompra, ic_idMidia, ic_quant, ic_preco, ic_valorparcial) "
                        + "values (?,?,?,?,?)";
                PreparedStatement ps3 = getConexao().prepareStatement(sqlItens);
                ps3.setInt(1, obj.getIdCompra());
                ps3.setInt(2, item.getIdMidia());
                ps3.setInt(3, item.getQuant());
                ps3.setDouble(4, item.getPreco());
                ps3.setDouble(5, item.getValorparcial());
                if(ps3.executeUpdate() == 0)
                    getConexao().rollback();
                else{
                    String sql_retirar = "Update midia set mid_quant = mid_quant - ? where mid_idMidia=?";
                    PreparedStatement ps4 = getConexao().prepareStatement(sql_retirar);
                    ps4.setInt(1, item.getQuant());
                    ps4.setInt(2, item.getIdMidia());
                    if(ps4.executeUpdate() == 0)
                        getConexao().rollback();
                }
            }
            

            getConexao().commit();
            getConexao().setAutoCommit(true);
            return true;
        }else{
            getConexao().rollback();
            return false;
        }

    }
    
    public static java.sql.Date formataData(String data) throws Exception { 
        if (data == null || data.equals(""))
            return null;
 		
        java.sql.Date date = null;
        try {
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );
        }catch (ParseException e) {            
            throw e;
        }
        return date;
    }
    
    public static Time formataHora(String hora) throws Exception { 
        if (hora == null || hora.equals(""))
            return null;
 	
         Date time = null;
         Time horaf = null;
         try {
             SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
             time = formatter.parse(hora);
             horaf = new Time(time.getTime());
         } catch (ParseException e) {            
             throw e;
         }
         return horaf;
    }
    
    public ArrayList<MidiaModel> pesquisarMid(String pesq) throws Exception{
        ArrayList<MidiaModel> dados = new ArrayList<>();
        String sql = "Select * from midia where mid_titulo like'" + pesq+"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            MidiaModel midia = new MidiaModel();
            midia.setId(rs.getInt("mid_idMidia"));
            midia.setAno(rs.getInt("mid_ano"));
            midia.setTitulo(rs.getString("mid_titulo"));
            midia.setDescricao(rs.getString("mid_descricao"));
            midia.setQuant(rs.getInt("mid_quant"));
            midia.setPreco_unit(rs.getDouble("mid_precounit"));
            dados.add(midia);
        }
        return dados;
    } 
    
    public ArrayList<CompraModel> pesqHistorico(int id) throws Exception{
        ArrayList<CompraModel> dados = new ArrayList<>();
        String sql = "Select * from compra where c_idCli = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            CompraModel compra = new CompraModel();
            compra.setIdCompra(rs.getInt("c_idCompra"));
            compra.setIdPessoa(rs.getInt("c_idCli"));
            compra.setIdFuncionario(rs.getInt("c_idFuncionario"));
            compra.setData(rs.getString("c_data"));
            compra.setHora(rs.getString("c_hora"));
            compra.setDesconto(rs.getDouble("c_desconto"));
            compra.setValortotal(rs.getDouble("c_valortotal"));
            compra.setFormapag(rs.getString("c_formapag"));
            dados.add(compra);
        }
        return dados;
    }
    
    public ArrayList<String> pesqNomeVend (int id) throws Exception{
        ArrayList<String> vendedores = new ArrayList<>();
        String sql = "select f.func_nome as nome from funcionario f INNER JOIN compra c "
                + "ON (f.func_idPessoa = c.c_idFuncionario) where c.c_idCli = ?;";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            vendedores.add(rs.getString("nome"));
        }
        return vendedores;
    }
    
    public ArrayList<ItensCompraModel> pesqItensCompra(int idCompra) throws Exception{
        ArrayList<ItensCompraModel> itens = new ArrayList<>();
        String sql = "select * from itens_compra where ic_idCompra = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idCompra);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ItensCompraModel item = new ItensCompraModel();
            item.setIdCompra(idCompra);
            item.setIdMidia(rs.getInt("ic_idMidia"));
            item.setQuant(rs.getInt("ic_quant"));
            item.setPreco(rs.getInt("ic_preco"));
            item.setValorparcial(rs.getInt("ic_valorparcial"));
            itens.add(item);
        }
        return itens;
    }
    
    public ArrayList<String> pesqTitulos(int idCompra) throws Exception{
        ArrayList<String> titulos = new ArrayList<>();
        String sql = "select m.mid_titulo as titulo from midia m INNER JOIN itens_compra ic "
                + "ON (m.mid_idMidia = ic.ic_idMidia) WHERE ic_idCompra = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idCompra);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            titulos.add(rs.getString("titulo"));
        }
        return titulos;
    }
    
    public boolean excluir(int idCompra) throws Exception{
        getConexao().setAutoCommit(false);
        String sql = "Delete from itens_compra where ic_idCompra = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idCompra);
        if(ps.executeUpdate()>0){
            String sql2 = "Delete from compra where c_idCompra = ?";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setInt(1, idCompra);
            if(ps2.executeUpdate()>0){
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
    
    public boolean salvar(CompraModel obj, ArrayList<ItensCompraModel> itens_removidos) throws Exception{
        getConexao().setAutoCommit(false);
        String sql = "update compra set c_idFuncionario = ?, c_data = ?, c_hora = ?, "
                + "c_desconto = ?, c_valortotal = ?, c_formapag = ? where c_idCompra = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getIdFuncionario());
        ps.setDate(2, formataData(pegarData()));
        ps.setTime(3, formataHora(pegarHora()));
        ps.setDouble(4, obj.getDesconto());
        ps.setDouble(5, obj.getValortotal());
        ps.setString(6, obj.getFormapag());
        ps.setInt(7, obj.getIdCompra());
        if(ps.executeUpdate() > 0){
            String sql2 = "Delete from itens_compra where ic_idCompra = ?";
            PreparedStatement ps2 = getConexao().prepareStatement(sql2);
            ps2.setInt(1, obj.getIdCompra());
            if(ps2.executeUpdate() > 0){
                for(ItensCompraModel item: obj.getItensCompra()){
                    String sqlItem = "insert into itens_compra (ic_idcompra, ic_idMidia, ic_quant, ic_preco, ic_valorparcial) "
                        + "values (?,?,?,?,?)";
                    PreparedStatement ps3 = getConexao().prepareStatement(sqlItem);
                    ps3.setInt(1, item.getIdCompra());
                    ps3.setInt(2, item.getIdMidia());
                    ps3.setInt(3, item.getQuant());
                    ps3.setDouble(4, item.getPreco());
                    ps3.setDouble(5, item.getValorparcial());
                    if(ps3.executeUpdate() > 0){
                        String sqlRem = "Update midia set mid_quant = mid_quant - ? "
                                + "where mid_idMidia = ?";
                        PreparedStatement ps4 = getConexao().prepareStatement(sqlRem);
                        ps4.setInt(1, item.getQuant());
                        ps4.setInt(2, item.getIdMidia());
                        if(ps4.executeUpdate() == 0)
                            getConexao().rollback();
                    }
                }
                if(!itens_removidos.isEmpty()){
                    for(ItensCompraModel item: itens_removidos){
                        String sqlAdd = "Update midia set mid_quant = mid_quant + ? "
                                + "where mid_idMidia = ?";
                        PreparedStatement ps5 = getConexao().prepareStatement(sqlAdd);
                        ps5.setInt(1, item.getQuant());
                        ps5.setInt(2, item.getIdMidia());  
                        if(ps5.executeUpdate() == 0)
                            getConexao().rollback();
                    }
                }
                getConexao().commit();
                getConexao().setAutoCommit(true);
                return true;
            }
        }else{
            getConexao().rollback();
            throw new Exception ("Erro ao atualizar os dados");
        }
        return false;
    }
  
    public String pegarData(){
        Date data = new Date();
        SimpleDateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
        String data_form = formatD.format(data);
        return data_form;
    }
    
    public String pegarHora(){
        Date hora = new Date();
        SimpleDateFormat formatH = new SimpleDateFormat("HH:mm");
        String hora_form = formatH.format(hora);
        return hora_form;
    }
}

