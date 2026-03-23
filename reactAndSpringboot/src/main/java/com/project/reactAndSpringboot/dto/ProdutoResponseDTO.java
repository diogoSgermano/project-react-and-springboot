package com.project.reactAndSpringboot.dto;

import com.project.reactAndSpringboot.entity.Produto;

public record ProdutoResponseDTO(
        Long codigo,
        String nome,
        String marca
) {

    // Construtor a partir da entidade
    public ProdutoResponseDTO(Produto produto) {
        this(
                produto.getCodigo(),
                produto.getNome(),
                produto.getMarca()
        );
    }

    public static ProdutoResponseDTO fromEntity(Produto produto) {
        return new ProdutoResponseDTO(produto);
    }
}