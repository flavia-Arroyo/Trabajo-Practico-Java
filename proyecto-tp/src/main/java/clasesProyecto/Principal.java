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
import modeladocsv.LectorResultadosCsv;
import modeladocsv.LectorPronosticosCsv;

import com.opencsv.bean.CsvToBeanBuilder;


public class Principal {

	public static void main(String[] args) {
		
		String rutaArchivo = "src\\main\\resources\\resultados.csv";
		String rutaPronostico = "src\\main\\resources\\pronostico.csv";
		
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv(rutaArchivo);
		//lector del archivo de pronosticos
		LectorPronosticosCsv lectorArchivoPro = new LectorPronosticosCsv(rutaPronostico);
		
		
	
		//obtengo las lineas del archivo CSV correspondiente a partidos
		lectorArchivos.parsearArchivo();
		
		//obtiene las lineas del archivo csv de pronosticos
		lectorArchivoPro.parsearPronostico();
		
		//genera lista con equipos
		ArrayList<Equipos> equipos = lectorArchivos.listarEquipos();
		
		//generar lista de partidos
		ArrayList<Partido> partido = lectorArchivos.listarPartidos(equipos);
		
		
		//genera lista con pronosticos
		ArrayList<Pronostico> pronostico = lectorArchivoPro.listarPronosticos(partido);
		
		
		// determinar el puntaje del pronosticador
		int puntaje = 0;
		for(Pronostico pronosticos :pronostico) {
			
			if(pronosticos.getPartido().obtenerResultado(pronosticos.getEquipo()).equals(pronosticos.getResultadoPronostico())){
				puntaje += pronosticos.obtenerPuntos();
				
				
			};
		
		}
		
		System.out.println("el puntaje obtenido por el apostador es:  " + puntaje);
	
	
	

	
       }
}

		

	


