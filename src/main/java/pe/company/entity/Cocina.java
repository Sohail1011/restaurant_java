package pe.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cocina")
public class Cocina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cocinaId;

	@Column
	private String comida;

	@Column
	private String ingredientes;

	@OneToOne(mappedBy = "cocina")
	private Bar bar;

	public Cocina() {
	}

	public Cocina(Integer cocinaId, String comida, String ingredientes) {
		this.cocinaId = cocinaId;
		this.comida = comida;
		this.ingredientes = ingredientes;
	}

	public Integer getCocinaId() {
		return cocinaId;
	}

	public void setCocinaId(Integer cocinaId) {
		this.cocinaId = cocinaId;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
}
