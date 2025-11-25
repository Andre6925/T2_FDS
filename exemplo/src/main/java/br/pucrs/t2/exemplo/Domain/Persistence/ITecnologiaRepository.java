package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;


public interface ITecnologiaRepository {
    Optional<Tecnologia> getTecnologiaById(long id);
    List<Tecnologia> getTecnologias();
    //List<Tecnologia> getTechByFornecedorCod(Long codFornecedor);
    boolean addTecnologia(Tecnologia tecnologia);
}
