package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Usuario;

@Service
public class UsuarioManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperUsuario implements RowMapper<Usuario> {
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setUsername(rs.getString("username"));
			usuario.setCodp(rs.getInt("codp"));
			usuario.setEstado(rs.getBoolean("estado"));
			usuario.setPassword(rs.getString("password"));
			return usuario;
		}
	}

	public List<Usuario> ListarUsuarios() {
		String sql = " select username, codp, estado, password from usuario ";
		return jdbcTemplate.query(sql, new MapperUsuario(), new Object[] {});
	}

	public int AdicionarUsuario(String username, int codp, String password) {
		String sql = " insert into usuario(username, codp, password) values(?, ?, ?) ";
		return this.jdbcTemplate.update(sql, username, codp, password);
	}

	public int ModificarUsuario(String password, int codp) {
		String sql = " update usuario set password=? where codp=? ";
		return this.jdbcTemplate.update(sql, password, codp);
	}

	public int Estado(int codp, Boolean estado) {
		String sql = (estado) ? " update usuario set estado=FALSE where username=? "
				: " update usuario set estado=TRUE where username=? ";
		return jdbcTemplate.update(sql, codp, estado);
	}

	public boolean Existe(String username) {
		String sql = "select count(*) as disponible from usuario u where (u.username=?)";
		Map<String, Object> res = this.jdbcTemplate.queryForMap(sql, new Object[] { username });
		Integer disponible = Integer.parseInt(res.get("disponible").toString());
		return disponible == 0;
	}
}
