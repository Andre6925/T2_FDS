package br.pucrs.t2.exemplo.Adapters.Gateways;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public interface VendaRepositoryJPA extends CrudRepository<Venda, Long>{
    boolean existsByNum(Long num);
    //Lista de compras - só ativas
    List<Venda> findByComprador_CodAndRemovidaFalse(Long codComprador);
    //contagem para cálculo do desconto
    long countByComprador_CodAndRemovidaFalse(Long CodComprador);
}
