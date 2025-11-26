package br.pucrs.t2.exemplo.Adapters.Gateways;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public interface VendaRepositoryJPA extends CrudRepository<Venda, Long>{
    boolean existsByNum(Long num);
    List<Venda> findByComprador_CodAndRemovidaFalse(Long codComprador);
    long countByComprador_CodAndRemovidaFalse(Long CodComprador);
}
