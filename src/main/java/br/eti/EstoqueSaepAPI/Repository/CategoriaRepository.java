/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Repository;

import br.eti.EstoqueSaepAPI.domain.dto.CategoriaValorTotalDTO;
import br.eti.EstoqueSaepAPI.domain.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Object>{
    public Categoria findByCategoria(String categoria);
    //public Categoria findById(int id);
    /*@Query(  "SELECT NEW  br.eti.EstoqueSaepAPI.domain.dto.CategoriaValorTotalDTO(c.categoria, SUM(p.saldo * p.valor_unitario))" +
            "FROM Categoria c JOIN Produto p ON p.id_categoria = c.id " +
            "GROUP BY c.id, c.categoria" 
            
            
            
            "SELECT NEW CategoriaValorTotalDTO(c.categoria, SUM(p.saldo * p.valorUnitario)) " +
"FROM Categoria c JOIN c.produtos p " +
"GROUP BY c.id, c.categoria"
            
            "SELECT NEW br.eti.EstoqueSaepAPI.domain.dto.CategoriaValorTotalDTO(c.categoria, SUM(p.saldo * p.valor_unitario)) " +
"FROM Categoria c JOIN Produto p ON p.id_categoria = c.id " +
"GROUP BY c.id, c.categoria"
    )
    List<CategoriaValorTotalDTO> calcularValorTotalPorCatViaJPQL();*/
}
