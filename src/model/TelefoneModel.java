
package model;

public final class TelefoneModel {
    private int ddd, numero;
    private String tipo_tel;

    public TelefoneModel() {
        this.ddd = 0;
        this.numero = 0;
        this.tipo_tel = new String();
    }

    public TelefoneModel(int ddd, int numero, String tipo_tel) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo_tel = tipo_tel;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo_tel() {
        return tipo_tel;
    }

    public void setTipo_tel(String tipo_tel) {
        this.tipo_tel = tipo_tel;
    }
    
    
}
