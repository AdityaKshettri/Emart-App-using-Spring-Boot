package emartapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import emartapp.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception 
	{
		httpSecurity
			.csrf().disable()
			.headers().frameOptions().disable()
			.and()
			.authorizeRequests()
				.antMatchers("/h2-console", "/user/login", "/buyer/signup", "/seller/signup","/buyer/save", "/seller/save").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/user/login")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/user/login");
				
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserService userService) throws Exception
	{
		auth.userDetailsService(userService);
	}
}
