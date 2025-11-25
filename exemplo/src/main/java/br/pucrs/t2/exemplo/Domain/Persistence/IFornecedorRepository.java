package br.pucrs.t2.exemplo.Domain.Persistence;


import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;

public interface IFornecedorRepository {
    Optional<Fornecedor> getFornecedorById(Long cod);
    Optional<Fornecedor> getFornecedores();
    boolean addFornecedor(Fornecedor fornecedor);
}
