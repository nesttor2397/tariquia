	package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.config.Tools;
import web.manager.MenusManager;
import web.manager.ProcesosManager;
import web.model.Procesos;
import web.model.Procesos;

@RestController
@RequestMapping("/procesos")
@CrossOrigin(origins = "*")
public class ProcesosController {
	Tools tools = new Tools();
	@Autowired
	ProcesosManager procesosManager;
	@Autowired
	MenusManager menusManager;

	@GetMapping("/proceso/{codm}")
	public ResponseEntity<List<Procesos>> proceso(@PathVariable("codm") int codm) {
		List<Procesos> proceso = this.procesosManager.ListarProcesoMenu(codm);
		return new ResponseEntity<List<Procesos>>(proceso, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Procesos>> listar() {
		List<Procesos> listar = this.procesosManager.ListarProcesos();
		return new ResponseEntity<List<Procesos>>(listar, HttpStatus.OK);
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Integer> adicionar(@RequestBody Procesos procesos) {
		int adicionar = this.procesosManager.AdicionarProceso(procesos.getNombre(),
				procesos.getEnlace(), procesos.getDescripcion());
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@PutMapping("/modificar")
	public ResponseEntity<Integer> modificar(@RequestBody Procesos procesos) {
		int modificar = this.procesosManager.ModificarProceso(procesos.getNombre(),
				procesos.getEnlace(), procesos.getDescripcion(), procesos.getCodpro());
		return new ResponseEntity<Integer>(modificar, HttpStatus.OK);
	}

	@GetMapping("/estado/{codpro}/{estado}")
	public void estado(@PathVariable("codpro") int codpro, @PathVariable("estado") Boolean estado) {
		this.procesosManager.Estado(codpro, estado);
	}
}
