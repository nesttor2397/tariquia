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
public class MenusManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperMenus implements RowMapper<Menus> {
		@Override
		public Menus mapRow(ResultSet rs, int rowNum) throws SQLException {
			Menus menus = new Menus();
			menus.setCodm(rs.getInt("codm"));
			menus.setNombre(rs.getString("nombre"));
			menus.setEstado(rs.getBoolean("estado"));
			return menus;
		}
	}

	public List<Menus> ListarMenuRol(int codr) {
		String sql = " select * from menus m,rolme r where m.codm=r.codm and r.codr=? "
				+ " order by m.nombre asc ";
		return jdbcTemplate.query(sql, new MapperMenus(), new Object[] { codr });
	}

	public List<Menus> ListarMenus() {
		String sql = " select * from menus " + " order by menus.nombre asc ";
		return jdbcTemplate.query(sql, new MapperMenus(), new Object[] {});
	}

	public int AdicionarMenu(String nombre) {
		String sql = " insert into menus(nombre) values( ? ) ";
		return this.jdbcTemplate.update(sql, nombre);
	}

	public int ModificarMenu(String nombre, int codm) {
		String sql = " update menus set nombre=? where codm=? ";
		return this.jdbcTemplate.update(sql, nombre, codm);
	}

	public int Estado(int codm, Boolean estado) {
		String sql = (estado) ? " update menus set estado=FALSE where codm=? "
				: " update menus set estado=TRUE where codm=? ";
		return jdbcTemplate.update(sql, codm);
	}

}
