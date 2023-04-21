package clasesProyecto;

import java.util.ArrayList;
import java.util.List;

public class Pronostico {
	private int idPronostico;
	//private String participante;
	private int idParticipante;
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	




	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", idParticipante=" + idParticipante + ", partido="
				+ partido + ", equipo=" + equipo + ", resultadoPronostico=" + resultadoPronostico + "]";
	}



	public int getIdParticipante() {
		return idParticipante;
	}



	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}



	public Pronostico(int idPronostico, int idParticipante, Partido partido, Equipos equipo,
			Resultado resultadoPronostico) {
		
		this.idPronostico = idPronostico;
		this.idParticipante = idParticipante;
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


	


	/*public String getParticipante() {
		return participante;
	}


	public void setParticipante(String participante) {
		this.participante = participante;
	}
	
	
*/
	
	
	

	public float obtenerPuntos() {
		
		Resultado resultadoReal = partido.obtenerResultado(equipo, partido.getIdronda());
		if (this.resultadoPronostico.equals(resultadoReal) ){
			
		    return 0.5f;
		    
			
		} 
		
		else {
			return 0; 
		}
		
	
	}
	
	public float determinarAdicionalPorRonda ( float totalObtenidoporRonda) {
		float puntaje = 0;
		float totalpuntaje = 0;
		String mensaje = "";
		if(totalObtenidoporRonda == 4.0 ) {
			puntaje = 3.0f;
			totalpuntaje = puntaje + totalObtenidoporRonda;
		 
		}
		
		return totalpuntaje;
		
		
		
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
