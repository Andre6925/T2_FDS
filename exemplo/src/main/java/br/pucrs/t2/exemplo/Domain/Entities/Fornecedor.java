package br.pucrs.t2.exemplo.Domain.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.time.Instant;

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
