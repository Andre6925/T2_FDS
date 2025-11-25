package br.pucrs.t2.exemplo.Aplication.Usecases.venda;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.ICompradorRepository;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddVendaUC {

    private final IVendaRepository vendaRepository;
    private final ITecnologiaRepository tecnologiaRepository;
    private final ICompradorRepository compradorRepository;

    public AddVendaUC(IVendaRepository vendaRepository,
                      ITecnologiaRepository tecnologiaRepository,
                      ICompradorRepository compradorRepository) {
        this.vendaRepository = vendaRepository;
        this.tecnologiaRepository = tecnologiaRepository;
        this.compradorRepository = compradorRepository;
    }

    public boolean execute(VendaDTO dto) {
        if (vendaRepository.getVendaById(dto.getNum()).isPresent()) {
            return false;
        }
        var tecOpt = tecnologiaRepository.getTecnologiaById(dto.getTecnologiaId());
        var compOpt = compradorRepository.getCompradorById(dto.getCompradorCod());

        if (tecOpt.isEmpty() || compOpt.isEmpty()) {
            return false;
        }

        var venda = new Venda(
                dto.getNum(),
                tecOpt.get(),     
                compOpt.get(),    
                false
        );
        vendaRepository.addVenda(venda);
        return true;
    }
}
