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
import web.manager.RolesManager;
import web.model.Roles;
import web.model.Menus;
import web.model.Procesos;
import web.model.Roles;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolesController {
	Tools tools = new Tools();
	@Autowired
	RolesManager rolesManager;
	@Autowired
	MenusManager menusManager;
	@Autowired
	ProcesosManager procesosManager;
	
	@GetMapping("/rol/{username}")
	public ResponseEntity<List<Roles>> rol(@PathVariable("username") String username) {
		List<Roles> rol = this.rolesManager.ListarRolesUsuario(username);
		for (Roles r : rol) {
			List<Menus> menus = menusManager.ListarMenuRol(r.getCodr());
			r.setMenus(menus);
			for (Menus m : menus) {
				List<Procesos> procesos = procesosManager.ListarProcesoMenu(m.getCodm());
				m.setProcesos(procesos);
			}
		}
		return new ResponseEntity<List<Roles>>(rol, HttpStatus.OK);
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Roles>> listar() {
		List<Roles> listar = this.rolesManager.ListarRoles();
		return new ResponseEntity<List<Roles>>(listar, HttpStatus.OK);
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Integer> adicionar(@RequestBody Roles roles) {
		int adicionar = this.rolesManager.AdicionarRol(tools.Mayuscula(roles.getNombre()));
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@PutMapping("/modificar")
	public ResponseEntity<Integer> modificar(@RequestBody Roles roles) {
		int modificar = this.rolesManager.ModificarRol(tools.Mayuscula(roles.getNombre()), roles.getCodr());
		return new ResponseEntity<Integer>(modificar, HttpStatus.OK);
	}

	@GetMapping("/estado/{codr}/{estado}")
	public void estado(@PathVariable("codr") int codr, @PathVariable("estado") Boolean estado) {
		this.rolesManager.Estado(codr, estado);
	}

}
