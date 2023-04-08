package clasesProyecto;

import java.util.ArrayList;
import java.util.List;

public class Pronostico {
	private int idPronostico;
	private String participante;
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	
	
	
	
	

	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", participante=" + participante + ", partido=" + partido
				+ ", equipo=" + equipo + ", resultadoPronostico=" + resultadoPronostico + "]";
	}



	public Pronostico(int idPronostico, String participante, Partido partido, Equipos equipo,
			Resultado resultadoPronostico) {
	
		this.idPronostico = idPronostico;
		this.participante = participante;
		this.partido = partido;
		this.equipo = equipo;
		this.resultadoPronostico = resultadoPronostico;
	}



	



	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public int getIdPronostico() {
		return idPronostico;
	}

	public void setIdPronostico(int idPronostico) {
		this.idPronostico = idPronostico;
	}


	


	public String getParticipante() {
		return participante;
	}


	public void setParticipante(String participante) {
		this.participante = participante;
	}


	public int obtenerPuntos() {
		//float puntos = 0;
			
		Resultado resultadoReal = partido.obtenerResultado(equipo, partido.getIdronda());
		if(this.resultadoPronostico.equals(resultadoReal)){
			
			return  1;
		} else {
			return 0; 
		}
		
	
	}
	
	public int puntosApostador(String apostador) {
		int parcial= 0;
		int acumulador = 0;
		
		
		if (this.participante.equals(apostador)) {
				
			parcial = this.obtenerPuntos();		
		}

		if(parcial >0) {
			acumulador += parcial;
			
		}
		
		return acumulador;
		
		
		
	}
	
	

	public Equipos getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipos equipo) {
		this.equipo = equipo;
	}


	public Resultado getResultadoPronostico() {
		return resultadoPronostico;
	}


	public void setResultadoPronostico(Resultado resultadoPronostico) {
		this.resultadoPronostico = resultadoPronostico;
	}
	
	
	
	
	
	
	
	

}
