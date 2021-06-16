package web.model;
	
public class Calificacion {
	private int codcal;
	private int codp;
	private String sigla;
	private double ponderacion;
	private double mesa;
	private double nota;
	private boolean estado;

	public int getCodcal() {
		return codcal;
	}

	public void setCodcal(int codcal) {
		this.codcal = codcal;
	}

	public int getCodp() {
		return codp;
	}

	public void setCodp(int codp) {
		this.codp = codp;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public double getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(double ponderacion) {
		this.ponderacion = ponderacion;
	}

	public double getMesa() {
		return mesa;
	}

	public void setMesa(double mesa) {
		this.mesa = mesa;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
