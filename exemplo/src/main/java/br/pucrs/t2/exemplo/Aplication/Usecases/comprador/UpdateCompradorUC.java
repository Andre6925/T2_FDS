package br.pucrs.t2.exemplo.Aplication.Usecases.comprador;

import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Persistence.ICompradorRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCompradorUC {

    private final ICompradorRepository compradorRepository;

    public UpdateCompradorUC(ICompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    public boolean execute(CompradorDTO dto) {
        var opt = compradorRepository.getCompradorById(dto.getCod());
        if (opt.isEmpty()) {
            return false;
        }


        Comprador comprador = opt.get();

        // Herdado de Participante
        comprador.setNome(dto.getNome());

        // Atributos adicionados por você em Comprador
        comprador.setPais(dto.getPais());
        comprador.setEmail(dto.getEmail());

        compradorRepository.addComprador(comprador);

        return true;
    }
}
