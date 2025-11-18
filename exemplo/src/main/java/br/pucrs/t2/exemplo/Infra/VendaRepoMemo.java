package br.pucrs.t2.exemplo.Infra;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import jakarta.annotation.PostConstruct;
@Repository
public class VendaRepoMemo implements IVendaRepository {
    private final List<Venda> vendas = new ArrayList<>();

    public VendaRepoMemo() {
    }

    @PostConstruct
    public void initData(){
        vendas.add(new Venda(1, new GregorianCalendar(2025, Calendar.JANUARY, 20).getTime(), 30.0));
        vendas.add(new Venda(2, new GregorianCalendar(2025, Calendar.OCTOBER, 7).getTime(), 14.0));
        vendas.add(new Venda(3, new GregorianCalendar(2025, Calendar.MAY, 24).getTime(), 70.0));

    }

    @Override 
    public List<Venda> getVendas(){
        return vendas;
    }

    @Override
    public Venda getVendaById(long num){
        return vendas.stream()
                .filter(v -> v.getNum() == num)
                .findFirst()
                .orElse(null);
    }
}
