package br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;

@Service
public class FindTechById {
    private final ITecnologiaRepository tecnologiaRepo;

    public FindTechById(ITecnologiaRepository tecnologiaRepo){
        this.tecnologiaRepo = tecnologiaRepo;
    }

    public TecnologiaDTO execute(long id){
         Tecnologia tecnologia = tecnologiaRepo.getTecnologiaById(id)
                .orElseThrow(() -> new RuntimeException("Tecnologia não encontrada"));

        return new TecnologiaDTO(tecnologia);

    }
}
