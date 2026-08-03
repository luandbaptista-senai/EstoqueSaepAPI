/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import org.hibernate.type.descriptor.DateTimeUtils;

/**
 *
 * @author digma
 */
@Entity
public class Movimento {
    @Id 
    private Long id;
    //@ForeignKey
    private Long id_produto;
    private DateTimeUtils datamovto;
    private BigDecimal qtd;

    public Movimento() {
    }

    public Movimento(Long id, Long id_produto, DateTimeUtils datamovto, BigDecimal qtd) {
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

    public DateTimeUtils getDatamovto() {
        return datamovto;
    }

    public void setDatamovto(DateTimeUtils datamovto) {
        this.datamovto = datamovto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }
    
    
}
