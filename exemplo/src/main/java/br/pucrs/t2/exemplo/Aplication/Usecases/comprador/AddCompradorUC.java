package br.pucrs.t2.exemplo.Aplication.Usecases.comprador;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Persistence.ICompradorRepository;

@Service 
public class AddCompradorUC {

    private final ICompradorRepository compradorRepository;

    public AddCompradorUC(ICompradorRepository compradorRepository){
        this.compradorRepository = compradorRepository;
    }

    public boolean execute(CompradorDTO dto) {
        if (compradorRepository.getCompradorById(dto.getCod()).isPresent()) {
            return false;
        }
    
        Comprador c = new Comprador(dto.getCod(), dto.getNome(), dto.getPais(), dto.getEmail());
        compradorRepository.addComprador(c);
        return true;

    }
}
