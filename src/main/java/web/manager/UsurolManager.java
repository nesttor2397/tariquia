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
public class UsurolManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperUsurol implements RowMapper<Roles> {
		@Override
		public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
			Roles rol = new Roles();
			rol.setCodr(rs.getInt("codr"));
			rol.setNombre(rs.getString("nombre"));
			rol.setEstado(rs.getBoolean("estado"));
			rol.setCheck(rs.getBoolean("check"));
			return rol;
		}
	}

	public List<Roles> ListarUsurol(String username) {
		String sql = " select r.*, case when u.username=? then TRUE else FALSE end as check from  usurol u full join roles r on r.codr=u.codr ";
		return jdbcTemplate.query(sql, new MapperUsurol(), new Object[] { username });
	}

	public int AdicionarUsurol(String username, int codr) {
		String sql = " insert into usurol (username, codr) values(?, ?) ";
		return this.jdbcTemplate.update(sql, username, codr);
	}

	public int EliminarUsurol(String username, int codr) {
		String sql = " delete from usurol where username=? and codr=? ";
		return this.jdbcTemplate.update(sql, username, codr);
	}
}
