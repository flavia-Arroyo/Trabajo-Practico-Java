
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
		//float totalesNuevaRonda = 0;
		//float parcial= 0;
		boolean acertoRonda = false;
		//int cantRondasAcertadas = 0;
		String nombreCompleto = "";
		//String apostador = "";
		//float totalPuntos = 0;
		float extraPorRondaPerfecta = 3.0f;
		int ronda = 0;
		 ArrayList<Integer> rondasAcertadas = new ArrayList<Integer>();
		 ArrayList<Integer>fasesAcertadas = new ArrayList<Integer>();
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
					
					rondasAcertadas.add(ronda);
					fasesAcertadas.add(pro.getNumFase(ronda));
					
				}
				

				
								
			}
			
			

			totalesPart.put(ronda, totales);	
			
			
			
		}
		
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("**********Totales por Ronda********************");
		System.out.println("");
		float totalParticipante = 0;
		for (Integer key: keys){
			
			
			System.out.println("    el participante "+ nombreCompleto +" en la ronda: " +  key+ " Obtuvo= " + totalesPart.get(key)  );
			  totalParticipante += totalesPart.get(key) ;
			  
			 
				
			
		} 
		System.out.println("");
		System.out.println("");
		
		 System.out.println("     TOTAL PUNTOS OBTENIDOS ES:  " + totalParticipante);
			System.out.println("");
		
		if(acertoRonda) {
			int fase= 0;
			int cantFase1 = 0;
			int cantFase2 = 0;
			
			int cantAciertos = 0;
			System.out.println("     EXTRA  3 PUNTOS POR CADA RONDA PERFECTA");
			System.out.println("");
			for(Integer ro: rondasAcertadas) {
				System.out.println("    ronda premiada:  " + ro);
				 cantAciertos = rondasAcertadas.size();
				
				 
				 
				 
			}
			for(Integer fa:fasesAcertadas) {
				
				if(fa == 1) {
					cantFase1 ++;
				}
				if(fa == 2) {
					cantFase2 ++;
					
				}
				
				
				
			}
			
			int puntajeTotal = (int) (totalParticipante + (cantAciertos * 3));
			System.out.println("");
			System.out.println("   TOTAL DE PUNTOS OBTENIDOS ES: " +  puntajeTotal);
			
			System.out.println("");
			System.out.println("");
			
			if(cantFase1 == 2) {
				System.out.println("     EXTRA  4 PUNTOS POR FASE 1 PERFECTA");
				
				
				int totalFase = puntajeTotal + 4;
				
				System.out.println("     PUNTAJE TOTAL ES: " +  totalFase);
			}
			if(cantFase2 == 2) {
				System.out.println("     EXTRA  4 PUNTOS POR FASE 2 PERFECTA");
				
				int totalFase = puntajeTotal + 4;
				
				System.out.println("     PUNTAJE TOTAL ES: " +  totalFase);
				
				System.out.println("");
				System.out.println("");
			}
			
		}
		
		
		

		
		
		
		
		
			
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
