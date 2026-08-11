/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Repository;

import br.eti.EstoqueSaepAPI.domain.model.Movimento;
import br.eti.EstoqueSaepAPI.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface ProdutoRepository extends JpaRepository<Produto, Object>{
    public Produto findByNome(String nome);
}
