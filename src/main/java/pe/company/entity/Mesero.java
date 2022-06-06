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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mesero")
public class Mesero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer meseroId;

	@Column
	private String nombre;

	@Column
	private Integer monto;

	@ManyToOne
	@JoinColumn(name = "clienteId", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "jefeId", nullable = false)
	private Jefe jefe;

	@ManyToMany(mappedBy = "itemsMesero")
	private Set<Bar> itemsBar = new HashSet<>();

	public Mesero() {
	}

	public Mesero(Integer meseroId, String nombre, Integer monto) {
		this.meseroId = meseroId;
		this.nombre = nombre;
		this.monto = monto;
	}

	public Integer getMeseroId() {
		return meseroId;
	}

	public void setMeseroId(Integer meseroId) {
		this.meseroId = meseroId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
