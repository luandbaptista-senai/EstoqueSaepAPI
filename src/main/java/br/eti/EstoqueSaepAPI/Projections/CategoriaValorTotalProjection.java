/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Projections;
import java.math.BigDecimal;

/**
 * Interface(Projection) utilizado como auxiliar de retorno da Query JPQL 
 * no cálculo de valor total de produtos por categoria.
 * 
 * 
 * @author Luan
 */

public interface CategoriaValorTotalProjection {
    String getCategoria();
    BigDecimal getValorTotal();
}