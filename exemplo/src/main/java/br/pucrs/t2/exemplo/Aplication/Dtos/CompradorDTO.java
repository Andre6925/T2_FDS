package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public class CompradorDTO {
    private long cod;
    private String nome;
    private String endereco;

    public CompradorDTO() {}

    public CompradorDTO(long cod, String nome, String endereco) {
        this.cod = cod;
        this.nome = nome;
        this.endereco = endereco; 
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
} 

