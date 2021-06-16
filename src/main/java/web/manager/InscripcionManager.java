package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Inscripcion;

@Service
public class InscripcionManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperInscripcion implements RowMapper<Inscripcion> {
		@Override
		public Inscripcion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Inscripcion inscripcion = new Inscripcion();
			inscripcion.setCodins(rs.getInt("codins"));
			inscripcion.setCodp(rs.getInt("codp"));
			inscripcion.setCodh(rs.getInt("codh"));
			inscripcion.setGestion(rs.getInt("gestion"));
			inscripcion.setPeriodo(rs.getInt("periodo"));
			inscripcion.setGrupo(rs.getInt("grupo"));
			inscripcion.setPeriodo(rs.getInt("periodo"));
			inscripcion.setFecha(rs.getDate("fecha"));
			inscripcion.setEstado(rs.getBoolean("estado"));
			return inscripcion;
		}
	}
}
