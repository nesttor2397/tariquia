package web.model;

import java.util.Date;

public class Temperatura {
	private int codt;
	private double grados;
	private Date fecha;
	private boolean estado;
	private String token;

	public int getCodt() {
		return codt;
	}

	public void setCodt(int codt) {
		this.codt = codt;
	}

	public double getGrados() {
		return grados;
	}

	public void setGrados(double grados) {
		this.grados = grados;
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
