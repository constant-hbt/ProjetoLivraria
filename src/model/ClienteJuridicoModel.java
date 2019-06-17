package model;

import java.util.ArrayList;

public class ClienteJuridicoModel extends PessoaModel{
    private String cnpj, razao_social, nome_fant;

    public ClienteJuridicoModel() {
        cnpj = new String();
        razao_social = new String();
        nome_fant = new String();
    }

    public ClienteJuridicoModel(String cnpj, String razao_social, String nome_fant, String email, String observacoes, String cidade, String cep, String bairro, String rua, String numero, String complemento, String estado, String data_cad, int id, ArrayList<TelefoneModel> telefones) {
        super(email, observacoes, cidade, cep, bairro, rua, numero, complemento, estado, data_cad, id, telefones);
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fant = nome_fant;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fant() {
        return nome_fant;
    }

    public void setNome_fant(String nome_fant) {
        this.nome_fant = nome_fant;
    }
    
    
    
    
}
