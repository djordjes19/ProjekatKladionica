package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Tim;

public interface TimRepository extends JpaRepository<Tim, Integer> {

}
