package web.model;

public class Aulas {
	private int coda;
	private String nombre;
	private String edificio;
	private int capacidad;
	private boolean estado;

	public int getCoda() {
		return coda;
	}

	public void setCoda(int coda) {
		this.coda = coda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
