package web.model;

import java.util.Date;

public class Identificacion {
	private int codid;
	private String codigo;
	private Date fecha;
	private boolean estado;
	private String token;

	public int getCodid() {
		return codid;
	}

	public void setCodid(int codid) {
		this.codid = codid;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
