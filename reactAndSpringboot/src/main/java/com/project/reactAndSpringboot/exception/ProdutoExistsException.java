package com.project.reactAndSpringboot.exception;

public class ProdutoExistsException extends RuntimeException {
    public ProdutoExistsException(String nome) {

        super("Já existe um produto com o nome: " + nome + ".");
    }
}
