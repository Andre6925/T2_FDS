package br.pucrs.t2.exemplo.Aplication.Usecases.venda;


import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;

@Service
public class FindVendaById {

    private final IVendaRepository vendaRepo;

    public FindVendaById(IVendaRepository vendaRepo){
        this.vendaRepo = vendaRepo;
    }

    public VendaDTO execute(long id){
        Venda venda = vendaRepo.getVendaById(id);
        return venda == null ? null : new VendaDTO(venda);
    }
}
