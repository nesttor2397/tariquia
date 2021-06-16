package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Materias;

@Service
public class MateriasManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class MapperMaterias implements RowMapper<Materias> {
		@Override
		public Materias mapRow(ResultSet rs, int rowNum) throws SQLException {
			Materias materias=new Materias();
			materias.setSigla(rs.getString("sigla"));
			materias.setNombre(rs.getString("nombre"));
			materias.setCarrera(rs.getString("carrera"));
			materias.setNivel(rs.getInt("nivel"));
			materias.setEstado(rs.getBoolean("estado"));
			return materias;
		}
	}
	
	public List<Materias> ListarMaterias() {
		String sql = "  ";
		return jdbcTemplate.query(sql, new MapperMaterias(), new Object[] {});
	}
}
