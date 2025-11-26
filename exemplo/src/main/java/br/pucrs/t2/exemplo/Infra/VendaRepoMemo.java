package br.pucrs.t2.exemplo.Infra;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import jakarta.annotation.PostConstruct;
@Repository
public class VendaRepoMemo implements IVendaRepository {
    private final List<Venda> vendas = new ArrayList<>();
    private final TecnologiaRepoMemo tecnologiaRepo;
    private final CompradorRepoMemo compradorRepo;

    public VendaRepoMemo(TecnologiaRepoMemo tecnologiaRepo, CompradorRepoMemo compradorRepo) {
        this.tecnologiaRepo = tecnologiaRepo;
        this.compradorRepo = compradorRepo;
    }

    @PostConstruct
    public void initData(){
        // Buscar entidades para montar vendas
        Tecnologia t1 = tecnologiaRepo.getTecnologiaById(1L).orElse(null);
        Tecnologia t2 = tecnologiaRepo.getTecnologiaById(2L).orElse(null);

        Comprador c1 = compradorRepo.getCompradorById(1L).orElse(null);
        Comprador c2 = compradorRepo.getCompradorById(2L).orElse(null);
        
        vendas.add(new Venda(1001L, Date.valueOf("2024-01-15"), 5500.00, t1, c1, false));
        vendas.add(new Venda(1002L, Date.valueOf("2024-02-10"), 9500.00, t2, c2, false));
    }

    @Override 
    public List<Venda> getVendas(){
        return new ArrayList<>(vendas);
    }

    @Override
    public Optional<Venda> getVendaByNum(long num){
        return vendas.stream()
                .filter(v -> v.getNum() == num)
                .findFirst();
    }
    @Override
    public boolean addVenda(Venda venda){
        if(getVendaByNum(venda.getNum()). isPresent()){
            return false;
        }
        vendas.add(venda);
        return true;
    }
    @Override
    public boolean removerVenda(long num) {
        Optional<Venda> v = getVendaByNum(num);
        if (v.isEmpty()) return false;

        v.get().setRemovida(true);
        return true;
    }
    @Override
    public List<Venda> getVendasByComprador(long codComprador){
        List<Venda> result = new ArrayList<>();
        for (Venda v : vendas) {
            if (v.getComprador() != null && v.getComprador().getCod() == codComprador && !v.isRemovida()) {
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public long countByCompradorCod(Long cod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countByCompradorCod'");
    }

}
