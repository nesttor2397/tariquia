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

import web.manager.RolmeManager;
import web.model.Menus;

@RestController
@RequestMapping("/rolme")
@CrossOrigin(origins = "*")
public class RolmeController {
	@Autowired
	RolmeManager rolmeManager;

	@GetMapping("/listar/{codr}")
	public ResponseEntity<List<Menus>> listar(@PathVariable("codr") int codr) {
		List<Menus> listar = this.rolmeManager.ListarRolme(codr);
		return new ResponseEntity<List<Menus>>(listar, HttpStatus.OK);
	}

	@GetMapping("/adicionar/{codr}/{codm}")
	public ResponseEntity<Integer> adicionar(@PathVariable("codr") int codr, @PathVariable("codm") int codm) {
		int adicionar = this.rolmeManager.AdicionarRolme(codr, codm);
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{codr}/{codm}")
	public ResponseEntity<Integer> eliminar(@PathVariable("codr") int codr, @PathVariable("codm") int codm) {
		int eliminar = this.rolmeManager.EliminarRolme(codr, codm);
		return new ResponseEntity<Integer>(eliminar, HttpStatus.OK);
	}
}
