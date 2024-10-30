package com.example.demo.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import model.Sport;
import model.Tim;
import model.Utakmica;

public interface UtakmicaRepository extends JpaRepository<Utakmica, Integer> {
	
	List<Utakmica> findBySport(Sport s);

	List<Utakmica> findByTim1(Tim t);
	
	List<Utakmica> findByTim2(Tim t);

	//List<Utakmica> findByTims(Tim t);

}
