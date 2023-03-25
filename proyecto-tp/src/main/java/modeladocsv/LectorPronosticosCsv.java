package modeladocsv;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import clasesProyecto.Pronostico;
import clasesProyecto.Resultado;
import clasesProyecto.Partido;


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
					.withSeparator(';')
					.build()
					.parse();
			
		}catch (IOException e) {
	        e.printStackTrace();
		}
		this.lineaPronostico = listadoPron;
		
		
	}
	
	
	public ArrayList<Pronostico> listarPronosticos(ArrayList<Partido> partido){
		int idPronostico = 0; //inicializo el id
		//Pronostico nuevoPronostico = new Pronostico( 0, null, null, null);
		
		ArrayList<Pronostico> pronostico = new ArrayList();
		for(ListadoPronosticos lineaPronostico : this.lineaPronostico) {
			//me fijo donde esta la x
			if(lineaPronostico.getGanaEquipo1().equals("X")) {
				
				// generar id
				idPronostico = idPronostico + 1;
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Partido listap : partido) {
					if((listap.getEquipo1().getIdEquipo() == idequipo1) && (listap.getEquipo2().getIdEquipo() == idequipo2)) {
						
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								listap,
								listap.getEquipo1(),
								Resultado.GANADOR
								
								
								);
						pronostico.add(unPronostico);
					}
					
					
				}
			
				
				
			}// fin if gana equipo 1
			
			if(lineaPronostico.getEmpate().equals("X")) {
				
				// generar id
				idPronostico = idPronostico + 1;
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Partido listap : partido) {
					if((listap.getEquipo1().getIdEquipo() == idequipo1) && (listap.getEquipo2().getIdEquipo() == idequipo2)) {
						
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								listap,
								listap.getEquipo1(),
								Resultado.EMPATE
								
								
								);
						pronostico.add(unPronostico);
					}
					
					
				}
			
				
				
			}// fin de empate
			
			if(lineaPronostico.getGanaEquipo2().equals("X")) {
				
				// generar id
				idPronostico = idPronostico + 1;
				//obtener id del equipo 1 y 2 del pronostico 
				int idequipo1 = lineaPronostico.getIdEquipo1();
				int idequipo2 = lineaPronostico.getIdEquipo2();
				
				
				for(Partido listap : partido) {
					if((listap.getEquipo1().getIdEquipo() == idequipo1) && (listap.getEquipo2().getIdEquipo() == idequipo2)) {
						
						Pronostico unPronostico = new Pronostico(
								idPronostico,
								listap,
								listap.getEquipo2(),
								Resultado.GANADOR
								
								
								);
						pronostico.add(unPronostico);
					}
					
					
				}
			
				
				
			}
			
			
			
			
			
			
		
		}
		
		
		
		return pronostico;
	}
	
	
	
	
	
	

}
