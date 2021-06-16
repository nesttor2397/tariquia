package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.CantidadManager;

@RestController
@RequestMapping("/cantidad")
@CrossOrigin(origins = "*")
public class CantidadController {
	@Autowired
	CantidadManager cantidadManager;
}
