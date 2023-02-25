package com.liceolapaz.mdm.PracticaMDM.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class DatabaseWebConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests().antMatchers("/boostrap/**").permitAll().antMatchers("/signup").permitAll().antMatchers("/bcrypt/**").permitAll().antMatchers("/saveUser").permitAll()
			.antMatchers("/").hasAnyAuthority("USUARIO", "ADMINISTRADOR")
			.antMatchers("/addSucursal/**").hasAnyAuthority("ADMINISTRADOR")
			.antMatchers("/insertGame").hasAnyAuthority("ADMINISTRADOR").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
