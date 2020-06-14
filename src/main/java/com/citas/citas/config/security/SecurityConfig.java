package com.citas.citas.config.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	} 
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(encoder);
//	}
	
	// Nos vale para indicar que cualquier petición que entre deberá estar autenticada
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()	    
	    .antMatchers("/**").permitAll()
	    .anyRequest().authenticated().and().httpBasic().and().cors().configurationSource(corsConfigurationSource()); 	
	    http.csrf().disable();
	    http.headers().frameOptions().disable();
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests()
		//.antMatchers("/crearCliente").hasAuthority("ADMIN")//.permitAll
		//.antMatchers("/borrarCliente").hasAuthority("ADMIN")
		//.antMatchers("/modificarrCliente").hasAuthority("ADMIN")
		//.and().csrf().disable().httpBasic();
		//http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().httpBasic();
		http.csrf().disable().httpBasic().and().authorizeRequests().anyRequest().permitAll();
		
	}*/
	
	
	
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowedOrigins(Arrays.asList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("POST", "PUT", "GET", "DELETE", "OPTIONS"));
        corsConfig.setAllowCredentials(true);
        corsConfig.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
	
	
	
	
	
	
	
}
