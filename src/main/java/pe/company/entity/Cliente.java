package pe.company.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clienteId;

	@Column
	private String nombre;

	@Column
	private Integer monto;

	@OneToMany(mappedBy = "cliente")
	private Collection<Mesero> itemsMesero = new ArrayList<>();

	public Cliente() {
	}

	public Cliente(Integer clienteId, String nombre, Integer monto) {
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.monto = monto;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
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

	public Collection<Mesero> getItemsMesero() {
		return itemsMesero;
	}

	public void setItemsMesero(Collection<Mesero> itemsMesero) {
		this.itemsMesero = itemsMesero;
	}
}
