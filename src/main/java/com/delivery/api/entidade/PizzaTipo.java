package com.delivery.api.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "pizza_tipos")
public class PizzaTipo {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private double precoBase;
    private String imagemUrl;

    private List<PizzaSabor> pizzaSabores;

}
