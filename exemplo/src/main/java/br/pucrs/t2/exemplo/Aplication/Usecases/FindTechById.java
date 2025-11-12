package br.pucrs.t2.exemplo.Aplication.Usecases;

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
        Tecnologia tecnologia = tecnologiaRepo.getTecnologiaById(id);
        return tecnologia == null ? null : new TecnologiaDTO(tecnologia);
    }
}
