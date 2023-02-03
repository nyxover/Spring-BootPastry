package com.example.demo.repository;

import com.example.demo.repository.entity.Pastry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastryRepository extends CrudRepository<Pastry, Long> {
}
