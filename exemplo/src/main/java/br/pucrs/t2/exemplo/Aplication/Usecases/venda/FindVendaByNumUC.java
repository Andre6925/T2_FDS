package br.pucrs.t2.exemplo.Aplication.Usecases.venda;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindVendaByNumUC {

    private final IVendaRepository vendaRepository;

    public FindVendaByNumUC(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Optional<VendaDTO> execute(long num) {
        return vendaRepository.getVendaById(num)
                .map(v -> new VendaDTO(
                        v.getNum(),
                        v.getTecnologia().getId(),
                        v.getTecnologia().getModelo(),
                        v.getComprador().getCod(),
                        v.getComprador().getNome(),
                        v.isRemovida()
                ));
    }
}
