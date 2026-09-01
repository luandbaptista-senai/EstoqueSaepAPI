/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.data.annotation.Immutable;

/**
 *
 * @author digma
 */
@Entity
@Table(name= "vw_categoria_valor_total")
@Immutable
public class View {
    private  BigInteger id_categoria;
    private String categoria;
    private BigDecimal valor_total;

    public BigInteger getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(BigInteger id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public View() {
    }

    public View(BigInteger id_categoria, String categoria, BigDecimal valor_total) {
        this.id_categoria = id_categoria;
        this.categoria = categoria;
        this.valor_total = valor_total;
    }
    
    
    
}
