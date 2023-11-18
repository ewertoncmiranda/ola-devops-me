package br.com.devops.miranda.oladevopsme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1" )
@RestController
public class IndexController {

    @GetMapping
    public String muitoBemVindo(){
        return  "Seja bem vindo, meu pequeno gafanhoto!";
    }

}
