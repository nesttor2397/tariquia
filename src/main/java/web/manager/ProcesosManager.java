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
public class ProcesosManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperProcesos implements RowMapper<Procesos> {
		@Override
		public Procesos mapRow(ResultSet rs, int rowNum) throws SQLException {

			Procesos procesos = new Procesos();
			procesos.setCodpro(rs.getInt("codpro"));
			procesos.setNombre(rs.getString("nombre"));
			procesos.setEnlace(rs.getString("enlace"));
			procesos.setDescripcion(rs.getString("descripcion"));
			procesos.setEstado(rs.getBoolean("estado"));
			return procesos;
		}
	}

	public List<Procesos> ListarProcesoMenu(int codm) {
		String sql = " select * from procesos p, mepro m where p.codpro=m.codpro and  m.codm=? "
				+ " order by p.nombre desc ";
		return jdbcTemplate.query(sql, new MapperProcesos(), new Object[] { codm });
	}

	public List<Procesos> ListarProcesos() {
		String sql = " select * from procesos " + " order by procesos.nombre desc ";
		return jdbcTemplate.query(sql, new MapperProcesos(), new Object[] {});
	}

	public int AdicionarProceso(String nombre, String enlace, String descripcion) {
		String sql = " insert into procesos(nombre, enlace, descripcion) values( ?, ?, ? ) ";
		return this.jdbcTemplate.update(sql, nombre, enlace, descripcion);
	}

	public int ModificarProceso(String nombre, String enlace, String descripcion, int codpro) {
		String sql = " update procesos set nombre=?, enlace=?, descripcion=? where codpro=? ";
		return this.jdbcTemplate.update(sql, nombre, enlace, descripcion, codpro);
	}

	public int Estado(int codpro, Boolean estado) {
		String sql = (estado) ? " update procesos set estado=FALSE where codpro=? "
				: " update procesos set estado=TRUE where codpro=? ";
		return jdbcTemplate.update(sql, codpro);
	}

}
