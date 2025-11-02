package com.delivery.api.repository;

import com.delivery.api.entidade.PizzaTipo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaTipoRepository extends MongoRepository<PizzaTipo, String> {
}
