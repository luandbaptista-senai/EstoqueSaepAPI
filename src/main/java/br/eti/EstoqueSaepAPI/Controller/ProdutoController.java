/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Controller;

import br.eti.EstoqueSaepAPI.Repository.ProdutoRepository;
import br.eti.EstoqueSaepAPI.Service.ProdutoService;
import br.eti.EstoqueSaepAPI.domain.model.Produto;
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
@RequestMapping("/produto")
public class ProdutoController {
    
    
    @Autowired
    private  ProdutoRepository produtoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> todos() {
    return produtoRepository.findAll();
    }

    
    @GetMapping("/{produto}")
    public Produto porCat(@PathVariable String produto){
    return produtoRepository.findByNome(produto); 
    }
    
    @GetMapping("/id/{id}")
    public Optional<Produto> porId(@PathVariable long id){
    return produtoRepository.findById(id); 
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto){
        
        return produtoService.salvar(produto);
    }
    
    @PutMapping("/{produtoID}")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoID,
                                            @RequestBody Produto produto){
    //verifica se existe o produto
        if(!produtoRepository.existsById(produtoID)) {
     return ResponseEntity.notFound().build();
        }
        
    produto.setId(produtoID);
    produto = produtoService.salvar(produto);
    return ResponseEntity.ok(produto);
    }
    
    
    @DeleteMapping("/{produtoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long produtoID){
    //verifica se existe ou nao
    if(!produtoRepository.existsById(produtoID)){
    return ResponseEntity.notFound().build();
    }
    
    //produtoService.excluir(produtoID);
    produtoRepository.deleteById(produtoID);
    return ResponseEntity.noContent().build();
    }
    

}
