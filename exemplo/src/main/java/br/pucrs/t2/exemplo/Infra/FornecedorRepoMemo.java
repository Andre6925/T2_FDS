package br.pucrs.t2.exemplo.Infra;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Persistence.IFornecedorRepository;
import jakarta.annotation.PostConstruct;

@Repository
public class FornecedorRepoMemo implements IFornecedorRepository{
    private final List<Fornecedor> fornecedores = new ArrayList<>();

    public FornecedorRepoMemo() {
    }

    @PostConstruct
    public void initData() {
        fornecedores.add(new Fornecedor(1L, "TechCorp", Date.valueOf("2005-03-10"), AreaFornecedor.TI));
        fornecedores.add(new Fornecedor(2L, "NexusBots", Date.valueOf("2010-07-22"), AreaFornecedor.ANDROIDES));
        fornecedores.add(new Fornecedor(3L, "FutureLab", Date.valueOf("2018-01-15"), AreaFornecedor.EMERGENTE));
        fornecedores.add(new Fornecedor(4L, "AgroFoods", Date.valueOf("2000-08-01"), AreaFornecedor.ALIMENTOS));
    }

    @Override
    public List<Fornecedor> getFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    @Override
    public Optional<Fornecedor> getFornecedorById(long cod) {
        return fornecedores.stream()
                .filter(f -> f.getCod() == cod)
                .findFirst();
    }

    @Override
    public boolean addFornecedor(Fornecedor f) {
        if (getFornecedorById(f.getCod()).isPresent()) {
            return false;
        }
        fornecedores.add(f);
        return true;
    }
    
}
