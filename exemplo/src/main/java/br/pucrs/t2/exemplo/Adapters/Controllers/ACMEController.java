package br.pucrs.t2.exemplo.Adapters.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.t2.exemplo.Aplication.Usecases.FindTechById;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/acmetech")
public class ACMEController {
    private final FindTechById findTechById;

    @Autowired
    public ACMEController(FindTechById findTechById){
        this.findTechById = findTechById;
        //var tecnologiaRepo = new br.pucrs.t2.exemplo.Infra.TecnologiaRepoMemo();
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagem(){
        return("Bem-vindo");
    }
}
    
