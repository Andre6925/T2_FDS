package br.pucrs.t2.exemplo.Aplication.Usecases.comprador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;

@Service
public class ListComprasDeCompradorUC {
    
    private final IVendaRepository vendaRepository;

    public ListComprasDeCompradorUC(IVendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    public List<VendaDTO> execute(long codComprador){
        return vendaRepository.getVendaByCompradorCod(codComprador).stream()
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
