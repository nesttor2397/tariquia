package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Menus;

@Service
public class RolmeManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperRolme implements RowMapper<Menus> {
		@Override
		public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
			Menus menus = new Menus();
			menus.setCodm(rs.getInt("codm"));
			menus.setNombre(rs.getString("nombre"));
			menus.setEstado(rs.getBoolean("estado"));
			menus.setCheck(rs.getBoolean("check"));
			return menus;
		}
	}

	public List<Menus> ListarRolme(int codr) {
		String sql = " select m.*, case when r.codr=? then TRUE else FALSE end as check from  rolme r full join menus m on m.codm=r.codr ";
		return jdbcTemplate.query(sql, new MapperRolme(), new Object[] { codr });
	}

	public int AdicionarRolme(int codr, int codm) {
		String sql = " insert into rolme (codr, codm) values(?, ?) ";
		return this.jdbcTemplate.update(sql, codr, codm);
	}

	public int EliminarRolme(int codr, int codm) {
		String sql = " delete from rolme where codr=? and codm=? ";
		return this.jdbcTemplate.update(sql, codr, codm);
	}
}
