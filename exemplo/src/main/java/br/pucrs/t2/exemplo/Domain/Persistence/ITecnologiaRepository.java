package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;


public interface ITecnologiaRepository {
    List<Tecnologia> getTecnologias();
    Optional<Tecnologia> getTecnologiaById(long id);
    boolean addTecnologia(Tecnologia tecnologia);
}
