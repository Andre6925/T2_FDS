package br.pucrs.t2.exemplo.Aplication.Usecases.venda;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListVendasUC {

    private final IVendaRepository vendaRepository;

    public ListVendasUC(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<VendaDTO> execute() {
        return vendaRepository.getVendas().stream()
                .map(v -> new VendaDTO(
                        v.getNum(),
                        v.getTecnologia().getId(),
                        v.getTecnologia().getModelo(),
                        v.getComprador().getCod(),
                        v.getComprador().getNome(),
                        v.isRemovida()
                ))
                .collect(Collectors.toList());
    }
}
