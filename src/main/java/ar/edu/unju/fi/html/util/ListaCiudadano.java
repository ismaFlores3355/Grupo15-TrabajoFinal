package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import ar.edu.unju.fi.html.entity.Ciudadano;



public class ListaCiudadano {

	private ArrayList<Ciudadano> ciudadanos;

	public ListaCiudadano() {
		
		ciudadanos = new ArrayList<Ciudadano>();
	}

	public ArrayList<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(ArrayList<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}
	
	
}
