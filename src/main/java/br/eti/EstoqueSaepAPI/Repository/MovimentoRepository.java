/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Repository;

import br.eti.EstoqueSaepAPI.domain.model.Movimento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
//import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface MovimentoRepository extends JpaRepository<Movimento, Object>{
    //public Movimento findById(Long id);
    List<Movimento> findByQtdLessThanOrderByDatamovtoDesc(BigDecimal qtd);
    
    List<Movimento> findByDatamovtoBetween(LocalDateTime data, LocalDateTime data2);

// O Spring ia ler: "Ache para mim onde a Qtd for Menor Que (ZERO) Ordenado Por DataMovto Descendente"
//movimentoRepository.findByQtdLessThanOrderByDataMovtoDesc(BigDecimal.ZERO);
}
