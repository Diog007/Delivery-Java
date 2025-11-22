package com.delivery.api.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pizza_adicional")
public class PizzaAdicionais {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private double preco;
}
