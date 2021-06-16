package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.MateriasManager;
import web.model.Materias;

@RestController
@RequestMapping("/materias")
@CrossOrigin(origins = "*")
public class MateriasController {
	@Autowired
	MateriasManager materiasManager;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Materias>> listar() {
		List<Materias> lista = materiasManager.ListarMaterias();
		return new ResponseEntity<List<Materias>>(lista, HttpStatus.OK);
	}
}
