package com.project.reactAndSpringboot.service;

import com.project.reactAndSpringboot.dto.ProdutoDTO;
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
}
