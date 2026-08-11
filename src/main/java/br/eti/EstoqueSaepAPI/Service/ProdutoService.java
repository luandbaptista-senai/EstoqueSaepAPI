/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Service;

import br.eti.EstoqueSaepAPI.Repository.ProdutoRepository;
import br.eti.EstoqueSaepAPI.domain.exception.DomainException;
import br.eti.EstoqueSaepAPI.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class ProdutoService {
 @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar(Produto produto) {
    Produto produtoExistente = produtoRepository.findByNome(produto.getNome());
    //o metodo SAVE tambem pode registrar algo novo se o ID estiver vazio, caso contrário ele só altera
    
    //verificação de existencia do produto
    if (produtoExistente != null && !produtoExistente.equals(produto)) {
    //lançar exception
    throw new DomainException("Já existe um produto cadastrado com esse nome!");
    }
    return produtoRepository.save(produto);
    }   
}
