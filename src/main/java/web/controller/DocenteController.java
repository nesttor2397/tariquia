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
import web.manager.DocenteManager;
import web.model.Docente;
import web.model.Docente;

@RestController
@RequestMapping("/docente")
@CrossOrigin(origins = "*")
public class DocenteController {
	Tools tools = new Tools();
	@Autowired
	DocenteManager docenteManager;

	@GetMapping("/listar")
	public ResponseEntity<List<Docente>> listar() {
		List<Docente> lista = docenteManager.ListarDocente();
		return new ResponseEntity<List<Docente>>(lista, HttpStatus.OK);
	}

	@PostMapping({ "/adicionar" })
	public ResponseEntity<Integer> adicionar(@RequestBody Docente docente) {
		int adicion = this.docenteManager.AdicionarDocenete(tools.Mayuscula(docente.getNombre()),
				tools.Mayuscula(docente.getAp()), tools.Mayuscula(docente.getAm()), docente.getCelular(),
				docente.getGenero(), docente.getFnac(), docente.getEcivil(), docente.getDirec(), docente.getCedula());
		return new ResponseEntity<Integer>(adicion, HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Integer> modificar(@RequestBody Docente docente) {
		int modificacion = this.docenteManager.ModificarDocente(docente.getCodp(), docente.getCedula(),
				tools.Mayuscula(docente.getNombre()), tools.Mayuscula(docente.getAp()),
				tools.Mayuscula(docente.getAm()), docente.getCelular(), docente.getGenero(),
				docente.getFnac(), docente.getEcivil(), docente.getDirec());
		return new ResponseEntity<Integer>(modificacion, HttpStatus.OK);
	}
}
