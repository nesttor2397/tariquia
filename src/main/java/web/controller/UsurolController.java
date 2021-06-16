package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.UsurolManager;
import web.model.Roles;

@RestController
@RequestMapping("/usurol")
@CrossOrigin(origins = "*")
public class UsurolController {
	@Autowired
	UsurolManager usurolManager;

	@GetMapping("/listar/{username}")
	public ResponseEntity<List<Roles>> listar(@PathVariable("username") String username) {
		List<Roles> listar = this.usurolManager.ListarUsurol(username);
		return new ResponseEntity<List<Roles>>(listar, HttpStatus.OK);
	}

	@GetMapping("/adicionar/{username}/{codr}")
	public ResponseEntity<Integer> adicionar(@PathVariable("username") String username,
			@PathVariable("codr") int codr) {
		int adicionar = this.usurolManager.AdicionarUsurol(username, codr);
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{username}/{codr}")
	public ResponseEntity<Integer> eliminar(@PathVariable("username") String username, @PathVariable("codr") int codr) {
		int eliminar = this.usurolManager.EliminarUsurol(username, codr);
		return new ResponseEntity<Integer>(eliminar, HttpStatus.OK);
	}
}
