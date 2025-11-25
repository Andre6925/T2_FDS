package br.pucrs.t2.exemplo.Infra;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
import jakarta.annotation.PostConstruct;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

@Repository
public class TecnologiaRepoMemo implements ITecnologiaRepository { 
    private final List<Tecnologia> tecnologias = new ArrayList<>();

    private final FornecedorRepoMemo fornecedorRepo;

    public TecnologiaRepoMemo(FornecedorRepoMemo fornecedorRepo){
        this.fornecedorRepo = fornecedorRepo;
    }

    @PostConstruct
    public void initData(){

        // fornecedores existentes no FornecedorRepoMemo
        Fornecedor f1 = fornecedorRepo.getFornecedorById(1L).orElse(null);
        Fornecedor f2 = fornecedorRepo.getFornecedorById(2L).orElse(null);
        Fornecedor f3 = fornecedorRepo.getFornecedorById(3L).orElse(null);
  
        tecnologias.add(new Tecnologia(1, "Aspire 5", "preto", 5000, 2.5, 65, f1));
        tecnologias.add(new Tecnologia(2, "Alienware", "preto fosco", 9000, 3.1, 72, f2));
        tecnologias.add(new Tecnologia(3, "Book2", "cinza espacial", 3000, 1.7, 55, f3));

    }

    @Override 
    public List<Tecnologia> getTecnologias() {
        return new ArrayList<>(tecnologias); // retorna cópia para segurança
    }

    @Override
    public Optional<Tecnologia> getTecnologiaById(long id) {
        return tecnologias.stream()
            .filter(t -> t.getId() == id)
            .findFirst();
    }

    @Override
    public boolean addTecnologia(Tecnologia tecnologia) {
        if (getTecnologiaById(tecnologia.getId()).isPresent()) {
            return false;
        }
        tecnologias.add(tecnologia);
        return true;
    }
}
