package br.pucrs.t2.exemplo.Adapters.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;






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
    private final ListTecnologiaDeFornecedorUC listTecnologiasDeFornecedorUC;
    private final RemoveVendaLogicaUC removeVendaLogicaUC;
    private final ListComprasDeCompradorUC listComprasDeCompradorUC;
    

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
                          ListComprasDeCompradorUC listComprasDeCompradorUC,
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

    @GetMapping("") // funciona
    @CrossOrigin(origins = "*")
    public String mensagem(){
        return("Bem-vindo");
    }

     // GET tecnologia por id
    @GetMapping("/tecnologia/{id}") // funciona
    public ResponseEntity<TecnologiaDTO> getTecnologiaById(@PathVariable long id) {
        var opt = findTecnologiaByIdUC.execute(id);
        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // GET venda por número
    @GetMapping("/venda/{num}") // funciona
    public ResponseEntity<VendaDTO> getVendaByNum(@PathVariable long num) {
        var opt = findVendaByNumUC.execute(num);
        return opt.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // GET valor final de venda
    @GetMapping("/vendavalor/{num}")
    public ResponseEntity<Double> getValorFinalVenda(@PathVariable long num) {
        double valor = getValorFinalVendaUC.execute(num);
        if (valor < 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valor);
    }

    // GET fornecedores
    @GetMapping("/fornecedores")
    public List<FornecedorDTO> getFornecedores() {
        return listFornecedoresUC.execute();
    }

    // GET compradores
    @GetMapping("/compradores")
    public List<CompradorDTO> getCompradores() {
        return listCompradoresUC.execute();
    }

    // GET tecnologias
    @GetMapping("/tecnologias")
    public List<TecnologiaDTO> getTecnologias() {
        return listTecnologiaUC.execute();
    }

    // GET vendas (inclui removidas)
    @GetMapping("/vendas")
    public List<VendaDTO> getVendas() {
        return listVendasUC.execute();
    }

    // POST nova tecnologia
    @PostMapping("/novatecnologia")
    public boolean addTecnologia(@RequestBody TecnologiaDTO dto) {
        return addTecnologiaUC.execute(dto);
    }

    // POST novo comprador
    @PostMapping("/novocomprador")
    public boolean addComprador(@RequestBody CompradorDTO dto) {
        return addCompradorUC.execute(dto);
    }

    // POST nova venda
    @PostMapping("/novavenda")
    public boolean addVenda(@RequestBody VendaDTO dto) {
        return addVendaUC.execute(dto);
    }

    // GET compras de um comprador
    @GetMapping("/compras/{codComprador}")
    public List<VendaDTO> getComprasDeComprador(@PathVariable long codComprador) {
        return listComprasDeCompradorUC.execute(codComprador);
    }

    // GET tecnologias de um fornecedor
    @GetMapping("/fornecedor/{codFornecedor}/tecnologias")
    public List<TecnologiaDTO> getTecnologiasDeFornecedor(@PathVariable long codFornecedor) {
        return listTecnologiasDeFornecedorUC.execute(codFornecedor);
    }

    // DELETE remoção lógica de venda
    @DeleteMapping("/removervenda/{num}")
    public boolean removerVenda(@PathVariable long num) {
        return removeVendaLogicaUC.execute(num);
    }

    // PUT alterar comprador (exceto código)
    @PutMapping("/alterarcomprador")
    public boolean alterarComprador(@RequestBody CompradorDTO dto) {
        return updateCompradorUC.execute(dto);
    }
}