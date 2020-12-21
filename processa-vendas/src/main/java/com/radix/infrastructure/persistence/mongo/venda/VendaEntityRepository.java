package com.radix.infrastructure.persistence.mongo.venda;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface VendaEntityRepository extends MongoRepository<VendaEntity, String>, QuerydslPredicateExecutor<VendaEntity> {

    @Query("{ 'cliente' : ?0 }")
    VendaEntity findUsersByCliente(Long cliente);

    @Query("{ 'status' : ?0 }")
    List<VendaEntity> findUsersByStatus(String status);

}
