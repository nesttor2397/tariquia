package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Identificacion;
import web.model.Temperatura;

@Service
public class TemperaturaManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class MapperTemperatura implements RowMapper<Temperatura> {
		@Override
		public Temperatura mapRow(ResultSet rs, int rowNum) throws SQLException {
			Temperatura temperatura = new Temperatura();
			temperatura.setCodt(rs.getInt("codt"));
			temperatura.setGrados(rs.getDouble("grados"));
			temperatura.setFecha(rs.getDate("fecha"));
			temperatura.setEstado(rs.getBoolean("estado"));
			temperatura.setToken(rs.getString("token"));
			return temperatura;
		}
	}
}
