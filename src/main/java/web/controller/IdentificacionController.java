package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.IdentificacionManager;

@RestController
@RequestMapping("/indentificacion")
@CrossOrigin(origins = "*")
public class IdentificacionController {
	@Autowired
	IdentificacionManager identificacionManager;
}
