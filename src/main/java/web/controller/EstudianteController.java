package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.config.Tools;
import web.manager.EstudianteManager;
import web.model.Estudiante;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = "*")
public class EstudianteController {
	Tools tools = new Tools();
	@Autowired
	EstudianteManager estudianteManager;

	@GetMapping("/listar")
	public ResponseEntity<List<Estudiante>> listar() {
		List<Estudiante> lista = estudianteManager.ListarEstudiante();
		return new ResponseEntity<List<Estudiante>>(lista, HttpStatus.OK);
	}

	@PostMapping({ "/adicionar" })
	public ResponseEntity<Integer> adicionar(@RequestBody Estudiante estudiante) {
		int adicion = this.estudianteManager.AdicionarEstudiante(tools.Mayuscula(estudiante.getNombre()),
				tools.Mayuscula(estudiante.getAp()), tools.Mayuscula(estudiante.getAm()), estudiante.getCelular(),
				estudiante.getGenero(), estudiante.getFnac(), estudiante.getEcivil(), estudiante.getDirec(),
				estudiante.getRu());
		return new ResponseEntity<Integer>(adicion, HttpStatus.OK);
	}

	@PutMapping("/modificar")
	public ResponseEntity<Integer> modificar(@RequestBody Estudiante estudiante) {
		int modificacion = this.estudianteManager.ModificarEstudiante(estudiante.getCodp(), estudiante.getRu(),
				tools.Mayuscula(estudiante.getNombre()), tools.Mayuscula(estudiante.getAp()),
				tools.Mayuscula(estudiante.getAm()), estudiante.getCelular(), estudiante.getGenero(),
				estudiante.getFnac(), estudiante.getEcivil(), estudiante.getDirec());
		return new ResponseEntity<Integer>(modificacion, HttpStatus.OK);
	}
}
