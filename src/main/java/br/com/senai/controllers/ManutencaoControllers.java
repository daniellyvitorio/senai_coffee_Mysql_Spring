package br.com.senai.controllers;


import br.com.senai.models.Manutencao;
import br.com.senai.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ManutencaoControllers {

    @RestController
    @RequestMapping("/manutencao")
    public class ManutencaoController {
        @Autowired
        ManutencaoRepository ManutencaoRepository;

        @GetMapping(value = "/all",
                produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Manutencao> getAllManutencao(){
            return ManutencaoRepository.findAll();
        }

        //metodo para salvar no banco de dados
        @PostMapping(value="/createManutencao",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Manutencao createManutencao(@RequestBody Manutencao manutencao){
            //Cria um novo objeto Product
            Manutencao newManutencao = new Manutencao();
            //Seta as propriedades do Product
            newManutencao.setName(manutencao.getName());
            newManutencao.setPrice(manutencao.getPrice());
            //Chama o método save para salvar o objeto no banco de dados
            return ManutencaoRepository.save(newManutencao);
        }

        //atualizar cafe
        @PutMapping(value="/updateManutencao",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Manutencao updateManutencao(@RequestBody Manutencao manutencao){
            Manutencao getManutencao = (Manutencao) ManutencaoRepository.findById(manutencao.getId()).orElseThrow();
            Manutencao updateManutencao = new Manutencao();

            updateManutencao.setId(manutencao.getId());
            updateManutencao.setName(manutencao.getName());
            updateManutencao.setPrice(manutencao.getPrice());

            return  ManutencaoRepository.save(updateManutencao);
        }
        // Metodo deletar product
        @DeleteMapping(value="/deleteManutencao/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
        //@PathVariable pega um valor passado junto a barra de endereço
        public Object deleteManutencao(@PathVariable Long id){
            //Verifica se existe o café no bando de dados procurando id
            Object getManutencao = ManutencaoRepository.findById(id).orElseThrow();
            //chamamos p método .delete e passamos o café a ser deletado
            ManutencaoRepository.delet(getManutencao);
            return getManutencao;
        }
    }

}
