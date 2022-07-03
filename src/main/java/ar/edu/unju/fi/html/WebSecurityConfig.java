package ar.edu.unju.fi.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.html.service.imp.LoginUsuarioEmpServiceImp;
import ar.edu.unju.fi.html.service.imp.LoginUsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AutenticacionSuccessHandler autenticacion;

	//
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**","/images/**"
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(resources).permitAll()
			.antMatchers("/","/portal","/portal2","/ciudadano/listar","/empleador/nuevoo","/empleador/guardarr","/empleador/nuevo","/empleador/listar", "/nuevoemp","/home","/loginn","/logine","/ciudadano/nuevoo","/ciudadano/guardarr","/loginciu","/loginemp").permitAll()
			.antMatchers("/empleador/guardar","/ciudadano/nuevo","/empleado/nuevo","/empleado/guardar", "/").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login");
		http.csrf().disable();
	}		

	BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
    @Autowired
    LoginUsuarioServiceImp userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    //para empleador
    @Autowired
    LoginUsuarioEmpServiceImp userrDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userrDetailsService).passwordEncoder(passwordEncoder());
    }
    
}