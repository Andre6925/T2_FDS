package br.pucrs.t2.exemplo.Adapters.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;
import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;
import br.pucrs.t2.exemplo.Aplication.Dtos.FornecedorDTO;
import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;
import br.pucrs.t2.exemplo.Aplication.Usecases.comprador.*;
import br.pucrs.t2.exemplo.Aplication.Usecases.fornecedor.ListFornecedoresUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.tecnologia.*;
import br.pucrs.t2.exemplo.Aplication.Usecases.venda.*;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/acmetech")
public class ACMEController {
   private final FindTecnologiaByIdUC findTecnologiaByIdUC;
    private final ListTecnologiaUC listTecnologiaUC;
    private final AddTecnolgiaUC addTecnologiaUC;
    private final ListFornecedoresUC listFornecedoresUC;
    private final AddCompradorUC addCompradorUC;
    private final ListCompradoresUC listCompradoresUC;
    private final UpdateCompradorUC updateCompradorUC;
    private final AddVendaUC addVendaUC;
    private final FindVendaByNumUC findVendaByNumUC;
    private final ListVendasUC listVendasUC;
    private final GetValorFinalVendaUC getValorFinalVendaUC;
    private final ListComprasDeComprador listComprasDeCompradorUC;
    private final ListTecnologiaDeFornecedorUC listTecnologiasDeFornecedorUC;
    private final RemoveVendaLogicaUC removeVendaLogicaUC;

    @Autowired
     public ACMEController(FindTecnologiaByIdUC findTecnologiaByIdUC,
                          ListTecnologiaUC listTecnologiaUC,
                          AddTecnolgiaUC addTecnologiaUC,
                          ListFornecedoresUC listFornecedoresUC,
                          AddCompradorUC addCompradorUC,
                          ListCompradoresUC listCompradoresUC,
                          UpdateCompradorUC updateCompradorUC,
                          AddVendaUC addVendaUC,
                          FindVendaByNumUC findVendaByNumUC,
                          ListVendasUC listVendasUC,
                          GetValorFinalVendaUC getValorFinalVendaUC,
                          ListComprasDeCompradoresUC listComprasDeCompradorUC,
                          ListTecnologiaDeFornecedorUC listTecnologiasDeFornecedorUC,
                          RemoveVendaLogicaUC removeVendaLogicaUC) {
        this.findTecnologiaByIdUC = findTecnologiaByIdUC;
        this.listTecnologiaUC = listTecnologiaUC;
        this.addTecnologiaUC = addTecnologiaUC;
        this.listFornecedoresUC = listFornecedoresUC;
        this.addCompradorUC = addCompradorUC;
        this.listCompradoresUC = listCompradoresUC;
        this.updateCompradorUC = updateCompradorUC;
        this.addVendaUC = addVendaUC;
        this.findVendaByNumUC = findVendaByNumUC;
        this.listVendasUC = listVendasUC;
        this.getValorFinalVendaUC = getValorFinalVendaUC;
        this.listComprasDeCompradorUC = listComprasDeCompradorUC;
        this.listTecnologiasDeFornecedorUC = listTecnologiasDeFornecedorUC;
        this.removeVendaLogicaUC = removeVendaLogicaUC;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagem(){
        return("Bem-vindo");
    }

    @GetMapping("/tecnologias")
    public List<Tecnologia> getTecnologia() {
        return tecnologia.getTecnologias();
    }
    
    @GetMapping("/tecnologiabyid/{id}")
    public Optional<Tecnologia> getTecnologiaById(@PathVariable long id) {
        return tecnologia.getTecnologiaById(id);
    }
    
    @PostMapping("/novatecnologia")
    public boolean addTecnologia(@RequestBody TecnologiaDTO dto) {
        return addTechUC.execute(dto); 
    }
    

    @GetMapping("/vendabynum/{num}")
    public Venda getVendaByNum(@PathVariable long num) {
        return venda.getVendaById(num);
    }
}
    
