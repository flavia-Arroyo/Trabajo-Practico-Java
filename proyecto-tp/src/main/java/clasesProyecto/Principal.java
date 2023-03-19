package clasesProyecto;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import modeladocsv.ListadoPartidos;
import modeladocsv.ListadoPronosticos;

import com.opencsv.bean.CsvToBeanBuilder;


public class Principal {

	public static void main(String[] args) {
		//LECTURA DE LOS ARCHIVOS CSV
				String partidosCsv = "C:\\Users\\LENOVO\\Desktop\\FLAVIA\\Ap- java 2023\\RepositorioTP\\proyecto-tp\\src\\main\\resources\\resultados.csv";
				String pronosticosCsv = "C:\\Users\\LENOVO\\Desktop\\FLAVIA\\Ap- java 2023\\RepositorioTP\\proyecto-tp\\src\\main\\resources\\pronostico.csv";
				
				List<ListadoPartidos> listadoPartidos;	
				List<ListadoPronosticos> listadopronosticos;
				
				try {
					
					listadoPartidos = new CsvToBeanBuilder(new FileReader(partidosCsv))
				   
					.withType(ListadoPartidos.class)
					.withSkipLines(1)
					.withSeparator(';')
					.build()
					.parse();
					
					listadopronosticos = new CsvToBeanBuilder(new FileReader(pronosticosCsv))
							.withType(ListadoPronosticos.class)
							.withSkipLines(1)
							.withSeparator(';')
							.build()
							.parse();
							
					
					//System.out.println(listadoPartidos);
					//System.out.println(listadopronosticos);
					
					Equipos equipoUno = new Equipos(0, null, null);
					Equipos equipoDos = new Equipos(0, null, null);
					
					//Partido partido = new Partido(equipoUno, equipoDos,0,0 );
					ArrayList<Partido> partidoLista = new ArrayList<Partido>();		
				
					Partido partido;	
				 //recorro lista de partidos que se genero con la lectura de el archivo csv e instancio la clase equipo partido
				for(ListadoPartidos partidos: listadoPartidos ) {
					//REALIZO UNA LISTA DE PARTIDOS
					
				            partido = new Partido(equipoUno, equipoDos, 0,0);
                        //System.out.println(partidos);
						equipoUno.setIdEquipo(partidos.getIdEquipo1());
						equipoDos.setIdEquipo(partidos.getIdEquipo2());
						equipoUno.setNombreEquipo(partidos.getNombreEquipo1());
						equipoDos.setNombreEquipo(partidos.getNombreEquipo2());
						equipoUno.setDescripcion(partidos.getDescripcionEquipo1());
						equipoDos.setDescripcion(partidos.getDescripcionEquipo2());	
						
						partido.setGolesEquipo1(partidos.getGolesEquipo1());
					    partido.setGolesEquipo2(partidos.getGolesEquipo2());
						System.out.println(partido);
						//System.out.println(equipoUno);
						//System.out.println(equipoDos);
						partidoLista.add(partido);
						
						//partidoLista.add(new Partido(equipoUno, equipoDos, partidos.getGolesEquipo1(),partidos.getGolesEquipo2()));
						//System.out.println(partidoLista);
						
					}
				//System.out.println(partido);
					
				
					//System.out.println(partidoLista.get(1));
					
					for (int i = 0; i < partidoLista.size(); i++) {
						System.out.println("partidoLista " + partidoLista.get(i));
						
					}
					//System.out.println("fuera del for");
				
				//System.out.println(partidoLista);
				
				//System.out.println(equipoUno);
				//System.out.println(equipoDos);
				//System.out.println(partido.getEquipo1());
				//System.out.println(partido.getEquipo2());
				
				//BUSCO EN LA LISTA DE PRONOSTICOS LA X
				//Pronostico pronostico = new Pronostico(null, null, null);
				//System.out.println(listadopronosticos);
				
				
				/*for(ListadoPronosticos pronosticos :listadopronosticos) {
					
										
					if(pronosticos.getGanaEquipo1().equals("X")) {
						//System.out.println("HAY UNA X EN GANA EQUIPO 1");
						pronostico.setResultadoPronostico(Resultado.GANADOR);
						pronostico.setEquipo(equipoUno) ;
						pronostico.setPartido(partido);
						//System.out.println("agrego partido que gana el 1");
						//System.out.println(pronostico.getPartido());
					}
					 if(pronosticos.getEmpate().equals("X")) {
						 pronostico.setResultadoPronostico(Resultado.EMPATE);				 
						 //System.out.println("HAY X EN EMPATE");	
						 pronostico.setEquipo(equipoDos);
					 }
					
					 if(pronosticos.getGanaEquipo2().equals("X")) {
						 pronostico.setResultadoPronostico(Resultado.GANADOR);
						 pronostico.setEquipo(equipoDos);
						 //System.out.println("HAY X EN GANADOR EQUIPO2"); 
						 
					 }*/

					 
					 //System.out.println(pronostico);
				
				}
				
				
				
				
				 
			
					
					
					
					
					
				 catch (IOException e) {
		            e.printStackTrace();	
			}

		}

	}


