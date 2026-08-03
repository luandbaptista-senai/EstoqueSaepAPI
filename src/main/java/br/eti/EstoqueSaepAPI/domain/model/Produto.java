/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * @author digma
 */
@Entity
public class Produto {
    @Id 
    private Long id;
    private String nome;
    private Long id_categoria;
    private BigDecimal saldo;
    private BigDecimal valor_unitario;

    public Produto() {
    }

    public Produto(Long id, String nome, Long id_categoria, BigDecimal saldo, BigDecimal valor_unitario) {
        this.id = id;
        this.nome = nome;
        this.id_categoria = id_categoria;
        this.saldo = saldo;
        this.valor_unitario = valor_unitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    
}
