package ar.edu.unju.fi.html;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		boolean tipoAdmin = false;
		boolean tipoConsultor = false;
		boolean tipoSocio = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("EMPLEADOR")) {
				tipoAdmin = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("CIUDADANO")) {
					tipoConsultor = true;
					break;
			} else {
				tipoSocio = true;
				break;
			}
		}
		}
		if (tipoAdmin) {
			redirectStrategy.sendRedirect(request, response, "/portal2");
		} else {
			if (tipoConsultor) {
				redirectStrategy.sendRedirect(request, response, "/portal");
		} else {
			if (tipoSocio) {
				redirectStrategy.sendRedirect(request, response, "/ciudadano/nuevoo");
			} else {
				throw new IllegalStateException();	
			}
		}			
		}
	}

}
