package web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestringeManager {
	@Autowired
	private JdbcTemplate jdbcTemplate;
}
