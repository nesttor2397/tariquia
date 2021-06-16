package web.model;

import java.util.Date;

public class Cantidad {
	private int codc;
	private int coda;
	private int cupo;
	private String accion;
	private Date fecha;
	private boolean estado;

	public int getCodc() {
		return codc;
	}

	public void setCodc(int codc) {
		this.codc = codc;
	}

	public int getCoda() {
		return coda;
	}

	public void setCoda(int coda) {
		this.coda = coda;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
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

}
