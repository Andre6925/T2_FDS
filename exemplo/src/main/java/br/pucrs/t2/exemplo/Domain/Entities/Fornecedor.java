package br.pucrs.t2.exemplo.Domain.Entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Fornecedor extends Participante {
    
    private Date dataFundacao;
    @Enumerated(EnumType.STRING)
    private AreaFornecedor area;

    @OneToMany(mappedBy = "fornecedor")
    public List<Tecnologia> tecnologias;

    
    public Fornecedor(Long cod, String nome, Date dataFundacao, AreaFornecedor area){
        super(cod, nome);
        this.dataFundacao = dataFundacao;
        this.area = area; 
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

      public AreaFornecedor getArea() {
        return area;
    }

    public void setArea(AreaFornecedor area) {
        this.area = area;
    }

     public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

     public void addTecnologia(Tecnologia tecnologia) {
        tecnologias.add(tecnologia);
        tecnologia.setFornecedor(this);
    }
}
