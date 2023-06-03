package com.systore;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.systore.security.UserSecurity;


//clase de configuracion
@Configuration
//habilitar seguridad
@EnableWebSecurity
//habilitar metodo para la clave
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encriptar() {
		return new BCryptPasswordEncoder();
	}

	//autorizacion
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	/*	http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/usuario/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build(); */
		http.csrf().disable().authorizeHttpRequests().
			requestMatchers("/usuario/**").permitAll().and().
			authorizeHttpRequests().requestMatchers("/producto/**","/categoria/**").
			authenticated().and().formLogin().loginPage("/usuario/login").
			defaultSuccessUrl("/usuario/intranet");
		return http.build();
	}

	//autentificacion
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserSecurity(); 
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider salida = new DaoAuthenticationProvider();
		//dos atributos al objeto salida
		salida.setUserDetailsService(userDetailsService());
		salida.setPasswordEncoder(encriptar());
		return salida;
	}
}

