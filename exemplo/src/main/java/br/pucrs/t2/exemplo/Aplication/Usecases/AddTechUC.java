package br.pucrs.t2.exemplo.Aplication.Usecases;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;

public class AddTechUC {
    
    private final ITecnologiaRepository tecnologiaRepo;

    public AddTechUC(ITecnologiaRepository tecnologiaRepo){
        this.tecnologiaRepo = tecnologiaRepo;
    }

    public static boolean execute(TecnologiaDTO dto) {
        if (dto == null || dto.getId() <= 0) {
            return false;
        }
        if (tecnologiaRepo.getTecnologiaById(dto.getId()) != null) {
            return false;
        }
        Tecnologia newTech = new Tecnologia(
            dto.getId(),
            dto.getModelo(),
            dto.getDescricao(),
            dto.getValorBase(),
            dto.getPeso(),
            dto.getTemperatura()
        );

        return tecnologiaRepo.addTecnologia(newTech);
    }

}
