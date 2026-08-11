/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Controller;

import br.eti.EstoqueSaepAPI.Repository.CategoriaRepository;
import br.eti.EstoqueSaepAPI.Service.CategoriaService;
import br.eti.EstoqueSaepAPI.domain.model.Categoria;
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
import jakarta.validation.Valid;

/**
 *
 * @author digma
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private  CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public List<Categoria> todos() {
    return categoriaRepository.findAll();
    }

    
    @GetMapping("/{cat}")
    public Categoria porCat(@PathVariable String cat){
    return categoriaRepository.findByCategoria(cat); 
    }
    
    @GetMapping("/id/{id}")
    public Optional<Categoria> porId(@PathVariable long id){
    return categoriaRepository.findById(id); 
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria adicionar(@Valid @RequestBody Categoria categoria){
        
        return categoriaService.salvar(categoria);
    }
    
    @PutMapping("/{categoriaID}")
    public ResponseEntity<Categoria> atualizar(@Valid @PathVariable Long categoriaID,
                                            @RequestBody Categoria categoria){
    //verifica se existe o categoria
        if(!categoriaRepository.existsById(categoriaID)) {
     return ResponseEntity.notFound().build();
        }
        
    categoria.setId(categoriaID);
    categoria = categoriaService.salvar(categoria);
    return ResponseEntity.ok(categoria);
    }
    
    
    @DeleteMapping("/{categoriaID}")
    public ResponseEntity<Void> excluir(@PathVariable Long categoriaID){
    //verifica se existe ou nao
    if(!categoriaRepository.existsById(categoriaID)){
    return ResponseEntity.notFound().build();
    }
    
    //categoriaService.excluir(categoriaID);
    categoriaRepository.deleteById(categoriaID);
    return ResponseEntity.noContent().build();
    }
    
}
