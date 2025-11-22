package com.delivery.api.dto;

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