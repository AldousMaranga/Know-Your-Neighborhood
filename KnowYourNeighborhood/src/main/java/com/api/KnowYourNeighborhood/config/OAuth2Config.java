package com.api.KnowYourNeighborhood.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableOAuth2Sso
@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .antMatcher("/**")
//            .authorizeRequests()
//                .antMatchers("/", "/login**", "/webjars/**", "/error**")
//                .permitAll()
//            .anyRequest()
//                .authenticated();
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .antMatcher("/**")
            .authorizeRequests()
	            .antMatchers("/login").permitAll()
	            .antMatchers("/", "/messages/**", "/search", "/registerUser", "/registerBuilding", "/login**", "/webjars/**", "/error**").permitAll()
                .antMatchers("/css/**").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/js/**").permitAll()
	            .anyRequest().authenticated()
         //     .httpBasic()
            .and()
	        .logout()
	            .logoutSuccessUrl("/")
	            .permitAll()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.clearAuthentication(true)
	            .invalidateHttpSession(true);
    }
}
