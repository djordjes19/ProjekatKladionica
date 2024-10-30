package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String nazivUloga;

	//bi-directional many-to-one association to Registrovanikorisnik
	@OneToMany(mappedBy="uloga")
	private List<Registrovanikorisnik> registrovanikorisniks;

	public Uloga() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNazivUloga() {
		return this.nazivUloga;
	}

	public void setNazivUloga(String nazivUloga) {
		this.nazivUloga = nazivUloga;
	}

	public List<Registrovanikorisnik> getRegistrovanikorisniks() {
		return this.registrovanikorisniks;
	}

	public void setRegistrovanikorisniks(List<Registrovanikorisnik> registrovanikorisniks) {
		this.registrovanikorisniks = registrovanikorisniks;
	}

	public Registrovanikorisnik addRegistrovanikorisnik(Registrovanikorisnik registrovanikorisnik) {
		getRegistrovanikorisniks().add(registrovanikorisnik);
		registrovanikorisnik.setUloga(this);

		return registrovanikorisnik;
	}

	public Registrovanikorisnik removeRegistrovanikorisnik(Registrovanikorisnik registrovanikorisnik) {
		getRegistrovanikorisniks().remove(registrovanikorisnik);
		registrovanikorisnik.setUloga(null);

		return registrovanikorisnik;
	}

}