package ar.edu.unju.fi.html.util;

import java.util.ArrayList;

import ar.edu.unju.fi.html.entity.Provincia;



public class ListaProvincia {

	private ArrayList<Provincia> provincias;


	public ListaProvincia() {

		provincias.add(new Provincia("Buenos Aires"));
		provincias.add(new Provincia("Catamarca"));
		provincias.add(new Provincia("Chacho"));
		provincias.add(new Provincia("Chubut"));
		provincias.add(new Provincia("Cordoba"));
		provincias.add(new Provincia("Entre Rios"));
		provincias.add(new Provincia("Formosa"));
		provincias.add(new Provincia("Jujuy"));
		provincias.add(new Provincia("La Pampa"));
		provincias.add(new Provincia("La Rioja"));
		provincias.add(new Provincia("Mendoza"));
		provincias.add(new Provincia("Misiones"));
		provincias.add(new Provincia("Neuquen"));
		provincias.add(new Provincia("Rio Negro"));
		provincias.add(new Provincia("Salta"));
		provincias.add(new Provincia("San Juan"));
		provincias.add(new Provincia("San Luis"));
		provincias.add(new Provincia("Santa Cruz"));
		provincias.add(new Provincia("Santiago del Estero"));
		provincias.add(new Provincia("Tierra del Fuego"));
		provincias.add(new Provincia("Tucuman"));	
		provincias.add(new Provincia("Santa Fe"));
		provincias.add(new Provincia("Corrientes"));
		
	}
	
	public ArrayList<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(ArrayList<Provincia> provincias) {
		this.provincias = provincias;
	}
	
}
