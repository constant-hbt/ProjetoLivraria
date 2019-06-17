package model;

import java.util.ArrayList;

public class CompraModel {
    double valortotal, desconto;
    int idCompra, idPessoa, idFuncionario;
    String data, hora, formapag;
    ArrayList<ItensCompraModel> itensCompra;

    public CompraModel() {
        valortotal = 0.0;
        idCompra = 0;
        idPessoa = 0;
        idFuncionario = 0;
        data = new String();
        hora = new String();
        formapag = new String();
        itensCompra = new ArrayList<>();
        desconto = 0.0;
    }

    public CompraModel(double valortotal, int idCompra, int idPessoa, int idFuncionario, String data, String hora, String formapag, ArrayList<ItensCompraModel> itensCompra, double desconto) {
        this.valortotal = valortotal;
        this.idCompra = idCompra;
        this.idFuncionario = idFuncionario;
        this.idPessoa = idPessoa;
        this.data = data;
        this.hora= hora;
        this.formapag = formapag;
        this.itensCompra = itensCompra;
        this.desconto = desconto;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFormapag() {
        return formapag;
    }

    public void setFormapag(String formapag) {
        this.formapag = formapag;
    }

    public ArrayList<ItensCompraModel> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ArrayList<ItensCompraModel> itensCompra) {
        this.itensCompra = itensCompra;
    }

    public void adicionarItem (ItensCompraModel item){
        itensCompra.add(item);
    }
    
    public void removerItem(int posicao){
        itensCompra.remove(posicao);
    }
    
    public void removerItem(ItensCompraModel item){
        itensCompra.remove(item);
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    
}
