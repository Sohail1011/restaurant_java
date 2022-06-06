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
@Table(name = "jefe")
public class Jefe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jefeId;

	@Column
	private String nombre;

	@Column
	private Integer telefono;

	@OneToMany(mappedBy = "jefe")
	private Collection<Mesero> itemsMesero = new ArrayList<>();

	public Jefe() {
	}

	public Jefe(Integer jefeId, String nombre, Integer telefono) {
		this.jefeId = jefeId;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Integer getJefeId() {
		return jefeId;
	}

	public void setJefeId(Integer jefeId) {
		this.jefeId = jefeId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Collection<Mesero> getItemsMesero() {
		return itemsMesero;
	}

	public void setItemsMesero(Collection<Mesero> itemsMesero) {
		this.itemsMesero = itemsMesero;
	}
}
