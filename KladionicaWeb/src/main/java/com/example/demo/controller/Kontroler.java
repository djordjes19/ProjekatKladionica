package com.example.demo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.KvotaRepository;
import com.example.demo.repositories.RegistrovanikorisnikRepo;
import com.example.demo.repositories.SportRepository;
import com.example.demo.repositories.TiketRepository;
import com.example.demo.repositories.TimRepository;
import com.example.demo.repositories.UlogaRepository;
import com.example.demo.repositories.Utakmica1Repository;
import com.example.demo.repositories.UtakmicaRepository;
import com.example.demo.services.Servis;
//import com.ibm.icu.util.Calendar;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/kontroler")
public class Kontroler {

	@Autowired
	Servis service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping("/loginPage")
	public String logIn() {
		return "login";
	}

	@GetMapping("/indexPage")
	public String index() {
		return "index";
	}

	@GetMapping("/guest")
	public String loginYes(Principal p, HttpServletRequest req) {
		return service.loginYes(p, req);
	}

	@GetMapping("/getSveUtakmice")
	public String getSveUtakmice(HttpServletRequest req) {
		return service.getSveUtakmice(req);
	}

	@GetMapping("/registracija")
	public String registracija(HttpServletRequest req) {
		return service.registracija(req);
	}

	@PostMapping("/register")
	public String register(String ime, String prezime, String adresa, String korisnickoIme, String sifra, Integer uloga,
			HttpServletRequest req) {
		return service.register(ime, prezime, adresa, korisnickoIme, sifra, uloga, req);
	}

	@GetMapping("/getSportTim")
	public String getSport(HttpServletRequest req) {
		return service.getSport(req);

	}


	@PostMapping("/saveUtakmica")
	public String saveUtakmica(HttpServletRequest req, Date datum, Integer sport, Integer tim1, Integer tim2) {
		return service.saveUtakmica(req, datum, sport, tim1, tim2);
	}

	@PostMapping("/saveKvotas")
	public String saveKvotas(int kec, int x, int dvojka, HttpServletRequest req) {
		return service.saveKvotas(kec, x, dvojka, req);
	}

	@GetMapping("/odabirUtakmice")
	public String getSveUtakmice1(HttpServletRequest req) {
		return service.getSveUtakmice1(req);
	}

	@GetMapping("/odabranaUtakmica")
	public String odabranaUtakmica(Integer utakmica, HttpServletRequest req) {
		return service.odabranaUtakmica(utakmica, req);
	}

	@GetMapping("/azuriraj")
	public String azuriraj(Date datum, Integer sport, HttpServletRequest req) {
		return service.azuriraj(datum, sport, req);
	}

	@GetMapping("/izborUtakmice")
	public String getSveUtakmice2(HttpServletRequest req) {
		return service.getSveUtakmice2(req);
	}

	@GetMapping("/brisanjeUtakmice")
	public String brisanjeUtakmice(HttpServletRequest req, Integer utakmica) {
		return service.brisanjeUtakmice(req, utakmica);
	}

	@GetMapping("/prikazSvihTiketaKorisnika")
	public String getTikets(HttpServletRequest req) {
		return service.getTikets(req);
	}

	@GetMapping("/getSviTiketi")
	public String getSviTiketi(HttpServletRequest req) {
		return service.getSviTiketi(req);
	}

	@GetMapping("/izvestaj")
	public void showReport1(HttpServletResponse response) throws Exception {
		service.showReport1(response);
	}

//	@GetMapping("/izvestaj2")
//	public void showReport2(HttpServletResponse response) throws Exception {
//		service.showReport2(response);
//	}

	@GetMapping("/prikazSvihKorisnika")
	public String prikazSvihKorisnika(HttpServletRequest request) {
		return service.prikazSvihKorisnika(request);
	}


	@GetMapping("/prikaziTiket")
	public String prikaziTiket(HttpServletRequest req) {
		return service.prikaziTiket(req);
	}

	@GetMapping("/getUtakmiceTima")
	public String getUtakmiceTima(HttpServletRequest req) {
		return service.getUtakmiceTima(req);
	}

	@GetMapping("/getUtakmiceSporta")
	public String getUtakmiceSporta(Integer idSporta, HttpServletRequest req) {
		return service.getUtakmiceSporta(idSporta, req);
	}

	@GetMapping("/getKorisniciIUtakmice")
	public String getKorisniciIUtakmice(HttpServletRequest req) {
		return service.getKorisniciIUtakmice(req);
	}

	@PostMapping("/saveTiket")
	public String saveTiket(HttpServletRequest req, String datumTIketa, Integer idKorisnika, Integer uplata) {
		return service.saveTiket(req, datumTIketa, idKorisnika, uplata);
	}

	@PostMapping("/prikazZaSport")
	public String prikazZaSport(HttpServletRequest request, Integer sportId) {
		return service.prikazZaSport(request, sportId);
	}

	@PostMapping("/prikazZaTim")
	public String prikazZaTim(HttpServletRequest request, Integer timId) {
		return service.prikazZaTim(request, timId);
	}

	@PostMapping("/dodajUtakmicuUTiket")
	public String dodajUtakmicuUTiket(HttpServletRequest request, Integer idUt) {
		return service.dodajUtakmicuUTiket(request, idUt);
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		return service.logoutPage(request,response);
	}
}
