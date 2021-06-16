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

import web.model.Estudiante;


@Service
public class EstudianteManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class MapperEstudiante implements RowMapper<Estudiante> {
		@Override
		public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {

			Estudiante estudiante = new Estudiante();
			estudiante.setCodp(rs.getInt("codp"));
			estudiante.setRu(rs.getInt("ru"));
			estudiante.setNombre(rs.getString("nombre"));
			estudiante.setAp(rs.getString("ap"));
			estudiante.setAm(rs.getString("am"));
			estudiante.setEstado(rs.getBoolean("estado"));
			estudiante.setFnac(rs.getDate("fnac"));
			estudiante.setGenero(rs.getString("genero"));
			estudiante.setDirec(rs.getString("direc"));
			estudiante.setCelular(rs.getString("celular"));
			estudiante.setEcivil(rs.getString("ecivil"));
			estudiante.setFoto(rs.getString("foto"));

			return estudiante;
		}
	}

	public List<Estudiante> ListarEstudiante() {
		String sql = " select * from estudiante e inner join persona p on e.codp=p.codp " + " order by ap, am ASC ";
		return jdbcTemplate.query(sql, new MapperEstudiante(), new Object[] {});
	}

	public int AdicionarEstudiante(String nombre, String ap, String am, String celular, String genero, Date fnac,
			String ecivil, String direc, int ru) {
		String sql = "insert into persona(nombre,ap,am,celular,genero,fnac,ecivil,direc) "
				+ " values(?,?,?,?,?,?,?,?) returning codp as codp";
		try {
			Map<String, Object> res = this.jdbcTemplate.queryForMap(sql, nombre, ap, am, celular, genero, fnac, ecivil,
					direc);
			int codp = Integer.parseInt(res.get("codp").toString());
			sql = " insert into estudiante(ru,codp) values(?,?)";
			return this.jdbcTemplate.update(sql, ru, codp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int ExtraerCodp() {
		String sql = " select max(p.codp) as codp from persona p ";
		Map<String, Object> res = this.jdbcTemplate.queryForMap(sql);
		return Integer.parseInt(res.get("codp").toString());

	}

	public int ModificarEstudiante(int codp, int ru, String nombre, String ap, String am, String celular, String genero,
			Date fnac, String ecivil, String direc) {
		String sql = " update persona " + " set nombre=?, ap=?, am=?, celular=?, genero=?, fnac=?, ecivil=?, direc=? "
				+ " where codp=? ";
		jdbcTemplate.update(sql, nombre, ap, am, celular, genero, fnac, ecivil, direc, codp);

		try {
			sql = " update estudiante set ru=? where codp=? ";
			return this.jdbcTemplate.update(sql, ru, codp);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
