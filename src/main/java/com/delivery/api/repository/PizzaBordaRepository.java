package com.delivery.api.repository;

import com.delivery.api.entidade.PizzaBorda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaBordaRepository extends MongoRepository<PizzaBorda, String> {
}
