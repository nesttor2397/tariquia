package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Procesos;

@Service
public class MeproManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperMepro implements RowMapper<Procesos> {
		@Override
		public Procesos mapRow(ResultSet rs, int rowNum) throws SQLException {

			Procesos procesos = new Procesos();
			procesos.setCodpro(rs.getInt("codpro"));
			procesos.setNombre(rs.getString("nombre"));
			procesos.setEnlace(rs.getString("enlace"));
			procesos.setDescripcion(rs.getString("descripcion"));
			procesos.setEstado(rs.getBoolean("estado"));
			procesos.setCheck(rs.getBoolean("check"));
			return procesos;
		}
	}

	public List<Procesos> ListarMepro(int codm) {
		String sql = " select p.*, case when m.codm=? then TRUE else FALSE end as check from mepro m full join procesos p on p.codpro=m.codm ";
		return jdbcTemplate.query(sql, new MapperMepro(), new Object[] { codm });
	}

	public int AdicionarMepro(int codm, int codpro) {
		String sql = " insert into mepro (codm, codpro) values(?, ?) ";
		return this.jdbcTemplate.update(sql, codm, codpro);
	}

	public int EliminarMepro(int codm, int codpro) {
		String sql = " delete from mepro where codm=? and codpro=? ";
		return this.jdbcTemplate.update(sql, codm, codpro);
	}
}
