package web.model;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Roles {
	private int codr;
	private String nombre;
	private Boolean estado;
	public Boolean check;
	private List<Menus> menus = new ArrayList<>();

	public int getCodr() {
		return codr;
	}

	public void setCodr(int codr) {
		this.codr = codr;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

}
