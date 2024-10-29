package br.com.fintech.model;

public class Banco {
    private int idBco;
    private String nomeBanco;

    public Banco() {
    }

    public Banco(int idBco, String nomeBanco) {
        this.idBco = idBco;
        this.nomeBanco = nomeBanco;
    }

    public int getIdBco() {
        return idBco;
    }

    public void setIdBco(int idBco) {
        this.idBco = idBco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}
