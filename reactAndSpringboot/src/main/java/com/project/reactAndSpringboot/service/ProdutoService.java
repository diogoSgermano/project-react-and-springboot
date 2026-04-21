package com.project.reactAndSpringboot.service;

import com.project.reactAndSpringboot.entity.Produto;
import com.project.reactAndSpringboot.repository.ProdutoRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

}
