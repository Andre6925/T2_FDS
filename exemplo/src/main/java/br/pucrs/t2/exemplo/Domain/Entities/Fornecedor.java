package br.pucrs.t2.exemplo.Domain.Entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Fornecedor extends Participante {
    @Id
    private Date dataFundacao;
    
    public Fornecedor(Long cod, String nome, Date dataFundacao){
        super(cod, nome);
        this.dataFundacao = dataFundacao;
    }

    public Fornecedor(String nome, Date dataFundacao){
        super(null, nome);
        this.dataFundacao = dataFundacao;
    }

    public Fornecedor() {
        super();
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
