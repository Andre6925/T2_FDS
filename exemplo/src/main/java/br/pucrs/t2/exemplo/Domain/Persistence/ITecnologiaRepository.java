package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;


public interface ITecnologiaRepository {
    List<Tecnologia> getTecnologias();
    Tecnologia getTecnologiaById(long id);
}
