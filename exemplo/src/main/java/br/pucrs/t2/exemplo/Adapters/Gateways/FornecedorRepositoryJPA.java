package br.pucrs.t2.exemplo.Adapters.Gateways;

import org.springframework.data.repository.CrudRepository;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;

public interface FornecedorRepositoryJPA extends CrudRepository<Fornecedor, Long>{
    boolean existsByCod(Long cod);    
}
