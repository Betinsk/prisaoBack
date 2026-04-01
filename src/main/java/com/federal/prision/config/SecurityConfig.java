package com.federal.prision.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.federal.prision.auth.JwtFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	}
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        
          .cors(cors -> {})
        
          .csrf(csrf -> csrf.disable()) 

        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**", "/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .anyRequest().authenticated()
        ) 
        
        .headers(headers -> 
            headers.frameOptions(frame -> frame.disable())
        )
        
        .sessionManagement(session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )

        .exceptionHandling(ex -> ex
        	    .authenticationEntryPoint((request, response, authException) -> {
        	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        	        response.setContentType("application/json");
        	        response.getWriter().write("{\"message\": \"Não autenticado\"}");
        	    })
        	    .accessDeniedHandler((request, response, accessDeniedException) -> {
        	        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        	        response.setContentType("application/json");
        	        response.getWriter().write("{\"message\": \"Acesso negado\"}");
        	    })
        	)
        // 👇 seu filtro continua aqui
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}