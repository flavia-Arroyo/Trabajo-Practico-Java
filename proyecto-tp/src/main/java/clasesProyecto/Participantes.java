package clasesProyecto;

import java.util.ArrayList;

public class Participantes {
	private int idParticipante;
	private String nombreParticipante;
	private Pronostico pronostico;
	
	


	


	public Participantes(int idParticipante, String nombreParticipante, Pronostico pronostico) {
		
		this.idParticipante = idParticipante;
		this.nombreParticipante = nombreParticipante;
		this.pronostico = pronostico;
	}


	public Pronostico getPronostico() {
		return pronostico;
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
