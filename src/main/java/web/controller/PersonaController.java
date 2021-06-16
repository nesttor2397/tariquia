package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.PersonaManager;
import web.model.Persona;
import web.config.Tools;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
	@Autowired
	PersonaManager personaManager;

	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> lista = personaManager.ListarPersonas();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/estado/{codp}/{estado}")
	public void estado(@PathVariable("codp") int codp, @PathVariable("estado") Boolean estado) {
		this.personaManager.Estado(codp, estado);
	}

}
