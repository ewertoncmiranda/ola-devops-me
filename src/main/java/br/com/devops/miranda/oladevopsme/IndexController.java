package br.com.devops.miranda.oladevopsme;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class IndexController {

    @GetMapping
    public String muitoBemVindo(){
        return  "Estamos avançando? !";
    }

    @GetMapping("/{teste}")
    public String muitoBemVindo(@PathVariable("teste") String teste)
    {
        return  "Estamo por aqui ----> !"+ teste ;

    }

}
