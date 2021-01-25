package com.chamila.userreg.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	 @Autowired
	    private DataSource dataSource;
	     
	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	            .dataSource(dataSource)
	            .usersByUsernameQuery("select username, password, enabled from users where username=?")
	            .authoritiesByUsernameQuery("select username, role from users where username=?");
	           
	        
	    }
	    
	    
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests().antMatchers("/css/**","/js/**", "/registration").permitAll()
            .antMatchers("/user").anonymous()
            .anyRequest().authenticated()
            .and()
        .formLogin()
			.successForwardUrl("/default_success_page") 
            .usernameParameter("email")
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()                                    
			.permitAll().and().rememberMe().key("uniqueAndSecret").tokenValiditySeconds(120);
		

	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/login").setViewName("login");
		//registry.addViewController("/registration").setViewName("registration");
	}
	
	
	@Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**");
	  }
	
}
