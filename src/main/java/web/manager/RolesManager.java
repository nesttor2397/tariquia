package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Roles;

@Service
public class RolesManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperRoles implements RowMapper<Roles> {
		@Override
		public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
			Roles rol = new Roles();
			rol.setCodr(rs.getInt("codr"));
			rol.setNombre(rs.getString("nombre"));
			rol.setEstado(rs.getBoolean("estado"));
			return rol;
		}
	}

	public List<Roles> ListarRolesUsuario(String username) {
		String sql = " select * from roles r,usurol u where r.codr=u.codr and u.username=? " + " order by r.nombre desc ";
		return jdbcTemplate.query(sql, new MapperRoles(), new Object[] { username });
	}

	public List<Roles> ListarRoles() {
		String sql = " select * from roles ";
		return jdbcTemplate.query(sql, new MapperRoles(), new Object[] {});
	}

	public int AdicionarRol(String nombre) {
		String sql = " insert into roles(nombre) values( ? ) ";
		return this.jdbcTemplate.update(sql, nombre);
	}

	public int ModificarRol(String nombre, int codr) {
		String sql = " update roles set nombre=? where codr=? ";
		return this.jdbcTemplate.update(sql, nombre, codr);
	}

	public int Estado(int codr, Boolean estado) {
		String sql = (estado) ? " update roles set estado=FALSE where codr=? "
				: " update roles set estado=TRUE where codr=? ";
		return jdbcTemplate.update(sql, codr);
	}

}
