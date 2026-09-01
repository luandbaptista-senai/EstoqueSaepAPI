/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.EstoqueSaepAPI.Service;

import br.eti.EstoqueSaepAPI.Repository.CategoriaRepository;
import br.eti.EstoqueSaepAPI.domain.exception.DomainException;
import br.eti.EstoqueSaepAPI.domain.model.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.eti.EstoqueSaepAPI.domain.dto.CategoriaValorTotalDTO;
import br.eti.EstoqueSaepAPI.Projections.CategoriaValorTotalProjection;
import java.math.BigDecimal;
import java.util.stream.Collectors;

/**
 *
 * @author digma
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository cr;
    
    public List<CategoriaValorTotalDTO> valorTotalPorCatViaJPQL() {
        //List<CategoriaValorTotalProjection> resultados= cr.calcularValorTotalPorCatViaJPQL();
        List<CategoriaValorTotalDTO> resultados= cr.calcularValorTotalPorCatViaJPQL();
        return resultados.stream().map(proj -> new CategoriaValorTotalDTO(proj.getCategoria(), proj.getValorTotal())).collect(Collectors.toList());
    }
    
    public Categoria salvar(Categoria categoria) {
    Categoria categoriaExistente = cr.findByCategoria(categoria.getCategoria());
    //o metodo SAVE tambem pode registrar algo novo se o ID estiver vazio, caso contrário ele só altera
    
    //verificação de existencia do categoria
    if (categoriaExistente != null && !categoriaExistente.equals(categoria)) {
    //lançar exception
    throw new DomainException("Já existe um categoria cadastrado com esse nome!");
    }
    return cr.save(categoria);
    }
    
}
