package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Aulas;

@Service
public class AulasManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperAulas implements RowMapper<Aulas> {
		@Override
		public Aulas mapRow(ResultSet rs, int rowNum) throws SQLException {
			Aulas aulas=new Aulas();
			aulas.setCoda(rs.getInt("coda"));
			aulas.setNombre(rs.getString("nombre"));
			aulas.setEdificio(rs.getString("edificio"));
			aulas.setCapacidad(rs.getInt("capacidad"));
			aulas.setEstado(rs.getBoolean("estado"));
			return aulas;
		}
	}
}
