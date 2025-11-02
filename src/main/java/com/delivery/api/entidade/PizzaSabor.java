package com.delivery.api.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pizza_sabores")
public class PizzaSabor {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private String imagemUrl;
    private List<PizzaTipo> pizzaTipos;
}
