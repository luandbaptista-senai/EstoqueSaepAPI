/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Service;

import br.eti.EstoqueSaepAPI.Repository.MovimentoRepository;
import br.eti.EstoqueSaepAPI.domain.exception.DomainException;
import br.eti.EstoqueSaepAPI.domain.model.Movimento;
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
}
