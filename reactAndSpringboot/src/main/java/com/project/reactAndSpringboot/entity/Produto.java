package com.project.reactAndSpringboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Entity
@Table (name="produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable=true, length=100)
    private  String marca;

    @PrePersist
    public void defaultValues() {
        if (this.marca == null || this.marca.isBlank()) {
            this.marca = "Sem marca";
        }
    }

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
