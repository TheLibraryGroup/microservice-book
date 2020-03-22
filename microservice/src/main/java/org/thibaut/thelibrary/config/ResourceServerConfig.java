package org.thibaut.thelibrary.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

	private final JwtRequestFilter jwtRequestFilter;

//	@Bean
//	CorsFilter corsFilter() {
//		return new CorsFilter();
//	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//		http.addFilterBefore(corsFilter(), SessionManagementFilter.class);
        http.cors().and()
                .authorizeRequests()
                .mvcMatchers("/api/books").hasAuthority("SCOPE_thelibrary")
                .and()
                .oauth2ResourceServer()
                .jwt();
        http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );
//	    http.cors().and()
//			    .authorizeRequests()
//			    .mvcMatchers("/api/book/**").permitAll();
//	    http.authorizeRequests().antMatchers("/api/book/**").permitAll();
    }


//	private CorsConfigurationSource configurationSource() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.addAllowedOrigin("*");
//		config.setAllowCredentials(true);
//		config.addAllowedHeader("X-Requested-With");
//		config.addAllowedHeader("Content-Type");
//		config.addAllowedMethod( HttpMethod.POST);
//		config.addAllowedMethod( HttpMethod.GET);
//		source.registerCorsConfiguration("/logout", config);
//		return source;
//	}

}
