package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public interface ICompradorRepository {
    Optional<Comprador> getCompradores();
    List<Comprador> getTecnologiaById(String pais);
    boolean addComprador(Comprador comprador);
}
