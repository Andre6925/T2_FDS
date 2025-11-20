package br.pucrs.t2.exemplo.Domain.Services;

import org.springframework.stereotype.Service;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;

@Service
public class CalculadoraVendaService {
    
    public double calcularValorFinal(Venda venda, long quantidadeVendasAnteriores){
        var tecnologia = venda.getTecnologia();
        var fornecedor = tecnologia.getFornecedor();

        double valorBase = tecnologia.getValorBase();

        double acrescimoPercentual = switch (fornecedor.getArea()) {
            case TI -> 0.20;
            case ANDROIDES -> 0.15;
            case EMERGENTE -> 0.25;
            case ALIMENTOS -> 0.10;
        };

        double valorComAcrescimo = valorBase * (1 + acrescimoPercentual);

        long descontoPercentual = Math.min(quantidadeVendasAnteriores, 10);
        double fatorDesconto = 1 - (descontoPercentual / 100.0); 

        return valorComAcrescimo * fatorDesconto;
    }
}
