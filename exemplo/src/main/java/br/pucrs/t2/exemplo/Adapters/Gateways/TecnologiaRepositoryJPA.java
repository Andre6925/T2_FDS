package br.pucrs.t2.exemplo.Adapters.Gateways;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

public interface TecnologiaRepositoryJPA extends CrudRepository<Tecnologia, Long>{
    boolean existsById(Long id);
    List<Tecnologia> findByFornecedor_Cod(Long condFornecedor);
}
