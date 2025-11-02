package com.delivery.api.dto;

import com.delivery.api.entidade.PizzaSabor;
import com.delivery.api.entidade.PizzaTipo;

import java.util.List;

public record ListarSaboresDTO(
        String id,
        String nome,
        String descricao,
        double preco,
        String imagemUrl
) {
    public ListarSaboresDTO(PizzaSabor sabor) {
        this(
                sabor.getId(),
                sabor.getNome(),
                sabor.getDescricao(),
                sabor.getPreco(),
                sabor.getImagemUrl()
        );
    }
}