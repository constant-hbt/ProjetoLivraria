
package model;

import java.util.ArrayList;
public abstract class PessoaModel {
    private String email, observacoes, cidade, cep, bairro, rua, numero, complemento, estado, data_cad;
    private int id; 
    private ArrayList<TelefoneModel> telefones;

    public PessoaModel() {
        this.email = new String();
        this.observacoes = new String();
        this.cidade = new String();
        this.cep = new String();
        this.bairro = new String();
        this.rua = new String();
        this.numero = new String();
        this.complemento = new String();
        this.estado = new String();
        this.data_cad = new String();
        this.id = 0;
        this.telefones = new ArrayList<>();
    }

    public PessoaModel(String email, String observacoes, String cidade, String cep, String bairro, String rua, String numero, String complemento, String estado, String data_cad, int id, ArrayList<TelefoneModel> telefones) {
        this.email = email;
        this.observacoes = observacoes;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.data_cad = data_cad;
        this.id = id;
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData_cad() {
        return data_cad;
    }

    public void setData_cad(String data_cad) {
        this.data_cad = data_cad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TelefoneModel> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<TelefoneModel> telefones) {
        this.telefones = telefones;
    }
    
    public void adicionarTelefone (TelefoneModel tel){
        telefones.add(tel);
    }
    
    public void removerTelefone(int posicao){
        telefones.remove(posicao);
    }
    
    public void removerTelefone(TelefoneModel tel){
        telefones.remove(tel);
    }
    
}
