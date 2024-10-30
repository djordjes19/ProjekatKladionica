package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tim database table.
 * 
 */
@Entity
@NamedQuery(name="Tim.findAll", query="SELECT t FROM Tim t")
public class Tim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTim;

	private String naziv;

	//bi-directional many-to-one association to Utakmica
	@OneToMany(mappedBy="tim1")
	private List<Utakmica> utakmicas1;

	//bi-directional many-to-one association to Utakmica
	@OneToMany(mappedBy="tim2")
	private List<Utakmica> utakmicas2;

	public Tim() {
	}

	public int getIdTim() {
		return this.idTim;
	}

	public void setIdTim(int idTim) {
		this.idTim = idTim;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Utakmica> getUtakmicas1() {
		return this.utakmicas1;
	}

	public void setUtakmicas1(List<Utakmica> utakmicas1) {
		this.utakmicas1 = utakmicas1;
	}

	public Utakmica addUtakmicas1(Utakmica utakmicas1) {
		getUtakmicas1().add(utakmicas1);
		utakmicas1.setTim1(this);

		return utakmicas1;
	}

	public Utakmica removeUtakmicas1(Utakmica utakmicas1) {
		getUtakmicas1().remove(utakmicas1);
		utakmicas1.setTim1(null);

		return utakmicas1;
	}

	public List<Utakmica> getUtakmicas2() {
		return this.utakmicas2;
	}

	public void setUtakmicas2(List<Utakmica> utakmicas2) {
		this.utakmicas2 = utakmicas2;
	}

	public Utakmica addUtakmicas2(Utakmica utakmicas2) {
		getUtakmicas2().add(utakmicas2);
		utakmicas2.setTim2(this);

		return utakmicas2;
	}

	public Utakmica removeUtakmicas2(Utakmica utakmicas2) {
		getUtakmicas2().remove(utakmicas2);
		utakmicas2.setTim2(null);

		return utakmicas2;
	}

}