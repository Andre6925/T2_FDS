package br.pucrs.t2.exemplo;

public class Comprador{
    private String pais;
    private String email;

    public Comprador(){
    }

    public Comprador(String pais, String email){
        this.pais = pais;
        this.email = email;
    }

    public String getPais(){
        return this.pais;
    }
    public void setPais(String pais){
        this.pais = pais;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Comprador: país=" + this.pais + ", email=" + this.email + "]";
    }

}