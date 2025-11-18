package br.pucrs.t2.exemplo.Adapters.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.t2.exemplo.Aplication.Usecases.FindTechById;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Persistence.ITecnologiaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/acmetech")
public class ACMEController {
    private final FindTechById findTechById;
    private ITecnologiaRepository tecnologia;

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

    @GetMapping("/tecnologiabyid/{id}")
    public Tecnologia getTecnologiaById(@PathVariable long id) {
        return tecnologia.getTecnologiaById(id);
    }
    
}
    
