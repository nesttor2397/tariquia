package web.model;

import java.util.Date;

public class Inscripcion {
	private int codins;
	private int codp;
	private int codh;
	private int gestion;
	private int periodo;
	private int grupo;
	private int tipo;
	private Date fecha;
	private boolean estado;

	public int getCodins() {
		return codins;
	}

	public void setCodins(int codins) {
		this.codins = codins;
	}

	public int getCodp() {
		return codp;
	}

	public void setCodp(int codp) {
		this.codp = codp;
	}

	public int getCodh() {
		return codh;
	}

	public void setCodh(int codh) {
		this.codh = codh;
	}

	public int getGestion() {
		return gestion;
	}

	public void setGestion(int gestion) {
		this.gestion = gestion;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
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
