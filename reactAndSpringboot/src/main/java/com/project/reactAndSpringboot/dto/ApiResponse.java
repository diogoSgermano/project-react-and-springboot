package com.project.reactAndSpringboot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final boolean sucesso;
    private final String mensagem;
    private final T dados;
    private final LocalDateTime timestamp;

    private ApiResponse(boolean sucesso, String mensagem, T dados) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = dados;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> sucesso(String mensagem, T dados) {
        Objects.requireNonNull(dados, "dados não pode ser null em uma resposta de sucesso");
        return new ApiResponse<>(true, mensagem, dados);
    }

    //  SEM dados — DELETE e ações
    // Void declara explicitamente que a ausência de dados é intencional
    public static ApiResponse<Void> sucesso(String mensagem) {
        return new ApiResponse<>(true, mensagem, null);
    }

    //  Erro — nunca tem dados
    public static <T> ApiResponse<T> erro(String mensagem) {
        return new ApiResponse<>(false, mensagem, null);
    }

    public boolean isSucesso()          { return sucesso; }
    public String getMensagem()         { return mensagem; }
    public T getDados()                 { return dados; }
    public LocalDateTime getTimestamp() { return timestamp; }
}