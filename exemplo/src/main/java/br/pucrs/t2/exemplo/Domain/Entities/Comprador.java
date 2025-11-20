package br.pucrs.t2.exemplo.Domain.Entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Comprador extends Participante{
    private String pais;
    private String email;
    @OneToMany(mappedBy = "comprador")
    private List<Venda> compras;

    public Comprador() {
        super(); 
    }

    public Comprador(Long cod, String nome, String pais, String email){
        super(cod, nome);
        this.pais = pais;
        this.email = email;
    }

    public Comprador(String nome, String pais, String email){
        super(null , nome);
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