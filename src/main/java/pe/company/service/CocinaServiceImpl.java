package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.entity.Cocina;
import pe.company.repository.CocinaRepository;

@Service
public class CocinaServiceImpl implements CocinaService {

	@Autowired
	private CocinaRepository cocinaRepository;

	@Override
	@Transactional(readOnly = false)
	public void insert(Cocina cocina) {
		cocinaRepository.save(cocina);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Cocina cocina) {
		cocinaRepository.save(cocina);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer cocinaId) {
		cocinaRepository.deleteById(cocinaId);
	}

	@Override
	@Transactional(readOnly = true)
	public Cocina findById(Integer cocinaId) {
		return cocinaRepository.findById(cocinaId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cocina> findAll() {
		return cocinaRepository.findAll();
	}

}
