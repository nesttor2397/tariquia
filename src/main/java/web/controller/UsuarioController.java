package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.config.Tools;
import web.manager.PersonaManager;
import web.manager.UsuarioManager;
import web.model.Persona;
import web.model.Usuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	Tools tools = new Tools();

	@Autowired
	UsuarioManager usuarioManager;
	@Autowired
	PersonaManager personaManager;

	HttpSession SESION;

	@PostMapping({ "/conectar" })
	public ResponseEntity<Persona> conectar(@RequestBody Usuario usuario, HttpServletRequest rq) {
		Persona persona = personaManager.Autentificacion(usuario.getUsername(), usuario.getPassword());
		if (persona != null) {
			SESION = rq.getSession();
			SESION.setAttribute("Usuario", persona);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@GetMapping({ "/desconectar" })
	public boolean desconectar(HttpServletRequest rq) {
		try {
			SESION = rq.getSession();
			SESION.invalidate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> lista = usuarioManager.ListarUsuarios();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
	}

	@PostMapping({ "/adicionar" })
	public ResponseEntity<Integer> adicionar(@RequestBody Usuario usuario) {
		int adicionar = this.usuarioManager.AdicionarUsuario(usuario.getUsername(), usuario.getCodp(),
				tools.Codificar(usuario.getPassword()));
		return new ResponseEntity<Integer>(adicionar, HttpStatus.OK);
	}

	@PutMapping({ "/modificar" })
	public ResponseEntity<Integer> modificar(@RequestBody Usuario usuario) {
		int modificar = this.usuarioManager.ModificarUsuario(tools.Codificar(usuario.getPassword()), usuario.getCodp());
		return new ResponseEntity<Integer>(modificar, HttpStatus.OK);
	}

	@GetMapping({ "/username" })
	public boolean existe(@RequestParam String username) {
		return this.usuarioManager.Existe(username);
	}

}
