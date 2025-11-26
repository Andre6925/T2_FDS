package br.pucrs.t2.exemplo.Adapters.Gateways;

import org.springframework.data.repository.CrudRepository;
import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public interface CompradorRepositoryJPA extends CrudRepository<Comprador, Long>{
    boolean existsByCod(Long cod);    
}
