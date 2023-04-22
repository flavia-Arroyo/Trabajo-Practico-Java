
package clasesProyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Participantes {
	private int idParticipante;
	private String nombreParticipante;
	private String apellidoParticipante;
	private ArrayList<Pronostico> pronostico;
	HashMap<Integer, Float>totalesPart = new HashMap<Integer,Float>();
	
	public void totalesParticipante (int participante) {
		float totales = 0;
		float totalesNuevaRonda = 0;
		float parcial= 0;
		boolean acertoRonda = false;
		//int cantRondasAcertadas = 0;
		String nombreCompleto = "";
		String apostador = "";
		//float totalPuntos = 0;
		float extraPorRonda = 0;
		int ronda = 0;
		 ArrayList<Integer> rondasAcertadas = new ArrayList<Integer>();
		String participanteAcerto= "";
		Set<Integer> keys = totalesPart.keySet();
		for(Pronostico pro:pronostico) {
			if(ronda!= pro.getPartido().getIdronda()) {
				totales= 0; //reseteo totales cuando cambio de ronda
			}
			ronda =  pro.getPartido().getIdronda();
			
			
			if(pro.getIdParticipante() == participante) {
				
				nombreCompleto = this.apellidoParticipante + " " +  this.nombreParticipante;
				
				totales += pro.obtenerPuntos();
				if(totales == 4) {
					acertoRonda= true;
					extraPorRonda = pro.determinarAdicionalPorRonda(participante, ronda, totales);
					
				}
				if(acertoRonda) {
					//System.out.println(nombreCompleto + " obtuvo puntaje extra " + extraPorRonda );
					
				}
				//totalPuntos = pro.determinarAdicionalPorRonda(totales );
				
				/*if(totalPuntos >0) {
					acertoRonda = true;
					int total = (int) totalPuntos;
					apostador = nombreCompleto;
					cantRondasAcertadas += 1;
					apostador= nombreCompleto;
					rondasAcertadas.add( ronda);
					rondasAcertadas.add(total);
					
				}*/
				

				
								
			}
			
			

			totalesPart.put(ronda, totales);	
			
			
			
		}
		
		
		
		
		
		
		System.out.println("**********Totales por Ronda********************");
		System.out.println("");
		for (Integer key: keys){
			
			
			System.out.println("    el participante "+ nombreCompleto +" en la ronda: " +  key+ " Obtuvo= " + totalesPart.get(key)  );
		} 
		System.out.println("");
		
		if(acertoRonda) {
			System.out.println(nombreCompleto + " obtuvo puntaje extra " + extraPorRonda );
			
		}
		/*if(acertoRonda) {
			//System.out.println(nombreCompleto + " obtuvo puntaje extra " + rondaAcertada );
			int rondaA = 0;
			int puntos =0;
			int rondaB = 0;
			int puntosB = 0;
			
			for(int i= 0;  i < rondasAcertadas.size(); i ++ ) {
				rondaA = rondasAcertadas.get(0);
			 puntos = rondasAcertadas.get(1);
				rondaB = rondasAcertadas.get(2);
				puntosB = rondasAcertadas.get(3);
				
			}
			System.out.println("*************************************************");
			System.out.println("*************************************************");
			System.out.println("");
			System.out.println(apostador + " acerto rondas");
			System.out.println("");
			System.out.println( "  obtuvo puntaje extra en la ronda: " + rondaA + " Total de Puntaje: " +  puntos)  ;
			System.out.println( "  obtuvo puntaje extra en la ronda: " + rondaB + " Total de Puntaje: " +  puntosB)  ;
			System.out.println("");
			if(cantRondasAcertadas == 2) {
				System.out.println("*************************************************");
				System.out.println("*************************************************");
				System.out.println("");
				System.out.println(apostador + "  obtuvo puntaje extra ( 4 puntos) por acertar 2 rondas consecutivas: ")  ;
				int puntaje_extra = 4;
				int totalFase = puntos + puntosB + puntaje_extra;
				 System.out.println("total de puntos obtenidos es: " +  totalFase);
				
				
				
				
				
				
				
			}
			
		}*/
		
		

		
		
		
		
		
			
	}
	

	public String getApellidoParticipante() {
		return apellidoParticipante;
	}


	public void setApellidoParticipante(String apellidoParticipante) {
		this.apellidoParticipante = apellidoParticipante;
	}


	public Participantes(int idParticipante, String nombreParticipante, String apellidoParticipante) {
		
		this.idParticipante = idParticipante;
		this.nombreParticipante = nombreParticipante;
		this.apellidoParticipante = apellidoParticipante;
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
