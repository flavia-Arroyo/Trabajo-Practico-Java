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
import clasesProyecto.Equipos;
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
	

	
	public ArrayList<Pronostico> listarPronosticos(ArrayList<Rondas> ronda){
		
		boolean partExistente = false;
		ArrayList<Participantes> participante = new ArrayList();
		ArrayList<Pronostico> pronostico = new ArrayList();
		
		
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			
			//me fijo donde esta la x
			if(lineaPronostico.getGanaEquipo1().equals("X")) {
				//busco el id del participante
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				System.out.println(idParticipante);
				
				// traigo id pronostico
				int idPronostico = lineaPronostico.getIdPronostico();
			
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();				
				
				for(Rondas rondaPartidos : ronda) {
				
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								Resultado.GANADOR
								);
						pronostico.add(unPronostico);
						
						Participantes unParticipante = new Participantes(
							idParticipante,
							nombreParticipante,
							unPronostico
							
							
						);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							if((idPartidoCargado == idPartidoPronostico) &&
									(equipoCargado == equipoPronosticado) && 
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
								System.out.println("ya pronostico " + nombreParticipanteCargado);
							}
							
						}
						if(!partExistente) {
							
							
						}*/
						participante.add(unParticipante);
						
						
				}
				for(Rondas rondaPartidos : ronda) {
					
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								
								Resultado.PERDEDOR
								
								
								);
						pronostico.add(unPronostico);
						
						Participantes unParticipante = new Participantes(
							idParticipante,
							nombreParticipante,
							unPronostico
							
							
						);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							if((idPartidoCargado == idPartidoPronostico) &&
									(equipoCargado == equipoPronosticado)&&
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
							}
							
						
						}
						if(!partExistente) {
							
							
						}*/
						participante.add(unParticipante);
						
				}
			
				
				
			}// fin if gana equipo 1
			
			if(lineaPronostico.getEmpate().equals("X")) {
				//busco el id del participante
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				// traigo id pronostico
				int idPronostico = lineaPronostico.getIdPronostico();
				
				
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Rondas rondaPartidos : ronda) {
				
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								
								Resultado.EMPATE
								
								
								);
						pronostico.add(unPronostico);
						
						Participantes unParticipante = new Participantes(
								idParticipante,
								nombreParticipante,
								unPronostico
								
								
							);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							if((idPartidoCargado == idPartidoPronostico) &&
									(equipoCargado == equipoPronosticado)&&
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
							}
							
						}
						if(!partExistente) {
							
						}*/
						participante.add(unParticipante);
						
					
				}
				
				
				for(Rondas rondaPartidos : ronda) {
					
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								
								Resultado.EMPATE
								
								
								);
						pronostico.add(unPronostico);
						
						Participantes unParticipante = new Participantes(
								idParticipante,
								nombreParticipante,
								unPronostico
								
								
							);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							if((idPartidoCargado == idPartidoPronostico) &&
									(equipoCargado == equipoPronosticado)&&
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
							}
							
						}
						if(!partExistente) {
							
							
						}*/
						participante.add(unParticipante);
					
				}
			
				
				
			}// fin de empate
			
			if(lineaPronostico.getGanaEquipo2().equals("X")) {
				
				int idPronostico = lineaPronostico.getIdPronostico();
				int idParticipante = lineaPronostico.getIdParticipante();
				String nombreParticipante = lineaPronostico.getNombreParticipante();
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				for(Rondas rondaPartidos : ronda) {
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								partidoPronosticado,
								partidoPronosticado.getEquipo2(),
								Resultado.GANADOR
								);
						pronostico.add(unPronostico);
						Participantes unParticipante = new Participantes(
								idParticipante,
								nombreParticipante,
								unPronostico
								);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							
							if(( idPartidoCargado==idPartidoCargado ) &&
									(equipoCargado==equipoPronosticado)&&
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
								System.out.println("participante existente" );
							}
							
						}
						if(!partExistente) {
							
							
						}*/
						participante.add(unParticipante);
					}

				for(Rondas rondaPartidos : ronda) {
					
					Partido partidoPronosticado = rondaPartidos.obtenerPartido(idequipo1, idequipo2);
					
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								nombreParticipante,
								
								partidoPronosticado,
								partidoPronosticado.getEquipo1(),
								
								Resultado.PERDEDOR
								
								
								);
						pronostico.add(unPronostico);
						Participantes unParticipante = new Participantes(
								idParticipante,
								nombreParticipante,
								unPronostico
								);
						/*for(Participantes participanteCargado :participante) {
							int idPartidoCargado = participanteCargado.getPronostico().getPartido().getIdPartido();
							int idPartidoPronostico =unPronostico.getPartido().getIdPartido();
							Equipos equipoCargado = participanteCargado.getPronostico().getEquipo();
							Equipos equipoPronosticado = unParticipante.getPronostico().getEquipo();
							String nombreParticipanteCargado = participanteCargado.getNombreParticipante();
							String nombreParticipantePronosticado = unPronostico.getParticipante();
							
							if(( idPartidoCargado==idPartidoCargado ) &&
									(equipoCargado== equipoPronosticado)&&
									(nombreParticipanteCargado.equals(nombreParticipantePronosticado))){
								partExistente = true;
								System.out.println("participante existente" );
							}
							
						}
						if(!partExistente) {
							
							
						}*/
						participante.add(unParticipante);
					
						
					
					}
				
					
					
				
			}
			
			
		
		}
		for(Participantes part:participante) {
			System.out.println(part);
		}
		
		
		return pronostico;
		
		
	}	
	

}
