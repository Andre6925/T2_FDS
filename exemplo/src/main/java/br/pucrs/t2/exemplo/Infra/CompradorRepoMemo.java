package br.pucrs.t2.exemplo.Infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Persistence.ICompradorRepository;
import jakarta.annotation.PostConstruct;

@Repository
public class CompradorRepoMemo implements ICompradorRepository {
    private final List<Comprador> compradores = new ArrayList<>();

    public CompradorRepoMemo() {}

    @PostConstruct
    public void initData() {
        compradores.add(new Comprador(1L, "Carlos Pera", "Brasil", "carlos.pera@hotmail.com"));
        compradores.add(new Comprador(2L, "Mariana Alves", "Argentina", "mari.a@yahoo.com.br"));
        compradores.add(new Comprador(3L, "João Dias", "Espanha", "juanoddd.d@gmail.com"));
    }

    @Override
    public List<Comprador> getCompradores() {
        return new ArrayList<>(compradores);
    }

    @Override
    public Optional<Comprador> getCompradorById(long cod) {
        return compradores.stream()
                .filter(c -> c.getCod() == cod)
                .findFirst();
    }

    @Override
    public boolean addComprador(Comprador c) {
        if (getCompradorById(c.getCod()).isPresent()) {
            return false;
        }
        compradores.add(c);
        return true;
    }
}
