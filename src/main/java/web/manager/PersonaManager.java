package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Docente;
import web.model.Estudiante;
import web.model.Persona;
import web.model.Usuario;

@Service
public class PersonaManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperPersona implements RowMapper<Persona> {
		@Override
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {

			Persona persona = new Persona();
			persona.setCodp(rs.getInt("codp"));
			persona.setNombre(rs.getString("nombre"));
			persona.setAp(rs.getString("ap"));
			persona.setAm(rs.getString("am"));
			persona.setEstado(rs.getBoolean("estado"));
			persona.setFnac(rs.getDate("fnac"));
			persona.setGenero(rs.getString("genero"));
			persona.setDirec(rs.getString("direc"));
			persona.setCelular(rs.getString("celular"));
			persona.setEcivil(rs.getString("ecivil"));
			persona.setFoto(rs.getString("foto"));
			Usuario usuario = new Usuario();
			usuario.setUsername(rs.getString("username"));
			usuario.setPassword(rs.getString("password"));
			persona.setUsuario(usuario);
//			Administrador admin = new Administrador();
//			admin.setId(rs.getString("id"));
//			persona.setAdministrador(admin);
			Docente docente = new Docente();
			docente.setCedula(rs.getString("cedula"));
			persona.setDocente(docente);
			Estudiante estudiante = new Estudiante();
			estudiante.setRu(rs.getInt("ru"));
			persona.setEstudiante(estudiante);
			return persona;
		}
	}

	private class MapperUsuario implements RowMapper<Persona> {
		@Override
		public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {

			Persona persona = new Persona();
			persona.setCodp(rs.getInt("codp"));
			persona.setNombre(rs.getString("nombre"));
			persona.setAp(rs.getString("ap"));
			persona.setAm(rs.getString("am"));
			persona.setEstado(rs.getBoolean("estado"));
			persona.setFnac(rs.getDate("fnac"));
			persona.setGenero(rs.getString("genero"));
			persona.setDirec(rs.getString("direc"));
			persona.setCelular(rs.getString("celular"));
			persona.setEcivil(rs.getString("ecivil"));
			persona.setFoto(rs.getString("foto"));

			return persona;
		}
	}

	public List<Persona> ListarPersonas() {
		String sql = " select p.codp,p.nombre,p.estado,p.fnac,p.genero,p.direc,p.celular,p.ecivil,p.foto,u.username,u.password,doc.cedula,e.ru,  "
				+ " CASE WHEN p.am is null THEN ' ' ELSE p.am END, " + " CASE WHEN p.ap is null THEN ' ' ELSE p.ap END "
				+ " from persona p " + " full join usuario u on p.codp=u.codp "
				+ " full join docente doc on doc.codp=p.codp " + " full join estudiante e on e.codp=p.codp "
				+ " order by ap,am ASC";
		return jdbcTemplate.query(sql, new MapperPersona(), new Object[] {});
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Persona ExtraerCop() {
//		BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(Persona.class);
//		String sql = " select max(p.codp) as codp from persona p where p.estado=1 ";
//		return (Persona) jdbcTemplate.queryForObject(sql, new Object[] {}, bprm);
//	}

//	public int AdicionarPersona(int codp, String ru_ci, String nombre, String ap, String am, Date fnac, String ecivil,
//			String genero, String direc, String celular) {
//		String sql = " insert into persona(nombre, ap, am, fnac, ecivil, genero, direc,celular) "
//				+ " values(?,?,?,?,?,?,?,?)";
//		jdbcTemplate.update(sql, nombre, ap, am, fnac, ecivil, genero, direc, celular);
//
//		Persona persona = new Persona();
//		persona = ExtraerCop();
//		int xcodp = persona.getCodp();
//
//		if (codp == 1) {
//			sql = " insert into estudiante(codp,ru) values(?,?)";
//			jdbcTemplate.update(sql, xcodp, ru_ci);
//		} else {
//			sql = " insert into docente(codp,cedula) values(?,?)";
//			jdbcTemplate.update(sql, xcodp, ru_ci);
//		}
//
//		return xcodp;
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int Estado(int codp, Boolean estado) {
		String sql = (estado) ? " update persona set estado=FALSE where codp=? "
				: " update persona set estado=TRUE where codp=? ";
		return jdbcTemplate.update(sql, codp);
	}

	public int ModificarFoto(int codp, String foto) {
		String sql = " update persona " + " set foto=?   " + " where codp=?  ";
		return this.jdbcTemplate.update(sql, foto, codp);
	}

	public Persona Autentificacion(String username, String password) {
		String sql = " select p.* from persona p, usuario u where u.username=? and u.password=? and u.codp=p.codp ";
		try {
			return jdbcTemplate.queryForObject(sql, new MapperUsuario(), new Object[] { username, password });
		} catch (Exception EmptyResultDataAccessException) {
			return null;
		}

	}
}
