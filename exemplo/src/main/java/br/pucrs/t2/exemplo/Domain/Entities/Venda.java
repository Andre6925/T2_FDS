package br.pucrs.t2.exemplo.Domain.Entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Venda{
    @Id
    private long num;
    private Date data;
    private double valorFinal;

    private Tecnologia tecnologia;
    private Comprador comprador;

    public Venda(int i, java.util.Date date, double d){}

    public Venda(long num, Date data, double valorFinal, 
                 Tecnologia tecnologia, Comprador comprador) {
        this.num = num;
        this.data = data;
        this.valorFinal = valorFinal;
        this.tecnologia = tecnologia;
        this.comprador = comprador;
    }

    public long getNum() {
        return num;
    }

    public Date getData() {
        return data;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public Comprador getComprador() {
        return comprador;
    }

    @Override
    public String toString() {
        return "Venda: num=" + this.num + ", data=" + this.data + ", valor final=" + this.valorFinal + "]";
    } 
}