package com.example.demo.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.KvotaRepository;
import com.example.demo.repositories.RegistrovanikorisnikRepo;
import com.example.demo.repositories.SportRepository;
import com.example.demo.repositories.TiketRepository;
import com.example.demo.repositories.TimRepository;
import com.example.demo.repositories.UlogaRepository;
import com.example.demo.repositories.Utakmica1Repository;
import com.example.demo.repositories.UtakmicaRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Kvota;
import model.Registrovanikorisnik;
import model.Sport;
import model.Tiket;
import model.Tim;
import model.Uloga;
import model.Utakmica;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class Servis {

	@Autowired
	UtakmicaRepository ur;
	@Autowired
	UlogaRepository ulogaRepo;
	@Autowired
	RegistrovanikorisnikRepo kr;
	@Autowired
	SportRepository sr;
	@Autowired
	TiketRepository tr;
	@Autowired
	TimRepository timr;
	@Autowired
	Utakmica1Repository u1r;
	@Autowired
	KvotaRepository kvr;

	public String loginYes(Principal p, HttpServletRequest req) {
		String username = p.getName();
		Registrovanikorisnik k = kr.findByKorisnickoIme(username).get();
		req.getSession().setAttribute("korisnik", k);
		return "index";
	}

	public String registracija(HttpServletRequest req) {
		List<Uloga> lista = ulogaRepo.findAll();
		req.getSession().setAttribute("uloge", lista);
		return "registracija";
	}

	public String register(String ime, String prezime, String adresa, String korisnickoIme, String sifra, Integer uloga,
			HttpServletRequest req) {
		Registrovanikorisnik korisnik = new Registrovanikorisnik();
		Uloga u = ulogaRepo.findById(uloga).get();
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setKorisnickoIme(korisnickoIme);
		korisnik.setUloga(u);
		korisnik.setAdresa(adresa);
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		sifra = passEncoder.encode(sifra);
		
		korisnik.setSifra(sifra);
		Registrovanikorisnik novi = kr.save(korisnik);
		req.getSession().setAttribute("noviKorisnik", novi);
		System.out.println("Uspesno");
		return "login";

	}

	public String getSveUtakmice(HttpServletRequest req) {
		List<Utakmica> lista = ur.findAll();
		req.getSession().setAttribute("utakmice", lista);
		List<Sport> lista1 = sr.findAll();
		req.getSession().setAttribute("sportovi", lista1);
		List<Tim> lista2 = timr.findAll();
		req.getSession().setAttribute("timovi", lista2);
		return "sveUtakmice";
	}

	public String saveUtakmica(HttpServletRequest req, Date datum, Integer sport, Integer tim1, Integer tim2) {
		Utakmica u = new Utakmica();
		u.setDatumUtakmice(datum);
		u.setSport(sr.findById(sport).get());
		Registrovanikorisnik k = (Registrovanikorisnik) req.getSession().getAttribute("korisnik");
		u.setRegistrovanikorisnik(k);
		Tim timDom = timr.findById(tim1).get();
		u.setTim1(timDom);
		Tim timGost = timr.findById(tim2).get();
		u.setTim2(timGost);

		Utakmica ut = ur.save(u);
		timDom.addUtakmicas1(ut);
		timGost.addUtakmicas2(ut);
		if (ut != null) {
			req.getSession().setAttribute("poruka", "Utakmica je uspesno sacuvana");
			req.getSession().setAttribute("novaUt", ut);
		} else
			req.getSession().setAttribute("poruka", "Doslo je do greske. Utakmica nije uspesno sacuvana");
		return "unosUtakmice";
	}

	public String getSport(HttpServletRequest req) {
		List<Sport> lista1 = sr.findAll();
		List<Tim> lista2 = timr.findAll();
		req.getSession().setAttribute("sportovi", lista1);
		req.getSession().setAttribute("timovi", lista2);
		return "unosUtakmice";

	}

	public String saveKvotas(int kec, int x, int dvojka, HttpServletRequest req) {
		Utakmica u = (Utakmica) req.getSession().getAttribute("novaUt");
		Kvota keck = new Kvota();
		keck.setNaziv("kec");
		keck.setVrednost(kec);
		keck.setUtakmica(u);
		Kvota nova1 = kvr.save(keck);
		u.getKvotas().add(nova1);
		Kvota xk = new Kvota();
		xk.setNaziv("x");
		xk.setVrednost(x);
		xk.setUtakmica(u);
		Kvota nova2 = kvr.save(xk);
		u.getKvotas().add(nova2);
		Kvota dvojkak = new Kvota();
		dvojkak.setNaziv("dvojka");
		dvojkak.setVrednost(dvojka);
		dvojkak.setUtakmica(u);
		Kvota nova3 = kvr.save(dvojkak);
		u.getKvotas().add(nova3);
		if (nova1 != null && nova2 != null && nova3 != null)
			req.setAttribute("porKvota", "Kvote su uspesno dodate");
		return "unosUtakmice";
	}

	public String getSveUtakmice1(HttpServletRequest req) {
		List<Utakmica> lista = ur.findAll();
		req.getSession().setAttribute("utakmice", lista);
		return "odabirUtakmice";
	}

	public String odabranaUtakmica(Integer utakmica, HttpServletRequest req) {
		Utakmica u = ur.findById(utakmica).get();
		List<Sport> lista = sr.findAll();
		req.getSession().setAttribute("sportovi", lista);
		req.getSession().setAttribute("u", u);
		return "azurirajUtakmicu";
	}

	
	public String azuriraj(Date datum, Integer sport, HttpServletRequest req) {
		Utakmica u = (Utakmica) req.getSession().getAttribute("u");
		u.setDatumUtakmice(datum);
		u.setSport(sr.findById(sport).get());

		ur.save(u);
		req.getSession().setAttribute("poruka", "Azuriranje uspelo");
		return "azurirajUtakmicu";
	}

	public String getSveUtakmice2(HttpServletRequest req) {
		List<Utakmica> lista = ur.findAll();
		req.getSession().setAttribute("utakmice", lista);
		return "izborUtakmiceZaBrisanje";
	}

	public String brisanjeUtakmice(HttpServletRequest req, Integer utakmica) {
		Utakmica u = ur.findById(utakmica).get();
		for (Kvota k : u.getKvotas()) {
			u.removeKvota(k);
			kvr.delete(k);
		}
		ur.delete(u);
		return "index";
	}

	public String getTikets(HttpServletRequest req) {
		Registrovanikorisnik k = (Registrovanikorisnik) req.getSession().getAttribute("korisnik");
		List<Tiket> lista = tr.findByRegistrovanikorisnik(k);
		req.getSession().setAttribute("tiketiKor", lista);
		return "prikazTiketaKorisnika";
	}

	public String getSviTiketi(HttpServletRequest req) {
		List<Tiket> lista = tr.findAll();
		req.getSession().setAttribute("tiketi", lista);
		return "prikazSvihTiketa";
	}

	public void showReport1(HttpServletResponse response) throws Exception {
		Uloga u = ulogaRepo.findByNazivUloga("registrovani korisnik");
		List<Registrovanikorisnik> lista = kr.findByUloga(u);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperReports/report.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("imeKladionice", "Srecka");
		params.put("adresaKladionice", "Trg Dositeja Obradovica 6");
		params.put("brojTelefona", "014/453-266");
		params.put("email", "srecka@gmail.com");
//		params.put("korisnici", dataSource);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();

		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=ClanoviUPeriodu.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}

//	public void showReport2(HttpServletResponse response) throws Exception {
//		List<Utakmica> lista = ur.findAll();
//		Calendar now = Calendar.getInstance();
////		int currMonth = now.get(Calendar.MONTH);
////		for (Utakmica u : lista) {
////			Calendar c = Calendar.getInstance();
////			c.setTime(u.getDatumUtakmice());
////			int cMonth = c.get(Calendar.MONTH);
////			if (currMonth != cMonth)
////				lista.remove(u);
////		}
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
//		InputStream inputStream = this.getClass().getResourceAsStream("/jasperReports/report2.jrxml");
//		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("tekMesec", new SimpleDateFormat("MMMMMMMM").format(now.getTime()));
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
//		inputStream.close();
//
//		response.setContentType("application/x-download");
//		response.addHeader("Content-disposition", "attachment; filename=UtakmiceUMesecu.pdf");
//		OutputStream out = response.getOutputStream();
//		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
//	}

	public String prikazSvihKorisnika(HttpServletRequest request) {
		List<Registrovanikorisnik> lista = kr.findAll();
		request.getSession().setAttribute("korisnici", lista);
		return "prikazSvihKorisnika";
	}

	public String prikaziTiket(HttpServletRequest req) {
		Tiket t = tr.findById(Integer.parseInt(req.getParameter("idTiketa"))).get();
		double dobitak = 1.0;
		for (Utakmica u : t.getUtakmicas()) {
			dobitak *= u.getKvotas().get(0).getVrednost();
		}
		dobitak *= t.getUplata();
		req.setAttribute("t", t);
		req.setAttribute("dobitak", dobitak);
		return "prikazTiketa";
	}

	public String getUtakmiceTima(HttpServletRequest req) {
		Tim t = timr.findById((Integer) req.getAttribute("timid")).get();
		return "prikazUtakmicaTimova";
	}

	public String getUtakmiceSporta(Integer idSporta, HttpServletRequest req) {
		Integer idSport = (Integer) req.getAttribute("idSporta");
		Sport s = sr.findById(idSport).get();
		// Sport s = sr.findById(idSporta).get();
		List<Utakmica> utakmice = ur.findBySport(s);
		req.setAttribute("us", utakmice);
		return "/prikazUtakmicaSporta";
	}

	public String getKorisniciIUtakmice(HttpServletRequest req) {
		List<Registrovanikorisnik> korisnici = kr.findAll();
		List<Utakmica> utakmice = ur.findAll();
		req.setAttribute("svikorisnici", korisnici);
		req.getSession().setAttribute("sveutakmice", utakmice);
		return "unosTiketa";
	}

	public String saveTiket(HttpServletRequest req, String datumTIketa, Integer idKorisnika, Integer uplata) {
		Tiket t = new Tiket();
		Registrovanikorisnik k = kr.findById(idKorisnika).get();
		t.setRegistrovanikorisnik(k);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datum = null;
		try {
			datum = sdf.parse(datumTIketa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setDatumTIketa(datum);
		t.setUplata(uplata);
		Tiket noviTiket = tr.save(t);
		k.getTikets().add(noviTiket);
		if (noviTiket != null)
			req.setAttribute("porukaTiket", "Tiket je uspesno sacuvan");
		else
			req.setAttribute("porukaTiket", "Doslo je do greske. Tiket nije uspesno sacuvan");
		req.getSession().setAttribute("noviTiket", noviTiket);
		List<Utakmica> ut = ur.findAll();
		req.getSession().setAttribute("sveutakmice", ut);
		return "unosTiketa";
	}

	public String prikazZaSport(HttpServletRequest request, Integer sportId) {
		Sport s = sr.findById(sportId).get();
		List<Utakmica> lista = ur.findBySport(s);
		request.setAttribute("utSport", lista);
		return "sveUtakmice";
	}

	public String prikazZaTim(HttpServletRequest request, Integer timId) {
		Tim t = timr.findById(timId).get();
		List<Utakmica> lista = ur.findByTim1(t);
		List<Utakmica> lista1 = ur.findByTim2(t);
		lista.addAll(lista1);
		request.setAttribute("utTim", lista);
		return "sveUtakmice";
	}

	public String dodajUtakmicuUTiket(HttpServletRequest request, Integer idUt) {
		Utakmica u = ur.findById(idUt).get();
		System.out.println(u.getTim1().getNaziv());
		Tiket t = (Tiket) request.getSession().getAttribute("noviTiket");
		List<Utakmica> utakmice = t.getUtakmicas();
		utakmice.add(u);
		System.out.println(t.getRegistrovanikorisnik().getIme());
		t.setUtakmicas(utakmice);
		System.out.println(t.getUtakmicas());
		tr.save(t);
		return "unosTiketa";
	}

	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
			SecurityContextHolder.getContext().setAuthentication(null);
		request.getSession().setAttribute("korisnik", null);
		return "redirect:/kontroler/indexPage";
	}

}
