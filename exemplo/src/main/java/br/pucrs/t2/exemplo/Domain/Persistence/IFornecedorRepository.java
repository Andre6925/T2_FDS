package br.pucrs.t2.exemplo.Domain.Persistence;


import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;

public interface IFornecedorRepository {
    List<Fornecedor> getFornecedores();
    Optional<Fornecedor> getFornecedorById(long cod);
    boolean addFornecedor(Fornecedor fornecedor);
}
