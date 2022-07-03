package ar.edu.unju.fi.html.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.html.entity.Ciudadano;
import ar.edu.unju.fi.html.entity.Empleador;
import ar.edu.unju.fi.html.repository.CiudadanoRepository;
import ar.edu.unju.fi.html.repository.EmpleadorRepository;

@Service
public class LoginUsuarioEmpServiceImp implements UserDetailsService {

	@Autowired
	EmpleadorRepository empleadorRepository;
	
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		// TODO Auto-generated method stub
		//ojo si usan la clase User ya que spring security tiene una igual
		//Usuario usuario = iUsuario.findById(id);
		//Empleado empleadoEncontrado = empleadoDAO.findByUsuarioUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe en la BD"));
		Empleador empleadorEncontrado = empleadorRepository.findByUsuarioUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe en la BD"));
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(empleadorEncontrado.getUsuario().getPerfil()); 
		tipos.add(grantedAuthority);
		//creo un user detal basado en usuario password
		UserDetails user = (UserDetails) new User(empleadorEncontrado.getUsuario().getUsername(), empleadorEncontrado.getUsuario().getPassword(),tipos);
		return user;
	}
}
