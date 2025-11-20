package br.pucrs.t2.exemplo.Domain.Entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Participante {
    @Id
    private Long cod;
    private String nome;

    public Participante() {}
    
    public Participante(Long cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }


    public Long getCod() {
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
