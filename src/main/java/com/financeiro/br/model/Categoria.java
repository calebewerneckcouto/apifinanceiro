package com.financeiro.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descricao;
    
    private String cor;
    
    private Boolean gastos;

    // Construtor vazio necessário para o JPA
    public Categoria() {
    }

    // Construtor com parâmetro String para desserialização JSON
    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getGastos() {
        return gastos;
    }

    public void setGastos(Boolean gastos) {
        this.gastos = gastos;
    }
}
