package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SituacaoModel;

public class SituacaoData extends Conexao{
    public SituacaoData() throws Exception{ }
    public ArrayList<SituacaoModel> carregarCombo() throws Exception{
        ArrayList<SituacaoModel> lista = new ArrayList<>();
        String sql = "Select * from situacao order by sit_desc";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            SituacaoModel obj = new SituacaoModel(rs.getInt("sit_id"), rs.getString("sit_desc"));
            lista.add(obj);
        }
        return lista;
    }
}
