
package model;

public class SituacaoModel {
    int id;
    String descricao;
    
    public SituacaoModel(){
        id = 0;
        descricao = new String();
    }

    public SituacaoModel(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
}
