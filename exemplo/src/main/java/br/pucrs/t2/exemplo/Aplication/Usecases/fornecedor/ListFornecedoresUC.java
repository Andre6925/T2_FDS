package br.pucrs.t2.exemplo.Aplication.Usecases.fornecedor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.pucrs.t2.exemplo.Aplication.Dtos.FornecedorDTO;
import br.pucrs.t2.exemplo.Domain.Persistence.IFornecedorRepository;

@Service
public class ListFornecedoresUC {
    private final IFornecedorRepository fornecedorRepository;

    public ListFornecedoresUC(IFornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<FornecedorDTO> execute(){
        return fornecedorRepository.getFornecedores().stream()
            .map(f -> new FornecedorDTO(f.getCod(), f.getNome(), f.getDataFundacao(), f.getArea()))
            .collect(Collectors.toList());
    }
}
