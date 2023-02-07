package com.example.demo.repository;

import com.example.demo.repository.entity.Pastry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PastryRepository extends JpaRepository<Pastry, Long> {
    List<Pastry> findByNameContainingIgnoreCase(String searchTerm);
}
