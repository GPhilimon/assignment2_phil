package com.assignment1.clothes.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment1.clothes.model.Clothe;

public interface ClotheRepository extends CrudRepository<Clothe, Double> {
}
