package model;

public class RevistaModel extends MidiaModel{
    private int qtd_pag;

    public RevistaModel() {
        super();
        qtd_pag = 0;
    }

    public RevistaModel(int qtd_pag, int ano, String titulo, String descricao, int quant, double custo, double preco_unit, int id, SituacaoModel situacao) {
        super(ano, titulo, descricao, quant, custo, preco_unit, id, situacao);
        this.qtd_pag = qtd_pag;
    }

    public int getQtd_pag() {
        return qtd_pag;
    }

    public void setQtd_pag(int qtd_pag) {
        this.qtd_pag = qtd_pag;
    }

}
