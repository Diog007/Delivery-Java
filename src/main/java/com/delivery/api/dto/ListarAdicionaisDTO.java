package com.delivery.api.dto;

import com.delivery.api.entidade.PizzaAdicionais;

public record ListarAdicionaisDTO(
        String id,
        String nome,
        String descricao,
        double preco) {

    public ListarAdicionaisDTO(PizzaAdicionais adicionais) {
        this(
                adicionais.getId(),
                adicionais.getNome(),
                adicionais.getDescricao(),
                adicionais.getPreco()
        );
    }
}
