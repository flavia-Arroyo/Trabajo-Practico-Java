package modeladocsv;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import clasesProyecto.Pronostico;
import clasesProyecto.Resultado;
import clasesProyecto.Partido;
import clasesProyecto.Rondas;
import clasesProyecto.Participantes;



public class LectorPronosticosCsv {
	String rutaPronostico;
	List<ListadoPronosticos> lineaPronostico;
	
	public LectorPronosticosCsv(String ruta) {
		this.rutaPronostico = ruta;
		this.lineaPronostico = new ArrayList();
		}
	
	
	public void parsearPronostico() {
		List<ListadoPronosticos> listadoPron = null;
		try {
			listadoPron = new CsvToBeanBuilder(new FileReader(this.rutaPronostico))
					.withType(ListadoPronosticos.class)
					.withSkipLines(1)
					.withSeparator(',')
					.build()
					.parse();
			
			
			
		}catch (IOException e) {
	        e.printStackTrace();
		}
		this.lineaPronostico = listadoPron;
		
		
		
	}
	
	public ArrayList<Participantes> listarParticipantes (){
		boolean partExistente = false;
		ArrayList<Participantes> part = new ArrayList();
		
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			partExistente = false;
			Participantes unParticipante = new Participantes (lineaPronostico.getIdParticipante(), lineaPronostico.getNombreParticipante());
			
			
			for(Participantes participanteCargado: part) {
				if(unParticipante.getIdParticipante() == participanteCargado.getIdParticipante()) {
					partExistente = true;
				}
			}
			if(!partExistente) {
				part.add(unParticipante);
				
			}
			
		}	
		
		return part;
		
		
		
	}
	
	
	public ArrayList<Pronostico> listarPronosticos(ArrayList<Rondas> ronda){
		
		
		ArrayList<Pronostico> pronostico = new ArrayList();
		
		
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			//me fijo donde esta la x
			if(lineaPronostico.getGanaEquipo1().equals("X")) {
				
				// traigo id pronostico
				int idPronostico = lineaPronostico.getIdPronostico();
			
			
				//traigo el nombre del que pronostico
				String nombreParticipante = lineaPronostico.getNombreParticipante();
			
				
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();				
				
				for(Rondas rondaPartidos : ronda) {
					//int equipo1Partido = rondaPartidos.obteneridEquipo1();
					//int equipo2Partido =rondaPartidos.obteneridEquipo2();
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
					
					//if((equipo1Partido== idequipo1) && (equipo2Partido == idequipo2)) {
									
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								
								Resultado.GANADOR
								
								
								);
					
						pronostico.add(unPronostico);
						
					//}
					
					
				}
			
				
				
			}// fin if gana equipo 1
			
			if(lineaPronostico.getEmpate().equals("X")) {
				
				// traigo id pronostico
				int idPronostico = lineaPronostico.getIdPronostico();
				//traigo el nombre del que pronostico
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Rondas rondaPartidos : ronda) {
					//int equipo1Partido = rondaPartidos.obteneridEquipo1();
					//int equipo2Partido =rondaPartidos.obteneridEquipo2();
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					//if((equipo1Partido== idequipo1) && (equipo2Partido == idequipo2)) {
						
						
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								
								Resultado.EMPATE
								
								
								);
						pronostico.add(unPronostico);
						
					//}
					
					
					
				}
			
				
				
			}// fin de empate
			
			if(lineaPronostico.getGanaEquipo2().equals("X")) {
				
				// traigo id pronostico
				int idPronostico = lineaPronostico.getIdPronostico();
				//traigo el nombre del que pronostico
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Rondas rondaPartidos : ronda) {
					//int equipo1Partido = rondaPartidos.obteneridEquipo1();
					//int equipo2Partido =rondaPartidos.obteneridEquipo2();
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
					//if((equipo1Partido== idequipo1) && (equipo2Partido == idequipo2)) {
						
						
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								
								Resultado.GANADOR
								
								
								);
						pronostico.add(unPronostico);
					
					}
					
					
				//}	
			}			
		
		}	
		
		return pronostico;
	}	
	

}
