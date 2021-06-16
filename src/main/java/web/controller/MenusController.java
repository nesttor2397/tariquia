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
import web.model.Menus;
import web.model.Procesos;
import web.model.Menus;

@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "*")
public class MenusController {
	Tools tools = new Tools();
	@Autowired
	MenusManager menusManager;
	@Autowired
	ProcesosManager procesosManager;

	@GetMapping("/menu/{codr}")
	public ResponseEntity<List<Menus>> menu(@PathVariable("codr") int codr) {
		List<Menus> menu = this.menusManager.ListarMenuRol(codr);
		for (Menus m : menu) {
			List<Procesos> procesos = procesosManager.ListarProcesoMenu(m.getCodm());
			m.setProcesos(procesos);
		}
		return new ResponseEntity<List<Menus>>(menu, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Menus>> listar() {
		List<Menus> listar = this.menusManager.ListarMenus();
		return new ResponseEntity<List<Menus>>(listar, HttpStatus.OK);
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Integer> adicionar(@RequestBody Menus menus) {
		int adicionar = this.menusManager.AdicionarMenu(tools.Mayuscula(menus.getNombre()));
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@PutMapping("/modificar")
	public ResponseEntity<Integer> modificar(@RequestBody Menus menus) {
		int modificar = this.menusManager.ModificarMenu(tools.Mayuscula(menus.getNombre()), menus.getCodm());
		return new ResponseEntity<Integer>(modificar, HttpStatus.OK);
	}

	@GetMapping("/estado/{codm}/{estado}")
	public void estado(@PathVariable("codm") int codm, @PathVariable("estado") Boolean estado) {
		this.menusManager.Estado(codm, estado);
	}
}
