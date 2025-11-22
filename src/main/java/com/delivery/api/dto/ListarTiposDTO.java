package com.delivery.api.dto;

import com.delivery.api.entidade.PizzaTipo;

public record ListarTiposDTO(
        String id,
        String nome,
        String descricao,
        double precoBase,
        String imagemUrl)
{

    public ListarTiposDTO(PizzaTipo pizzaTipo) {
        this(
                pizzaTipo.getId(),
                pizzaTipo.getNome(),
                pizzaTipo.getDescricao(),
                pizzaTipo.getPrecoBase(),
                pizzaTipo.getImagemUrl()
        );
    }

}
