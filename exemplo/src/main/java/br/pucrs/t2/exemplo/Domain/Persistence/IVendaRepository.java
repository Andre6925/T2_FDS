package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public interface IVendaRepository {
    List<Venda> getVendas();
    Optional<Venda> getVendaByNum(long num);
    boolean addVenda(Venda venda);
    boolean removerVenda(long num);
    List<Venda> getVendasByComprador(long codComprador);
}

