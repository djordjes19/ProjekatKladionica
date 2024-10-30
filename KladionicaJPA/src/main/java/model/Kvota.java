package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the kvota database table.
 * 
 */
@Entity
@NamedQuery(name="Kvota.findAll", query="SELECT k FROM Kvota k")
public class Kvota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKvota;

	private String naziv;

	private int vrednost;

	//bi-directional many-to-one association to Utakmica
	@ManyToOne
	private Utakmica utakmica;

	public Kvota() {
	}

	public int getIdKvota() {
		return this.idKvota;
	}

	public void setIdKvota(int idKvota) {
		this.idKvota = idKvota;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getVrednost() {
		return this.vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}

	public Utakmica getUtakmica() {
		return this.utakmica;
	}

	public void setUtakmica(Utakmica utakmica) {
		this.utakmica = utakmica;
	}

}