package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Registrovanikorisnik;
import model.Tiket;

public interface TiketRepository extends JpaRepository<Tiket, Integer> {
	List<Tiket> findByRegistrovanikorisnik(Registrovanikorisnik k);

}
