package br.pucrs.t2.exemplo.Aplication.Usecases;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;

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
