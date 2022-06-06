package pe.company.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bar")
public class Bar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteId;

	@Column
	private String tragos;

	@Column
	private String bebidas;

	@OneToOne
	@JoinColumn(name = "cocinaId", nullable = false, unique = true)
	private Cocina cocina;

	@ManyToMany
	@JoinTable(name = "mesero_bar", joinColumns = @JoinColumn(name = "meseroId"), inverseJoinColumns = @JoinColumn(name = "barId"))
	private Set<Mesero> itemsMesero = new HashSet<>();

	public Bar() {
	}

	public Bar(Integer clienteId, String tragos, String bebidas) {
		this.clienteId = clienteId;
		this.tragos = tragos;
		this.bebidas = bebidas;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getTragos() {
		return tragos;
	}

	public void setTragos(String tragos) {
		this.tragos = tragos;
	}

	public String getBebidas() {
		return bebidas;
	}

	public void setBebidas(String bebidas) {
		this.bebidas = bebidas;
	}
}
