package pe.company.service;

import java.util.Collection;

import pe.company.entity.Cocina;

public interface CocinaService {

	public abstract void insert(Cocina cocina);

	public abstract void update(Cocina cocina);

	public abstract void delete(Integer cocinaId);

	public abstract Cocina findById(Integer cocinaId);

	public abstract Collection<Cocina> findAll();
}
