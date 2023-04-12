
package clasesProyecto;

import java.util.ArrayList;
import java.util.HashMap;

public class Participantes {
	private int idParticipante;
	private String nombreParticipante;
	private ArrayList<Pronostico> pronostico;
	HashMap<Integer, Float>totalesPart = new HashMap<Integer,Float>();
	
	public void totalesParticipante (String participante) {
		float totales = 0;
		for(Pronostico pro:pronostico) {
			if(pro.getParticipante().equals(participante)) {
				float parcial = pro.obtenerPuntos();
				
				totales += parcial;
				totalesPart.put(pro.getPartido().getIdronda(), totales);
				
				
			}
				
				
			}
		for (Integer key: totalesPart.keySet()){
			System.out.println("el participante "+ participante +" en la ronda: " +  key+ " Obtuvo Total de Puntos = " + totalesPart.get(key));
		} 
		
		
			
	}
	
	
	
	


	


	public Participantes(int idParticipante, String nombreParticipante) {
		
		this.idParticipante = idParticipante;
		this.nombreParticipante = nombreParticipante;
		pronostico = new ArrayList<Pronostico>();
	}
	
	public void agregarPronostico(Pronostico p) {
		if(!existePronostico(p)) {
			this.pronostico.add(p);
			
		}
		
	}
	
	public boolean existePronostico(Pronostico p) {
		for(Pronostico pron: pronostico) {
			if((pron.getPartido() == p.getPartido()) && (pron.getEquipo() == p.getEquipo())) {
				return true;
			}
		}
		return false;
	}
	
	




	public ArrayList<Pronostico> getPronostico() {
		return pronostico;
	}

	public void setPronostico(ArrayList<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}

	public int getIdParticipante() {
		return idParticipante;
	}


	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}


	public String getNombreParticipante() {
		return nombreParticipante;
	}


	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	@Override
	public String toString() {
		return "Participantes [idParticipante=" + idParticipante + ", nombreParticipante=" + nombreParticipante
				+ ", pronostico=" + pronostico + "]";
	}


	

	
	
	
	
	
	
	
	

}
