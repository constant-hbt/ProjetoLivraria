
package model;

import java.util.ArrayList;

public final class FuncionarioModel extends PessoaModel{
    private double salario;
    private String login, senha, nome, cargo, sexo, cpf, rg, data_nasc;
    private int id;

    public FuncionarioModel() {
        super();
        this.salario = 0.0;
        this.login = new String();
        this.senha = new String();
        this.nome = new String();
        this.cargo = new String();
        this.sexo = new String();
        this.cpf = new String();
        this.rg = new String();
        this.data_nasc = new String();
    }

    public FuncionarioModel(double salario, String login, String senha, String nome, String cargo, String sexo, String cpf, String rg, String data_nasc, String email, String observacoes, String cidade, String cep, String bairro, String rua, String numero, String complemento, String estado, String data_cad, int id, ArrayList<TelefoneModel> telefones) {
        super(email, observacoes, cidade, cep, bairro, rua, numero, complemento, estado, data_cad, id, telefones);
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cargo = cargo;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nasc = data_nasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

   

    
    
    
    
    
}
