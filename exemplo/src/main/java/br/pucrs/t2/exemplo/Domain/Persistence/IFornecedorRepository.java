package br.pucrs.t2.exemplo.Domain.Persistence;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;

public interface IFornecedorRepository {
    List<Fornecedor> getFornecedorById(Long cod);
    Optional<Fornecedor> getFornecedores();
    boolean addFornecedor(Fornecedor fornecedor);
}
