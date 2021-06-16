package web.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Persona {
	public int codp;
	public String nombre;
	public String ap;
	public String am;
	public Boolean estado;
	public Date fnac;
	public String genero;
	public String direc;
	public String celular;
	public String foto;
	public String ecivil;
//	@JsonInclude(JsonInclude.Include.ALWAYS)

	private Usuario usuario;
//	@JsonInclude(JsonInclude.Include.ALWAYS)

	private Administrador administrador;
//	@JsonInclude(JsonInclude.Include.ALWAYS)

	private Docente docente;
//	@JsonInclude(JsonInclude.Include.ALWAYS)

	private Estudiante estudiante;

	public int getCodp() {
		return codp;
	}

	public void setCodp(int codp) {
		this.codp = codp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFnac() {
		return fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDirec() {
		return direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEcivil() {
		return ecivil;
	}

	public void setEcivil(String ecivil) {
		this.ecivil = ecivil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
