package com.project.reactAndSpringboot.controller;

import com.project.reactAndSpringboot.dto.ApiResponse;
import com.project.reactAndSpringboot.dto.ProdutoDTO;
import com.project.reactAndSpringboot.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public ApiResponse<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        return ApiResponse.sucesso("Lista de produtos recuperada com sucesso", produtos);
    }

    @GetMapping("/teste")
    public String teste() {
        return "Conexão com a API de Produtos está funcionando!";
    }
}
