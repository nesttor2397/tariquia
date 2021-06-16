package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Protocolo;

@Service
public class ProtocoloManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperProtocolo implements RowMapper<Protocolo> {
		@Override
		public Protocolo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Protocolo protocolo = new Protocolo();
			protocolo.setCodprot(rs.getInt("codprot"));
			protocolo.setNombre(rs.getString("nombre"));
			protocolo.setEstado(rs.getBoolean("estado"));
			return protocolo;
		}
	}
}
