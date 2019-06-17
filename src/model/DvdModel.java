package model;

public class DvdModel extends MidiaModel{
    private String duracao;

    public DvdModel() {
        duracao = new String();
    }


    public DvdModel(String duracao, int ano, String titulo, String descricao, int quant, double custo, double preco_unit, int id, SituacaoModel situacao) {
        super(ano, titulo, descricao, quant, custo, preco_unit, id, situacao);
        this.duracao = duracao;
    }
    
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    
    
    
}
