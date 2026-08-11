/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Controller;

import br.eti.EstoqueSaepAPI.Repository.MovimentoRepository;
import br.eti.EstoqueSaepAPI.Service.MovimentoService;
import br.eti.EstoqueSaepAPI.domain.model.Movimento;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
@RequestMapping("/movimento")
public class MovimentoController {
    
    
    @Autowired
    private  MovimentoRepository movimentoRepository;
    
    @Autowired
    private MovimentoService movimentoService;
    
    @GetMapping
    public List<Movimento> todos() {
    return movimentoRepository.findAll();
    }

    /*
    @GetMapping("/{movimento}")
    public Movimento porCat(@PathVariable String movimento){
    return movimentoRepository.findByNome(movimento); 
    }*/
    
    @GetMapping("/id/{id}")
    public Optional<Movimento> porId(@PathVariable long id){
    return movimentoRepository.findById(id); 
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movimento adicionar(@Valid @RequestBody Movimento movimento){
        
        return movimentoService.salvar(movimento);
    }
    
    @PutMapping("/{movimentoID}")
    public ResponseEntity<Movimento> atualizar(@Valid @PathVariable Long movimentoID,
                                            @RequestBody Movimento movimento){
    //verifica se existe o movimento
        if(!movimentoRepository.existsById(movimentoID)) {
     return ResponseEntity.notFound().build();
        }
        
    movimento.setId(movimentoID);
    movimento = movimentoService.salvar(movimento);
    return ResponseEntity.ok(movimento);
    }
    
    
    @DeleteMapping("/{movimentoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long movimentoID){
    //verifica se existe ou nao
    if(!movimentoRepository.existsById(movimentoID)){
    return ResponseEntity.notFound().build();
    }
    
    //movimentoService.excluir(movimentoID);
    movimentoRepository.deleteById(movimentoID);
    return ResponseEntity.noContent().build();
    }
    

}
