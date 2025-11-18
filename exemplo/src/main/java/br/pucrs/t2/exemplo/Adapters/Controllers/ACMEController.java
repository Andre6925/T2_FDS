package br.pucrs.t2.exemplo.Adapters.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;
import br.pucrs.t2.exemplo.Aplication.Usecases.AddTechUC;
import br.pucrs.t2.exemplo.Aplication.Usecases.FindTechById;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;
import br.pucrs.t2.exemplo.Domain.Persistence.IVendaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/acmetech")
public class ACMEController {
    private final FindTechById findTechById;
    private ITecnologiaRepository tecnologia;
    private IVendaRepository venda;

    @Autowired
    public ACMEController(FindTechById findTechById, ITecnologiaRepository tecnologia){
        this.findTechById = findTechById;
        this.tecnologia = tecnologia; 
        //var tecnologiaRepo = new br.pucrs.t2.exemplo.Infra.TecnologiaRepoMemo();
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
    public Tecnologia getTecnologiaById(@PathVariable long id) {
        return tecnologia.getTecnologiaById(id);
    }
    
    @PostMapping("/novatecnologia")
    public boolean addTecnologia(@RequestBody TecnologiaDTO dto) {
        return AddTechUC.execute(dto); 
    }
    

    @GetMapping("/vendabynum/{num}")
    public Venda getVendaByNum(@PathVariable long num) {
        return venda.getVendaById(num);
    }
}
    
