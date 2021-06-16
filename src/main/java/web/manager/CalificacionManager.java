package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Calificacion;

@Service
public class CalificacionManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MappeCalificacion implements RowMapper<Calificacion> {
		@Override
		public Calificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Calificacion calificacion = new Calificacion();
			calificacion.setCodcal(rs.getInt("codcal"));
			calificacion.setCodp(rs.getInt("codp"));
			calificacion.setSigla(rs.getString("sigla"));
			calificacion.setPonderacion(rs.getDouble("ponderacion"));
			calificacion.setMesa(rs.getDouble("mesa"));
			calificacion.setNota(rs.getDouble("nota"));
			calificacion.setEstado(rs.getBoolean("estado"));
		
			return calificacion;
		}
	}
}
