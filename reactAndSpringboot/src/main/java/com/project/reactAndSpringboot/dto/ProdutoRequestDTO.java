package com.project.reactAndSpringboot.dto;

import com.project.reactAndSpringboot.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProdutoRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "Marca é obrigatória")
        @Size(max = 100, message = "Marca deve ter no máximo 100 caracteres")
        String marca
) {

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setMarca(this.marca);
        return produto;
    }
}