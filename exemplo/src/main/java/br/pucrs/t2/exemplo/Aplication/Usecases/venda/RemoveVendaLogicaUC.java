package br.pucrs.t2.exemplo.Aplication.Usecases.venda;

import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveVendaLogicaUC {

    private final IVendaRepository vendaRepository;

    public RemoveVendaLogicaUC(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public boolean execute(long num) {
        var opt = vendaRepository.getVendaByNum(num);
        if (opt.isEmpty()) return false;

        var venda = opt.get();
        venda.setRemovida(true);
        vendaRepository.addVenda(venda);
        return true;
    }
}
