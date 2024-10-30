package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the registrovanikorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Registrovanikorisnik.findAll", query="SELECT r FROM Registrovanikorisnik r")
public class Registrovanikorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnika;

	private String adresa;

	private String ime;

	private String korisnickoIme;

	private String prezime;

	private String sifra;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Tiket
	@OneToMany(mappedBy="registrovanikorisnik")
	private List<Tiket> tikets;

	//bi-directional many-to-one association to Utakmica
	@OneToMany(mappedBy="registrovanikorisnik")
	private List<Utakmica> utakmicas;

	public Registrovanikorisnik() {
	}

	public int getIdKorisnika() {
		return this.idKorisnika;
	}

	public void setIdKorisnika(int idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Tiket> getTikets() {
		return this.tikets;
	}

	public void setTikets(List<Tiket> tikets) {
		this.tikets = tikets;
	}

	public Tiket addTiket(Tiket tiket) {
		getTikets().add(tiket);
		tiket.setRegistrovanikorisnik(this);

		return tiket;
	}

	public Tiket removeTiket(Tiket tiket) {
		getTikets().remove(tiket);
		tiket.setRegistrovanikorisnik(null);

		return tiket;
	}

	public List<Utakmica> getUtakmicas() {
		return this.utakmicas;
	}

	public void setUtakmicas(List<Utakmica> utakmicas) {
		this.utakmicas = utakmicas;
	}

	public Utakmica addUtakmica(Utakmica utakmica) {
		getUtakmicas().add(utakmica);
		utakmica.setRegistrovanikorisnik(this);

		return utakmica;
	}

	public Utakmica removeUtakmica(Utakmica utakmica) {
		getUtakmicas().remove(utakmica);
		utakmica.setRegistrovanikorisnik(null);

		return utakmica;
	}

}