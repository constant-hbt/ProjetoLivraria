package model;

public final class LivroModel extends MidiaModel{
    private int qtd_pag, isbn;
    private double largura, altura, profundidade;
    private String descricao, idioma;

    public LivroModel() {
        super();
        qtd_pag = 0;
        isbn = 0;
        largura = 0.0;
        altura = 0.0;
        altura = 0.0;
        profundidade = 0.0;
        idioma = new String();
    }


    public LivroModel(int qtd_pag, int isbn, double largura, double altura, double profundidade, String idioma, int ano, String titulo, String descricao, int quant, double custo, double preco_unit, int id, SituacaoModel situacao) {
        super(ano, titulo, descricao, quant, custo, preco_unit, id, situacao);
        this.qtd_pag = qtd_pag;
        this.isbn = isbn;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.idioma = idioma;
    }

    public int getQtd_pag() {
        return qtd_pag;
    }

    public void setQtd_pag(int qtd_pag) {
        this.qtd_pag = qtd_pag;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    
    
    
}
