/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
//import org.hibernate.type.descriptor.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Objects;

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
    @NotNull
    private Long id_produto;
    @Column(name = "data_movto")
    @NotNull
    private LocalDateTime datamovto;
    @NotNull
    private BigDecimal qtd;

    public Movimento() {
    }

    public Movimento(Long id, Long id_produto, LocalDateTime datamovto, BigDecimal qtd) {
        this.id = id;
        this.id_produto = id_produto;
        this.datamovto = datamovto;
        this.qtd = qtd;
    }

    public Movimento(Produto produto, Double quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimento other = (Movimento) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
