package br.pucrs.t2.exemplo.Aplication.Usecases.comprador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.ICompradorRepository;

@Service
public class ListCompradoresUC {
    
    private final ICompradorRepository compradorRepository;

    public ListCompradoresUC(ICompradorRepository compradorRepository){
        this.compradorRepository = compradorRepository;
    }

    public List<CompradorDTO> execute(){
        return compradorRepository.getCompradores().stream()
            .map(c -> new CompradorDTO(c.getCod(), c.getNome(),c.getPais(), c.getEmail()))
            .collect(Collectors.toList());
    }
}
