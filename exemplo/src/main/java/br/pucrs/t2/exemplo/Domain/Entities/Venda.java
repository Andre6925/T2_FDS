package br.pucrs.t2.exemplo.Domain.Entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda{
    @Id
    private long num;
    private Date data;
    private double valorFinal;
    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    private Tecnologia tecnologia;
    @ManyToOne
    @JoinColumn(name = "comprador_cod")
    private Comprador comprador;
    private boolean removida;

    public Venda(){}

    public Venda(long num, Date data, double valorFinal, 
                 Tecnologia tecnologia, Comprador comprador, boolean removida) {
        this.num = num;
        this.data = data;
        this.valorFinal = valorFinal;
        this.tecnologia = tecnologia;
        this.comprador = comprador;
        this.removida = removida;
    }

    public Venda(long num, Tecnologia tecnologia,
                Comprador comprador, boolean removida) {
        this.num = num;
        this.tecnologia = tecnologia;
        this.comprador = comprador;
        this.removida = removida;
        this.data = new Date(System.currentTimeMillis());
        this.valorFinal = 0.0;
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
    
    public boolean isRemovida() {
        return removida;
    } 
    
    public void setNum(long num) {
        this.num = num;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setRemovida(boolean removida) {
        this.removida = removida;
    }

    @Override
    public String toString() {
        return "Venda: num=" + this.num + ", data=" + this.data + ", valor final=" + this.valorFinal + "]";
    }
    
}