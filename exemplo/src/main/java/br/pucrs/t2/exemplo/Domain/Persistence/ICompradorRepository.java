package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public interface ICompradorRepository {
    List<Comprador> getTecnologiaById(Long cod);
    Optional<Comprador> getCompradores();
    boolean addComprador(Comprador comprador);
}
