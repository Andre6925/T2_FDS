package br.pucrs.t2.exemplo.Domain.Entities;

import jakarta.persistence.*;

@Entity
public class Participante {
    private long cod;
    private String nome;

    public Participante(long cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }
}
