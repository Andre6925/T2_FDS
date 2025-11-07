package br.pucrs.t2.exemplo.Domain.Entities;


import javax.xml.crypto.Data;

import jakarta.persistence.*;

@Entity
public class Fornecedor {
    private Data dataFundacao;
    
    public Fornecedor(Data dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
