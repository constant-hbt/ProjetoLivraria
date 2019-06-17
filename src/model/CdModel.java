package model;

public class CdModel extends MidiaModel{
    private String duracao; 
    private int quant_musicas;
    
    public CdModel(){
        super();
        duracao = new String();
        quant_musicas = 0;
    }


    public CdModel(String duracao, int quant_musicas, int ano, String titulo, String descricao, int quant, double custo, double preco_unit, int id, SituacaoModel situacao) {
        super(ano, titulo, descricao, quant, custo, preco_unit, id, situacao);
        this.duracao = duracao;
        this.quant_musicas = quant_musicas;
    }
    
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String data_nasc) {
        this.duracao = data_nasc;
    }

    public int getQuant_musicas() {
        return quant_musicas;
    }

    public void setQuant_musicas(int quant_musicas) {
        this.quant_musicas = quant_musicas;
    }

}
