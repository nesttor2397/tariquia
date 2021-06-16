package web.model;

import java.util.Date;

public class Horario {
	private int codh;
	private int coda;
	private String dia;
	private Date comienza;
	private Date termina;
	private boolean estado;

	public int getCodh() {
		return codh;
	}

	public void setCodh(int codh) {
		this.codh = codh;
	}

	public int getCoda() {
		return coda;
	}

	public void setCoda(int coda) {
		this.coda = coda;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getComienza() {
		return comienza;
	}

	public void setComienza(Date comienza) {
		this.comienza = comienza;
	}

	public Date getTermina() {
		return termina;
	}

	public void setTermina(Date termina) {
		this.termina = termina;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
