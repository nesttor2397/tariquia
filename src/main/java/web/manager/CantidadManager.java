package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Cantidad;
import web.model.Temperatura;

@Service
public class CantidadManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class MapperCantidad implements RowMapper<Cantidad> {
		@Override
		public Cantidad mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cantidad cantidad = new Cantidad();
			cantidad.setCodc(rs.getInt("codc"));
			cantidad.setCoda(rs.getInt("coda"));
			cantidad.setCupo(rs.getInt("grados"));
			cantidad.setAccion(rs.getString("accion"));
			cantidad.setFecha(rs.getDate("fecha"));
			cantidad.setEstado(rs.getBoolean("estado"));
			return cantidad;
		}
	}
}
