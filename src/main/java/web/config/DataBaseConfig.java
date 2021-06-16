package web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Component
public class DataBaseConfig {
	@Autowired
	private Environment env;
	public JdbcTemplate db;
	public String sql;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.env.getProperty("db.driver"));
		dataSource.setUrl(this.env.getProperty("db.url"));
		dataSource.setUsername(this.env.getProperty("db.username"));
		dataSource.setPassword(this.env.getProperty("db.password"));

		return dataSource;
	}
}
