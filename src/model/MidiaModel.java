package model;

public class MidiaModel {
    private String titulo, descricao;
    private int quant, id, ano;
    double preco_unit, custo;
    SituacaoModel situacao;
    
    public MidiaModel() {
        ano = 0;
        titulo = new String();
        descricao = new String();
        quant = 0;
        custo = 0.0;
        preco_unit = 0.0;
        id = 0;
        situacao = new SituacaoModel();
    }

    public MidiaModel(int ano, String titulo, String descricao, int quant, double custo, double preco_unit, int id, SituacaoModel situacao) {
        this.ano = ano;
        this.titulo = titulo;
        this.quant = quant;
        this.preco_unit = preco_unit;
        this.id = id;
        this.descricao = descricao;
        this.situacao = situacao;
        this.custo = custo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(double preco_unit) {
        this.preco_unit = preco_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SituacaoModel getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoModel situacao) {
        this.situacao = situacao;
        
    
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
}
