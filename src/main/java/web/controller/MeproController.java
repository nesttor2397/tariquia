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

import web.manager.MeproManager;
import web.model.Procesos;

@RestController
@RequestMapping("/mepro")
@CrossOrigin(origins = "*" )
public class MeproController {
	@Autowired
	MeproManager meproManager;

	@GetMapping("/listar/{codm}")
	public ResponseEntity<List<Procesos>> listar(@PathVariable("codm") int codm) {
		List<Procesos> listar = this.meproManager.ListarMepro(codm);
		return new ResponseEntity<List<Procesos>>(listar, HttpStatus.OK);
	}

	@GetMapping("/adicionar/{codm}/{codpro}")
	public ResponseEntity<Integer> adicionar(@PathVariable("codm") int codm, @PathVariable("codpro") int codpro) {
		int adicionar = this.meproManager.AdicionarMepro(codm, codpro);
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{codm}/{codpro}")
	public ResponseEntity<Integer> eliminar(@PathVariable("codm") int codm, @PathVariable("codpro") int codpro) {
		int eliminar = this.meproManager.EliminarMepro(codm, codpro);
		return new ResponseEntity<Integer>(eliminar, HttpStatus.OK);
	}
}
