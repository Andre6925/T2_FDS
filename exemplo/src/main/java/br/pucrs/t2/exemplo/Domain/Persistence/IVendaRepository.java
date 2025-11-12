package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;

import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public interface IVendaRepository {
    List<Venda> getVendas();
    Venda getVendaById(long num);
}

