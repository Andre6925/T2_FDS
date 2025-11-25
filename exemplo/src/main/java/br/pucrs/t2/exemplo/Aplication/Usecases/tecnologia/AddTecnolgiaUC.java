package br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.IFornecedorRepository;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
@Service
public class AddTecnolgiaUC {
    
    private final ITecnologiaRepository tecnologiaRepository;
    private final IFornecedorRepository fornecedorRepository;

    public AddTecnolgiaUC(ITecnologiaRepository tecnologiaRepository,
                          IFornecedorRepository fornecedorRepository){
        this.tecnologiaRepository = tecnologiaRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public boolean execute(TecnologiaDTO dto) {
        if(tecnologiaRepository.getTecnologiaById(dto.getId()).isPresent()){
            return false;
        }
        
        var fornOpt = fornecedorRepository.getFornecedorById(dto.getFornecedorCod());
        if(fornOpt.isEmpty()){
            return false;
        }

        var fornecedor = fornOpt.get();
        Tecnologia tecnologia = new Tecnologia(
            dto.getId(),
            dto.getModelo(),
            dto.getDescricao(),
            dto.getValorBase(),
            dto.getPeso(),
            dto.getTemperatura(),
            fornecedor
            
        );

        return tecnologiaRepository.addTecnologia(tecnologia);
    }

}