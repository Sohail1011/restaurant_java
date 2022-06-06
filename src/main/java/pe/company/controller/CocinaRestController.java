package pe.company.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.company.entity.Cocina;
import pe.company.service.CocinaService;

@RestController
@RequestMapping("/cocina")
public class CocinaRestController {

	@Autowired
	private CocinaService cocinaService;

	public CocinaRestController() {
	}

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		Collection<Cocina> collection = cocinaService.findAll();

		if (collection.isEmpty()) {
			return new ResponseEntity<>("No hay ningun dato", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(collection, HttpStatus.OK);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Cocina cocina) {
		cocinaService.insert(cocina);
		return new ResponseEntity<>("Se registro un nuevo dato", HttpStatus.OK);
	}

	@PutMapping("/editar/{cocinaId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Cocina cocinaEdit, @PathVariable Integer cocinaId) {

		Cocina cocinaDb = cocinaService.findById(cocinaId);

		if (cocinaDb != null) {
			cocinaDb.setComida(cocinaEdit.getComida());
			cocinaDb.setIngredientes(cocinaEdit.getIngredientes());
			cocinaService.update(cocinaDb);
			return new ResponseEntity<>("Se actualizo los datos", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se encontró los datos", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/borrar/{cocinaId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer cocinaId) {

		Cocina cocinaDb = cocinaService.findById(cocinaId);

		if (cocinaDb != null) {
			cocinaService.delete(cocinaId);
			return new ResponseEntity<>("Se borro los datos", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No se pudo eliminar el codigo seleccionado", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/buscar/{cocinaId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer cocinaId) {
		Cocina cocinaDb = cocinaService.findById(cocinaId);

		if (cocinaDb != null) {
			return new ResponseEntity<>(cocinaDb, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("No se pudo encontrar el codigo solicitado", HttpStatus.NOT_FOUND);
		}
	}
}
