/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Service;

import br.eti.EstoqueSaepAPI.Repository.MovimentoRepository;
import br.eti.EstoqueSaepAPI.Repository.ProdutoRepository;
import br.eti.EstoqueSaepAPI.domain.dto.RelatorioEstoqueDTO;
import br.eti.EstoqueSaepAPI.domain.exception.DomainException;
import br.eti.EstoqueSaepAPI.domain.model.Produto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class ProdutoService {
 @Autowired
    private ProdutoRepository produtoRepository;
 
    private MovimentoRepository movimentoRepository;
 
    public Produto salvar(Produto produto) {
    Produto produtoExistente = produtoRepository.findByNome(produto.getNome());
    //o metodo SAVE tambem pode registrar algo novo se o ID estiver vazio, caso contrário ele só altera
    
    //verificação de existencia do produto
    if (produtoExistente != null && !produtoExistente.equals(produto)) {
    //lançar exception
    throw new DomainException("Já existe um produto cadastrado com esse nome!");
    }
    return produtoRepository.save(produto);
    }   
    
    /*public List<RelatorioEstoqueDTO> gerarRelatorio(LocalDateTime dataInicio, LocalDateTime dataFim){
        List<Object[]> resultado = movimentoRepository.findRelatorioEstoqueViaJPQL(dataInicio, dataFim);
        List<RelatorioEstoqueDTO> relatorio = new ArrayList<>();
        
        for (Object[] linha : resultado){
            RelatorioEstoqueDTO dto = new RelatorioEstoqueDTO();
            dto.setProdutoId(((Number) linha[0]).longValue());
            dto.setNomeProduto(((String) linha[1]));
            dto.setValorUnitario(((BigDecimal) linha[2]));
            dto.setTotalEntradas(((Number) linha[3]).doubleValue());
            dto.setTotalSaidas(((Number) linha[4]).doubleValue());
            relatorio.add(dto);
        }
     return relatorio;
    return movimentoRepository.findRelatorioEstoqueViaJPQL(dataInicio, dataFim);
    }*/
}
