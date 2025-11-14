package br.pucrs.t2.exemplo.Domain.Entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Fornecedor {
    @Id
    private Date dataFundacao;
    
    public Fornecedor(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
