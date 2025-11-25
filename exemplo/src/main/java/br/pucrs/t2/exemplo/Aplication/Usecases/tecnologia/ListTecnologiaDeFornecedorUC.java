package br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;

@Service
public class ListTecnologiaDeFornecedorUC {
    
    private ITecnologiaRepository tecnologiaRepository;

    public ListTecnologiaDeFornecedorUC(ITecnologiaRepository tecnologiaRepository){
        this.tecnologiaRepository = tecnologiaRepository;
    }

     public List<TecnologiaDTO> execute(long codFornecedor) {
        return tecnologiaRepository.getTechByFornecedorCod(codFornecedor).stream()
                .map(tec -> new TecnologiaDTO(
                        tec.getId(),
                        tec.getModelo(),
                        tec.getDescricao(),
                        tec.getValorBase(),
                        tec.getPeso(),
                        tec.getTemperatura(),
                        tec.getFornecedor().getCod(),
                        tec.getFornecedor().getNome()
                ))
                .collect(Collectors.toList());
    }

}
