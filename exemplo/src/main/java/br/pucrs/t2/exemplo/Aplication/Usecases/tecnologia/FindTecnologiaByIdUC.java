package br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindTecnologiaByIdUC {

    private final ITecnologiaRepository tecnologiaRepository;

    public FindTecnologiaByIdUC(ITecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public Optional<TecnologiaDTO> execute(long id) {
        return tecnologiaRepository.getTecnologiaById(id).map(tec ->
                new TecnologiaDTO(
                        tec.getId(),
                        tec.getModelo(),
                        tec.getDescricao(),
                        tec.getValorBase(),
                        tec.getPeso(),
                        tec.getTemperatura(),
                        tec.getFornecedor().getCod(),
                        tec.getFornecedor().getNome()
                )
        );
    }
}
