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

    public Venda(){
    }

    public Venda(long num, Date data, double valorFinal){
        this.num = num;
        this.data = data;
        this.valorFinal = valorFinal;
    }

    public long getNum(){
        return this.num;
    }
    public void setNum(long num){
        this.num = num;
    }

    public Date getData(){
        return this.data;
    }
    public void setData(Date data){
        this.data = data;
    }

    public double getValorFinal(){
        return this.valorFinal;
    }
    public void setNum(double valorFinal){
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "Venda: num=" + this.num + ", data=" + this.data + ", valor final=" + this.valorFinal + "]";
    }

}