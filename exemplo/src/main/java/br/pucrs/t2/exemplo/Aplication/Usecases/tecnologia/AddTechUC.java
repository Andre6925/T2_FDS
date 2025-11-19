package br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
@Service
public class AddTechUC {
    
    private final ITecnologiaRepository tecnologiaRepo;

    public AddTechUC(ITecnologiaRepository tecnologiaRepo){
        this.tecnologiaRepo = tecnologiaRepo;
    }

    public boolean execute(TecnologiaDTO dto) {
        
        if (dto == null || dto.getId() == null || dto.getId() <= 0) {       
            return false;
        }

        // verificar duplicação correta
        if (tecnologiaRepo.getTecnologiaById(dto.getId()).isPresent()) {
            return false;
        }

        // Usa o ID enviado pelo cliente
        Tecnologia newTech = new Tecnologia(
            dto.getId(),
            dto.getModelo(),
            dto.getDescricao(),
            dto.getValorBase(),
            dto.getPeso(),
            dto.getTemperatura(),
            dto.getFornecedor()
        );

        return tecnologiaRepo.addTecnologia(newTech);
    }

}