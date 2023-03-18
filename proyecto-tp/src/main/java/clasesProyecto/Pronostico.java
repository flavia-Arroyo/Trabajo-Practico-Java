package clasesProyecto;

public class Pronostico {
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	
	
	@Override
	public String toString() {
		return "Pronostico [partido=" + partido + ", equipo=" + equipo + ", resultadoPronostico=" + resultadoPronostico
				+ "]";
	}



	public Pronostico(Partido partido, Equipos equipo, Resultado resultadoPronostico) {

		this.partido = partido;
		this.equipo = equipo;
		this.resultadoPronostico = resultadoPronostico;
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
