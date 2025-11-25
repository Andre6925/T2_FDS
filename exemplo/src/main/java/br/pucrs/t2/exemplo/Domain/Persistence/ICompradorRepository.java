package br.pucrs.t2.exemplo.Domain.Persistence;


import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public interface ICompradorRepository {
    Optional<Comprador> getCompradorById(Long cod);
    Optional<Comprador> getCompradores();
    boolean addComprador(Comprador comprador);
}
