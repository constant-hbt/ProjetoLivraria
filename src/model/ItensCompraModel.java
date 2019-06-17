package model;

public class ItensCompraModel {
    private int idCompra, idMidia, quant;
    private double valorparcial, preco;

    public ItensCompraModel() {
        idCompra = 0;
        idMidia = 0;
        quant = 0;
        valorparcial = 0.0;
        preco = 0.0;
    }

    public ItensCompraModel(int idCompra, int idMidia, int quant, double valorparcial, double preco) {
        this.idCompra = idCompra;
        this.idMidia = idMidia;
        this.quant = quant;
        this.valorparcial = valorparcial;
        this.preco = preco;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(int idMidia) {
        this.idMidia = idMidia;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getValorparcial() {
        return valorparcial;
    }

    public void setValorparcial(double valorparcial) {
        this.valorparcial = valorparcial;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
