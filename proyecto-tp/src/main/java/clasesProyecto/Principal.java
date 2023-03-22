package clasesProyecto;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import modeladocsv.ListadoPartidos;
import modeladocsv.ListadoPronosticos;

import com.opencsv.bean.CsvToBeanBuilder;


public class Principal {

	public static void main(String[] args) {
		//LECTURA DE LOS ARCHIVOS CSV
				String partidosCsv = "src\\main\\resources\\resultados2.csv";
				String pronosticosCsv = "src\\main\\resources\\pronostico4.csv";
				
				List<ListadoPartidos> listadoPartidos;	
				List<ListadoPronosticos> listadopronosticos;
				
				try {
					
					listadoPartidos = new CsvToBeanBuilder(new FileReader(partidosCsv))
				   
					.withType(ListadoPartidos.class)
					.withSkipLines(1)
					.withSeparator(',')  //aca pongo coma por que asi lo pude generar al csv 
					.build()
					.parse();
					
					listadopronosticos = new CsvToBeanBuilder(new FileReader(pronosticosCsv))
							.withType(ListadoPronosticos.class)
							.withSkipLines(1)
							.withSeparator(',') // cuando es pronosticos2.csv poner coma en vez de punto y coma
							.build()
							.parse();
							
					//genero las listas de partido  equipos pronosticos
					ArrayList<Partido> partidoLista = new ArrayList<Partido>();		
					ArrayList<Equipos> listaEquipos = new ArrayList<Equipos>();	
					ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();
					
				   //inicializo
					Partido partido;	
					Equipos equipoUno;
					Equipos equipoDos;
					
				 //recorro lista de partidos que se genero con la lectura de el archivo csv e instancio la clase equipo partido
					
					for(ListadoPartidos partidos: listadoPartidos ) {	
						boolean equipoCargado = false;
					    equipoUno = new Equipos( 0, null, null);
			            equipoDos= new Equipos (0,null,null);
					    partido = new Partido(0,equipoUno, equipoDos, 0,0);
					    int indiceidCargado1= -1;
					    int indiceidCargado2= -1;
					    
					    for(Equipos e: listaEquipos) {
					    	if(e.getIdEquipo() == partidos.getIdEquipo1()){
					    		//ya existe el id en el listado de equipos
	                        	equipoCargado = true;
	                        	
	                             //obtengo la posicion de ese id
	                        	indiceidCargado1 += e.getIdEquipo(); 
					    		
					    	}
					    	
					    	if(e.getIdEquipo() == partidos.getIdEquipo2()) {
					    		//System.out.println("entro   " + e.getIdEquipo());
					    		
	                        	equipoCargado = true;  
	                        	indiceidCargado2 += e.getIdEquipo();
	                        	
					    		
					    	}
					    	
					    }
					    if(equipoCargado) {
					    	//al estar ya cargado el id en la lista de equipos
					    	//para generar la lista de equipos traigo los datos de la lista de equipos
					    	partido.setEquipo1(listaEquipos.get(indiceidCargado1));
					    	partido.setEquipo2(listaEquipos.get(indiceidCargado2));
					    }
					    
					    
					   
                      
                        if(!equipoCargado) {
                        	//genero los datos para cargar los equipos en la lista de equipos
                        	equipoUno.setIdEquipo(partidos.getIdEquipo1());
                        	equipoUno.setNombreEquipo(partidos.getNombreEquipo1());
                        	equipoUno.setDescripcion(partidos.getDescripcionEquipo1());
                        	listaEquipos.add(equipoUno);
                        	
                        	equipoDos.setIdEquipo(partidos.getIdEquipo2());
                        	equipoDos.setNombreEquipo(partidos.getNombreEquipo2());
                        	equipoDos.setDescripcion(partidos.getDescripcionEquipo2());	
                        	listaEquipos.add(equipoDos);
                        	
                        	
                        	
                        }
						partido.setIdPartido(partidos.getIdPartido());
						//cargo los goles en 
						partido.setGolesEquipo1(partidos.getGolesEquipo1());
					    partido.setGolesEquipo2(partidos.getGolesEquipo2());
					
						
						
						partidoLista.add(partido);
					
					
					}
					
					//recorro los pronosticos y genero la lista
					
				int idPronostico = 0;
				Pronostico pronostico;
				int idEquipo_1;
				int idEquipo_2;
				
				
				
				for(ListadoPronosticos pronosticos :listadopronosticos) {
					
					
					//BUSCO EN LA LISTA DE PRONOSTICOS LA X
					pronostico = new Pronostico(0,null, null, null);	

					 idEquipo_1 = pronosticos.getIdEquipo1();	
					 idEquipo_2 = pronosticos.getIdEquipo2();
					//a donde encuentre la x debo setear los datos de pronostico				
					if(pronosticos.getGanaEquipo1().equals("X")) {	
						//genero el id pronostico
						pronostico.setIdPronostico(idPronostico = idPronostico + 1);
						
						for(Partido listap: partidoLista ){  
						
							if((listap.getEquipo1().getIdEquipo() == idEquipo_1) && (listap.getEquipo2().getIdEquipo() == idEquipo_2) ){
								pronostico.setPartido(listap);
								pronostico.setEquipo(listap.getEquipo1());
							}			
							
					    }
						pronostico.setResultadoPronostico(Resultado.GANADOR);
						
						listaPronosticos.add(pronostico);
						
					}// cierre if
						
						
					
						
					 if(pronosticos.getEmpate().equals("X")) {
							//genero id al pronostico							
							pronostico.setIdPronostico(idPronostico = idPronostico + 1);						
							//idEquipo_1 = pronosticos.getIdEquipo1();
							 //idEquipo_2 = pronosticos.getIdEquipo2();
							for(Partido listap: partidoLista ){
								if((listap.getEquipo1().getIdEquipo() == idEquipo_1) && (listap.getEquipo2().getIdEquipo() == idEquipo_2)) {
									pronostico.setEquipo(listap.getEquipo1());
									
									pronostico.setPartido(listap);
																	
								}							
							}
							pronostico.setResultadoPronostico(Resultado.EMPATE);
							listaPronosticos.add(pronostico);	
							
					 }
					
					 if(pronosticos.getGanaEquipo2().equals("X")) {
						//genero el id pronostico
							pronostico.setIdPronostico(idPronostico = idPronostico + 1);
							System.out.println("HAY UNA X EN GANA EQUIPO 2");
							//idEquipo_2 = pronosticos.getIdEquipo1();
							// idEquipo_2 = pronosticos.getIdEquipo2();
							for(Partido listap: partidoLista ){
								if((listap.getEquipo2().getIdEquipo() == idEquipo_2) && (listap.getEquipo1().getIdEquipo() == idEquipo_1)) {
									pronostico.setEquipo(listap.getEquipo2());
								
									pronostico.setPartido(listap);
																	
								}							
							}
							pronostico.setResultadoPronostico(Resultado.GANADOR);
							listaPronosticos.add(pronostico);
							
					 }			
				
				}
				//System.out.println(listaPronosticos);
				
				//ya tengo todas las listas creadas ahora debo ver el resultado 
				
				//recorro pronostico
				int puntaje= 0;
				for(Pronostico pronosticos :listaPronosticos) {
					
					if(pronosticos.getPartido().obtenerResultado(pronosticos.getEquipo()).equals(pronosticos.getResultadoPronostico())){
						puntaje += pronosticos.obtenerPuntos();
						
						
					};
				
				}
				
				System.out.println("el puntaje obtenido por el apostador es:" + puntaje);
				
				/*for(Equipos e: listaEquipos) {
					System.out.println(e);
								}
				
				for(Partido p:partidoLista) {
					System.out.println(p);
				}
				
				for(Pronostico pro: listaPronosticos) {
					System.out.println(pro);
				}*/
				
				
				
				
				
				
				}
	
				
				 catch (IOException e) {
		            e.printStackTrace();	
			}
				
	

	
}
}

		

	


