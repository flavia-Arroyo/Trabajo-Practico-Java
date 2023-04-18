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


	public float obtenerPuntos() {
		//float puntos = 0;
			
		Resultado resultadoReal = partido.obtenerResultado(equipo, partido.getIdronda());
		if(this.resultadoPronostico.equals(resultadoReal)){
			
			return  0.5f;
		} else {
			return 0; 
		}
		
	
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
