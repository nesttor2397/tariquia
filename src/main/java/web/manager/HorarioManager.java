package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Horario;

@Service
public class HorarioManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class MapperHorario implements RowMapper<Horario> {
		@Override
		public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Horario horario=new Horario();
			horario.setCodh(rs.getInt("codh"));
			horario.setCoda(rs.getInt("coda"));
			horario.setDia(rs.getString("dia"));
			horario.setComienza(rs.getDate("comienza"));
			horario.setTermina(rs.getDate("termina"));
			horario.setEstado(rs.getBoolean("estado"));
			return horario;
		}
	}
}
