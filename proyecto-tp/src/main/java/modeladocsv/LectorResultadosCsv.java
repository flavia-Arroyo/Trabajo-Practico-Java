package modeladocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import com.opencsv.bean.CsvToBeanBuilder;

import clasesProyecto.Equipos;
import clasesProyecto.Partido;
import clasesProyecto.Rondas;

public class LectorResultadosCsv {
	String rutaArchivo;
	
	List <ListadoPartidos> lineaArchivo;
		
	
	public LectorResultadosCsv(String ruta)  {
		this.rutaArchivo= ruta;
		this.lineaArchivo = new ArrayList();		
		
	}	
	
	public boolean  cantidadCampos() throws NumeroDeCamposException {
		int contadorCol = 0;
		int numCol = 11;
		boolean colCorrecta = true;
		try {
			BufferedReader br;
			
			br = new BufferedReader(new FileReader(this.rutaArchivo));
			
			String linea;
		
				while((linea = br.readLine()) != null) {
					String[] colum = linea.split(",");
					contadorCol = colum.length;
					
					if(contadorCol != numCol) {
						
						colCorrecta = false; 
						break;						
					}
				
			   } 
				if(!colCorrecta) {
					throw new NumeroDeCamposException("el numero de campos es incorrecto: tiene " +  contadorCol + "  deberia tener: " + numCol);
					
					
				}
			
			
			
		}catch(IOException e) {
			
		} /*catch (NumeroDeCamposException e) {
			
			System.out.println("se produzco un error  " + e);
			
		}*/
		
		return colCorrecta;
		
	}
			
	
	public void parsearArchivo() {
		List<ListadoPartidos> listadoResPartidos = null;
		
		try {
						
			listadoResPartidos = new CsvToBeanBuilder(new FileReader(this.rutaArchivo))

					.withType(ListadoPartidos.class)
					.withSkipLines(1)
					.withSeparator(',')  //aca pongo coma por que asi lo pude generar al csv en resultados.csv
					.build()
					.parse();
			
			      
	}catch (IOException e) {
        e.printStackTrace();
    }
		
		this.lineaArchivo = listadoResPartidos;
	
		
		
	
		
	}
	
	
	public ArrayList<Equipos> listarEquipos(){
		boolean equipoExistente = false;
		ArrayList<Equipos> equipo = new ArrayList();
		
		for(ListadoPartidos lineaPartido: this.lineaArchivo) {
			equipoExistente = false;
			Equipos nuevoEquipo1 = new Equipos(lineaPartido.getIdEquipo1(),
					lineaPartido.getNombreEquipo1(),
					lineaPartido.getDescripcionEquipo1());
					
			Equipos nuevoEquipo2 = new Equipos (lineaPartido.getIdEquipo2(),
					lineaPartido.getNombreEquipo2(),
					lineaPartido.getDescripcionEquipo2());
			
			for (Equipos equipoCargado: equipo) {
				if(nuevoEquipo1.getIdEquipo()==(equipoCargado.getIdEquipo()) || nuevoEquipo2.getIdEquipo() == (equipoCargado.getIdEquipo()) ) {
					equipoExistente = true;
					break;
					
				}
			}
			
			if(!equipoExistente) {
				equipo.add(nuevoEquipo1);
				equipo.add(nuevoEquipo2);
			}
			
					
		}
		return equipo;
		
	}
	
	public ArrayList<Partido> listarPartidos(ArrayList<Equipos> equipo){
		
		
		ArrayList<Partido> partidos = new ArrayList();
		for(ListadoPartidos linea : this.lineaArchivo) {
			Equipos unequipo1 = Equipos.buscarEquipo(equipo, linea.getIdEquipo1());
			Equipos unequipo2 = Equipos.buscarEquipo(equipo, linea.getIdEquipo2());
			
			Partido unPartido = null;
			
				
					unPartido = new Partido(
							linea.getIdPartido(),
							linea.getIdRonda(),
							unequipo1,
							unequipo2,							
							linea.getGolesEquipo1(),
							linea.getGolesEquipo2()
							);
				
			
			partidos.add(unPartido);
			
				
					
			
			
		}		
		return partidos;
		
		
	}
	
	
	public ArrayList<Rondas> listarRondas(ArrayList<Partido> partido){
		boolean rondaExistente = false;
		ArrayList<Rondas> ronda = new ArrayList();
		
		for(ListadoPartidos lineaPartido: this.lineaArchivo) {
			rondaExistente = false;
			Rondas unaRonda = new Rondas(lineaPartido.getIdRonda(), lineaPartido.getNumRonda(),partido);
			
			for (Rondas rondaCargada: ronda) {
				if(unaRonda.getIdRonda() == rondaCargada.getIdRonda()) {
					rondaExistente = true;
				}
				
			}
			
			if(!rondaExistente) {
				ronda.add(unaRonda);
				
			}
			
					
		}
		return ronda;
		
	}
	
	
	
	
	
	
	
	
	
	


}
