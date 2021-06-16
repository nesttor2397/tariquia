package web.model;

public class Usuario extends Persona {
	private String username;
	private int codp;
	public Boolean estado;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCodp() {
		return codp;
	}

	public void setCodp(int codp) {
		this.codp = codp;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
