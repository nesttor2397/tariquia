package web.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Tools {

	public String Codificar(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	public String Mayuscula(String elemento) {
		if (elemento == null) {
			elemento = "";
		} else {
			elemento = elemento.toUpperCase();
		}
		return elemento;
	}
}
