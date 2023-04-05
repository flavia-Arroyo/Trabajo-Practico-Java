package clasesProyecto;

import java.util.ArrayList;

public class Pronostico {
	private int idPronostico;
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	
	
	
	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", partido=" + partido + ", equipo=" + equipo
				+ ", resultadoPronostico=" + resultadoPronostico + "]";
	}
	
	

	
	



	
	
	
	
	public Pronostico(int idPronostico, Partido partido, Equipos equipo, Resultado resultadoPronostico) {
		
		this.idPronostico = idPronostico;
		this.partido = partido;
		this.equipo = equipo;
		this.resultadoPronostico = resultadoPronostico;
	}












	public int getIdPronostico() {
		return idPronostico;
	}












	public void setIdPronostico(int idPronostico) {
		this.idPronostico = idPronostico;
	}












	public int obtenerPuntos() {
		int puntos = 0;
			
		
		if(partido.obtenerResultado(equipo) == Resultado.GANADOR) {
			puntos = 1;
		}
		if(partido.obtenerResultado(equipo) == Resultado.PERDEDOR) {
			puntos = 0;
		}
		if (partido.obtenerResultado(equipo)== Resultado.EMPATE) {
			puntos = 1;
		}
		
		return puntos;
	
	}


	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
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
