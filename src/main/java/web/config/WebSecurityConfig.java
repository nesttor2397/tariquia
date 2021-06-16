//package web.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import web.manager.UsuarioManager;
//
//@Configuration
//@EnableWebSecurity
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
////	@Autowired
////	private BCryptPasswordEncoder passEncoder;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery(" select * from usuario where username=? ")
////				.authoritiesByUsernameQuery(" select u.username, r.nombre from roles r inner join usuario u on r.codp=e.codp where u.username=? ");
//				;
//	}
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests()
////		.antMatchers("/").permitAll()
////		.antMatchers("/persona").hasRole("ADMIN")
////		.antMatchers("/docente").hasRole("ADMIN")
////		.antMatchers("/estudiante").hasRole("ADMIN")
////		.antMatchers("").hasAnyRole("ADMIN", "USUARIO")
////		.and()
////		.formLogin().permitAll()
////		.and()
////		.logout().permitAll();
////	}
////	
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(usuarioManager);
////	}
//
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests().antMatchers("/usuario").permitAll().anyRequest().authenticated()
////				.and()
////				.addFilterBefore(new LoginFilter("/usuario", authenticationManager()),
////						UsernamePasswordAuthenticationFilter.class)
////				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
//////	     http.httpBasic().disable();
////
////	}
//
//
//}
