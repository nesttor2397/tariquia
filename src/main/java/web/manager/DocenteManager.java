package web.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import web.model.Docente;

@Service
public class DocenteManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperDocente implements RowMapper<Docente> {
		@Override
		public Docente mapRow(ResultSet rs, int rowNum) throws SQLException {

			Docente docente = new Docente();
			docente.setCodp(rs.getInt("codp"));
			docente.setCedula(rs.getString("cedula"));
			docente.setNombre(rs.getString("nombre"));
			docente.setAp(rs.getString("ap"));
			docente.setAm(rs.getString("am"));
			docente.setEstado(rs.getBoolean("estado"));
			docente.setFnac(rs.getDate("fnac"));
			docente.setGenero(rs.getString("genero"));
			docente.setDirec(rs.getString("direc"));
			docente.setCelular(rs.getString("celular"));
			docente.setEcivil(rs.getString("ecivil"));
			docente.setFoto(rs.getString("foto"));

			return docente;
		}
	}

	public List<Docente> ListarDocente() {
		String sql = " select * from docente d inner join persona p on d.codp=p.codp " + "order by ap, am ASC ";
		return jdbcTemplate.query(sql, new MapperDocente(), new Object[] {});
	}

	public int AdicionarDocenete(String nombre, String ap, String am, String celular, String genero, Date fnac,
			String ecivil, String direc, String cedula) {
		String sql = "insert into persona(nombre,ap,am,celular,genero,fnac,ecivil,direc) "
				+ " values(?,?,?,?,?,?,?,?) returning codp as codp";
		try {
			Map<String, Object> res = this.jdbcTemplate.queryForMap(sql, nombre, ap, am, celular, genero, fnac, ecivil,
					direc);
			int codp = Integer.parseInt(res.get("codp").toString());
			sql = " insert into docente(cedula,codp) values(?,?)";
			return this.jdbcTemplate.update(sql, cedula, codp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public int ModificarDocente(int codp, String cedula, String nombre, String ap, String am, String celular,
			String genero, Date fnac, String ecivil, String direc) {
		String sql = " update persona " + " set nombre=?, ap=?, am=?, celular=?, genero=?, fnac=?, ecivil=?, direc=? "
				+ " where codp=? ";
		jdbcTemplate.update(sql, nombre, ap, am, celular, genero, fnac, ecivil, direc, codp);

		try {
			sql = " update docente set cedula=? where codp=? ";
			return this.jdbcTemplate.update(sql, cedula, codp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
