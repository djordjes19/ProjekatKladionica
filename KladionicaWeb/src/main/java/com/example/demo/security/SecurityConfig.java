package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				requests -> requests.requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("kladionicar")
				.requestMatchers(new AntPathRequestMatcher("/employee/**")).hasRole("employee")
						.requestMatchers(new AntPathRequestMatcher("/guest/**"))
						.hasAnyRole("kladionicar", "radnik", "gost").requestMatchers(new AntPathRequestMatcher("/**"))
						.permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login.jsp").permitAll().loginProcessingUrl("/login")
						.defaultSuccessUrl("/kontroler/guest"))
				.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
