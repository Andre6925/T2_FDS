package br.pucrs.t2.exemplo.Domain.Entities;

import jakarta.persistence.*;

@Entity
public abstract class Participante {
    @Id
    private Long cod;
    private String nome;

    
    public Participante(Long cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }

    public Participante() {}

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
