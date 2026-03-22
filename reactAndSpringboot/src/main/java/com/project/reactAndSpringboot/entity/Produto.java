package com.project.reactAndSpringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table (name="produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String marca;

    public Produto(){}

    public Produto (Long codigo, String nome, String marca){
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
    }

    public Long getCodigo(){
       return codigo;
    }

    public void setCodigo(Long codigo){
        this.codigo=codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }
}
