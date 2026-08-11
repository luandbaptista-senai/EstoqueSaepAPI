/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
//import org.hibernate.type.descriptor.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 *
 * @author digma
 */
@Entity
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@ForeignKey
    private Long id_produto;
    private LocalDateTime datamovto;
    private BigDecimal qtd;

    public Movimento() {
    }

    public Movimento(Long id, Long id_produto, LocalDateTime datamovto, BigDecimal qtd) {
        this.id = id;
        this.id_produto = id_produto;
        this.datamovto = datamovto;
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public LocalDateTime getDatamovto() {
        return datamovto;
    }

    public void setDatamovto(LocalDateTime datamovto) {
        this.datamovto = datamovto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }
    
    
}
