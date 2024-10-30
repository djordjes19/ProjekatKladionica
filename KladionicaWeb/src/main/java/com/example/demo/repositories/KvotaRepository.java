package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Kvota;

public interface KvotaRepository extends JpaRepository<Kvota, Integer> {

}
