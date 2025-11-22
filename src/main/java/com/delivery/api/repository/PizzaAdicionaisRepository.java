package com.delivery.api.repository;

import com.delivery.api.entidade.PizzaAdicionais;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaAdicionaisRepository extends MongoRepository<PizzaAdicionais, String> {
}
