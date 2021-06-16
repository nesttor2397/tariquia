package web.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Menus {
	private int codm;
	private String nombre;
	private Boolean estado;
	public Boolean check;
	private List<Procesos> procesos = new ArrayList<Procesos>();

	public int getCodm() {
		return codm;
	}

	public void setCodm(int codm) {
		this.codm = codm;
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

	public List<Procesos> getProcesos() {
		return procesos;
	}

	public void setProcesos(List<Procesos> procesos) {
		this.procesos = procesos;
	}

}
