/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Repository;

import br.eti.EstoqueSaepAPI.domain.dto.RelatorioEstoqueDTO;
import br.eti.EstoqueSaepAPI.domain.model.Movimento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
//import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digma
 */
public interface MovimentoRepository extends JpaRepository<Movimento, Object>{
    //public Movimento findById(Long id);
    List<Movimento> findByQtdLessThanOrderByDatamovtoDesc(BigDecimal qtd);
    
    List<Movimento> findByDatamovtoBetween(LocalDateTime data, LocalDateTime data2);
/*    
    @Query( "SELECT new br.eti.EstoqueSaepAPI.domain.dto.RelatorioEstoqueDTO("+
            "p.id, pi.nome, p.valorunitario, "+
            "SUM(ABS(m.qtd))"+
            "FROM Movimento m JOIN m.produto"+
            "WHERE (:dataInicio IS NULL OR :dataFim IS NULL OR m.dataMovto Between :dataInicio AND :dataFim"+
            "GROUP BY p.id"+
            "ORDER BY p.nome"
            
            "SELECT new br.eti.EstoqueSaepAPI.domain.dto.RelatorioEstoqueDTO(" +
"p.id, p.nome, p.valor_unitario, SUM(ABS(m.qtd))) " +
"FROM Movimento m JOIN Produto p ON m.id_produto = p.id " +
"WHERE (:dataInicio IS NULL OR :dataFim IS NULL OR m.datamovto BETWEEN :dataInicio AND :dataFim) " +
"GROUP BY p.id, p.nome, p.valor_unitario " +
"ORDER BY p.nome"
)
    List<RelatorioEstoqueDTO> findRelatorioEstoqueViaJPQL(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataInicio") LocalDateTime dataFim);
// O Spring ia ler: "Ache para mim onde a Qtd for Menor Que (ZERO) Ordenado Por DataMovto Descendente"
//movimentoRepository.findByQtdLessThanOrderByDataMovtoDesc(BigDecimal.ZERO);*/
}
