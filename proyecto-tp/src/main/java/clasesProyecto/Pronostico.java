package clasesProyecto;

import java.util.ArrayList;
import java.util.List;

public class Pronostico {
	private int idPronostico;
	//private String participante;
	private int idParticipante;
	private int numFase;
	private Partido partido;
	private Equipos equipo;
	private Resultado resultadoPronostico;
	




	



	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", idParticipante=" + idParticipante + ", numFase="
				+ numFase + ", partido=" + partido + ", equipo=" + equipo + ", resultadoPronostico="
				+ resultadoPronostico + "]";
	}



	public int getIdParticipante() {
		return idParticipante;
	}



	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}



	public Pronostico(int idPronostico, int idParticipante, int numFase, Partido partido, Equipos equipo,
			Resultado resultadoPronostico) {
		
		this.idPronostico = idPronostico;
		this.idParticipante = idParticipante;
		this.numFase = numFase;
		this.partido = partido;
		this.equipo = equipo;
		this.resultadoPronostico = resultadoPronostico;
	}



	public int getNumFase() {
		return numFase;
	}



	public void setNumFase(int numFase) {
		this.numFase = numFase;
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
	
	public void determinarAdicionalPorRonda (String participante, int ronda, float puntaje) {
		//ArrayList<Integer> participantes = new ArrayList<Integer>();
		ArrayList<Object> totalesPorRonda = new ArrayList<Object>();
		float puntajeExtraPorAcierto = 3.0f;
		float totalpuntajePorRonda = 0;
		int cantRondasAcertadas = 0;
		//participantes.add(id_participante); //agrego al arreglo de participantes
			
			totalpuntajePorRonda = puntaje + puntajeExtraPorAcierto;
			totalesPorRonda.add(participante);
			totalesPorRonda.add(ronda);
			totalesPorRonda.add(totalpuntajePorRonda);
		 
			/*for (Integer idpart : participantes) {
				if(idpart == id_participante) {
					cantRondasAcertadas += 1;
				}
			}
			
			if(cantRondasAcertadas == 2) {//gano fase
				//totalPorFase(id_participante, ronda);
			}*/
		
		
		for(int i = 0; i < totalesPorRonda.size() ; i ++) {
			
			System.out.println("El Participante: " + i );
		}
		
		
		
	}
	
	/*public float  totalPorFase(int id_participante, int ronda) {
		
		float puntajePorFase = 18.00f;
		
	}*/
	
	



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
