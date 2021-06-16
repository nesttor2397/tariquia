package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Identificacion;

@Service
public class IdentificacionManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class MapperIdentificacion implements RowMapper<Identificacion> {
		@Override
		public Identificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Identificacion identificacion = new Identificacion();
			identificacion.setCodid(rs.getInt("codid"));
			identificacion.setCodigo(rs.getString("codigo"));
			identificacion.setFecha(rs.getDate("fecha"));
			identificacion.setEstado(rs.getBoolean("estado"));
			identificacion.setToken(rs.getString("token"));
			return identificacion;
		}
	}
}
