package model;

import java.util.ArrayList;

public final class ClienteFisicoModel extends PessoaModel{
    private String cpf, sexo, rg, data_nasc, nome;

    public ClienteFisicoModel() {
        super();
        cpf = new String();
        sexo = new String();
        rg = new String();
        data_nasc = new String();
        nome = new String();
    }

    public ClienteFisicoModel(String cpf, String nome, String sexo, String rg, String data_nasc, String email, String observacoes, String cidade, String cep, String bairro, String rua, String numero, String complemento, String estado, String data_cad, int id, ArrayList<TelefoneModel> telefones) {
        super(email, observacoes, cidade, cep, bairro, rua, numero, complemento, estado, data_cad, id, telefones);
        this.cpf = cpf;
        this.sexo = sexo;
        this.rg = rg;
        this.data_nasc = data_nasc;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
