package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.manager.RestringeManager;

@RestController
@RequestMapping("/restringe")
@CrossOrigin(origins = "*")
public class RestringeController {
	@Autowired
	RestringeManager restringeManager;
}
