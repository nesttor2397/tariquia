package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.CalificacionManager;

@RestController
@RequestMapping("/calificacion")
@CrossOrigin(origins = "*")
public class CalificacionController {
	@Autowired
	CalificacionManager calificacionManager;
}
