package br.pucrs.t2.exemplo.Domain.Persistence;

import java.util.List;

import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public interface IVendaRepository {
    Venda getVendaById(long num);
    List<Venda> getVendas();
    List<Venda> getVendaByCompradorCod(Long codComprador);
    long countByCompradorCod(Long codComprador);
    boolean addVenda(Venda venda);
}

