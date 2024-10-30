package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utakmica database table.
 * 
 */
@Entity
@NamedQuery(name="Utakmica.findAll", query="SELECT u FROM Utakmica u")
public class Utakmica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtakmica;

	@Temporal(TemporalType.DATE)
	private Date datumUtakmice;

	private int kvota_idKvota;

	//bi-directional many-to-one association to Kvota
	@OneToMany(mappedBy="utakmica")
	private List<Kvota> kvotas;

	//bi-directional many-to-one association to Registrovanikorisnik
	@ManyToOne
	private Registrovanikorisnik registrovanikorisnik;

	//bi-directional many-to-one association to Sport
	@ManyToOne
	private Sport sport;

	//bi-directional many-to-one association to Tim
	@ManyToOne
	@JoinColumn(name="Tim_idTim")
	private Tim tim1;

	//bi-directional many-to-one association to Tim
	@ManyToOne
	@JoinColumn(name="Tim_idTim1")
	private Tim tim2;

	//bi-directional many-to-many association to Tiket
	@ManyToMany
	@JoinTable(
		name="utakmica_has_tiket"
		, joinColumns={
			@JoinColumn(name="Utakmica_idUtakmica")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Tiket_idTiket")
			}
		)
	private List<Tiket> tikets;

	public Utakmica() {
	}

	public int getIdUtakmica() {
		return this.idUtakmica;
	}

	public void setIdUtakmica(int idUtakmica) {
		this.idUtakmica = idUtakmica;
	}

	public Date getDatumUtakmice() {
		return this.datumUtakmice;
	}

	public void setDatumUtakmice(Date datumUtakmice) {
		this.datumUtakmice = datumUtakmice;
	}

	public int getKvota_idKvota() {
		return this.kvota_idKvota;
	}

	public void setKvota_idKvota(int kvota_idKvota) {
		this.kvota_idKvota = kvota_idKvota;
	}

	public List<Kvota> getKvotas() {
		return this.kvotas;
	}

	public void setKvotas(List<Kvota> kvotas) {
		this.kvotas = kvotas;
	}

	public Kvota addKvota(Kvota kvota) {
		getKvotas().add(kvota);
		kvota.setUtakmica(this);

		return kvota;
	}

	public Kvota removeKvota(Kvota kvota) {
		getKvotas().remove(kvota);
		kvota.setUtakmica(null);

		return kvota;
	}

	public Registrovanikorisnik getRegistrovanikorisnik() {
		return this.registrovanikorisnik;
	}

	public void setRegistrovanikorisnik(Registrovanikorisnik registrovanikorisnik) {
		this.registrovanikorisnik = registrovanikorisnik;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Tim getTim1() {
		return this.tim1;
	}

	public void setTim1(Tim tim1) {
		this.tim1 = tim1;
	}

	public Tim getTim2() {
		return this.tim2;
	}

	public void setTim2(Tim tim2) {
		this.tim2 = tim2;
	}

	public List<Tiket> getTikets() {
		return this.tikets;
	}

	public void setTikets(List<Tiket> tikets) {
		this.tikets = tikets;
	}

}