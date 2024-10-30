package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Registrovanikorisnik;
import model.Uloga;

public interface RegistrovanikorisnikRepo extends JpaRepository<Registrovanikorisnik, Integer> {
	Optional<Registrovanikorisnik> findByKorisnickoIme(String username);
	List<Registrovanikorisnik> findByUloga(Uloga u);
}
