/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Service;

import br.eti.EstoqueSaepAPI.Repository.MovimentoRepository;
import br.eti.EstoqueSaepAPI.Repository.ProdutoRepository;
import br.eti.EstoqueSaepAPI.domain.exception.DomainException;
import br.eti.EstoqueSaepAPI.domain.model.Movimento;
import br.eti.EstoqueSaepAPI.domain.model.Produto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class MovimentoService {
 @Autowired
    private MovimentoRepository movimentoRepository;
 @Autowired
 ProdutoRepository produtoRepository;
    
    public Movimento salvar(Movimento movimento) {
//    Movimento movimentoExistente = movimentoRepository.findByNome(movimento.getNome());
//    //o metodo SAVE tambem pode registrar algo novo se o ID estiver vazio, caso contrário ele só altera
//    
//    //verificação de existencia do movimento
//    if (movimentoExistente != null && !movimentoExistente.equals(movimento)) {
//    //lançar exception
//    throw new DomainException("Já existe um movimento cadastrado com esse nome!");
//    }
    return movimentoRepository.save(movimento);
    }
    public Movimento atualizaSaldo(Long idProduto, Double quantidade){
        //ProdutoRepository produtoRepository = null;
     Produto produto = produtoRepository.findById(idProduto).orElseThrow(()-> new RuntimeException("Produto não encontrado com o id" + idProduto));
     Movimento movimento = new Movimento(produto, quantidade);
     movimentoRepository.save(movimento);
     produto.atualizaSaldo(quantidade);
    return movimento;
    }
   
}
