package br.pucrs.t2.exemplo.Aplication.Usecases.venda;

import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import br.pucrs.t2.exemplo.Domain.Services.CalculadoraVendaService;

import org.springframework.stereotype.Service;

@Service
public class GetValorFinalVendaUC {

    private final IVendaRepository vendaRepository;
    private final CalculadoraVendaService calculadora;

    public GetValorFinalVendaUC(IVendaRepository vendaRepository,
                                CalculadoraVendaService calculadora) {
        this.vendaRepository = vendaRepository;
        this.calculadora = calculadora;
    }

    public double execute(long num) {
        var vendaOpt = vendaRepository.getVendaByNum(num);
        if (vendaOpt.isEmpty()) {
            return -1.0;
        }

        var venda = vendaOpt.get();
        long qtdAnteriores = vendaRepository.countByCompradorCod(
                venda.getComprador().getCod()
        );

      
        if (qtdAnteriores > 0) {
            qtdAnteriores = qtdAnteriores - 1;
        }

        return calculadora.calcularValorFinal(venda, qtdAnteriores);
    }
}
