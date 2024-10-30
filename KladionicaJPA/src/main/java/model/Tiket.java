package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tiket database table.
 * 
 */
@Entity
@NamedQuery(name="Tiket.findAll", query="SELECT t FROM Tiket t")
public class Tiket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTiket;

	@Temporal(TemporalType.DATE)
	private Date datumTIketa;

	private int uplata;

	//bi-directional many-to-one association to Registrovanikorisnik
	@ManyToOne
	private Registrovanikorisnik registrovanikorisnik;

	//bi-directional many-to-many association to Utakmica
	@ManyToMany(mappedBy="tikets")
	private List<Utakmica> utakmicas;

	public Tiket() {
	}

	public int getIdTiket() {
		return this.idTiket;
	}

	public void setIdTiket(int idTiket) {
		this.idTiket = idTiket;
	}

	public Date getDatumTIketa() {
		return this.datumTIketa;
	}

	public void setDatumTIketa(Date datumTIketa) {
		this.datumTIketa = datumTIketa;
	}

	public int getUplata() {
		return this.uplata;
	}

	public void setUplata(int uplata) {
		this.uplata = uplata;
	}

	public Registrovanikorisnik getRegistrovanikorisnik() {
		return this.registrovanikorisnik;
	}

	public void setRegistrovanikorisnik(Registrovanikorisnik registrovanikorisnik) {
		this.registrovanikorisnik = registrovanikorisnik;
	}

	public List<Utakmica> getUtakmicas() {
		return this.utakmicas;
	}

	public void setUtakmicas(List<Utakmica> utakmicas) {
		this.utakmicas = utakmicas;
	}

}