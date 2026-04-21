package com.project.reactAndSpringboot.service;

import com.project.reactAndSpringboot.dto.ProdutoDTO;
import com.project.reactAndSpringboot.entity.Produto;
import com.project.reactAndSpringboot.exception.ProdutoExistsException;
import com.project.reactAndSpringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {    
        this.produtoRepository = produtoRepository;
    }


    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public ProdutoDTO cadastrar(ProdutoDTO dto){
        if(produtoRepository.existsByNome(dto.nome())){
            throw new ProdutoExistsException(dto.nome());
        }
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setMarca(dto.marca());
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);

    }

}
