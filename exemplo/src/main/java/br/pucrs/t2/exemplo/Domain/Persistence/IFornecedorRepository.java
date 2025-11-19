package br.pucrs.t2.exemplo.Domain.Persistence;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;

public interface IFornecedorRepository {
    Optional<Fornecedor> getFornecedores();
    List<Fornecedor> getFornecedorById(Date dataFundacao);
    boolean addFornecedor(Fornecedor fornecedor);
}
