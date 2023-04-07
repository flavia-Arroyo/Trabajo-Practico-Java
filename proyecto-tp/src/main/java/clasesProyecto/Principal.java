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
import modeladocsv.NumeroDeCamposException;
import modeladocsv.LectorResultadosCsv;
import modeladocsv.LectorPronosticosCsv;

import com.opencsv.bean.CsvToBeanBuilder;


public class Principal {

	public static void main(String[] args) {
		
		String rutaArchivo = "src\\main\\resources\\resultados-2da.csv";
		String rutaPronostico = "src\\main\\resources\\pronostico2da.csv";
		
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv(rutaArchivo); //debe lanzar excepciones
		//lector del archivo de pronosticos
		LectorPronosticosCsv lectorArchivoPro = new LectorPronosticosCsv(rutaPronostico);
		
		
		//verifico la cantidad de campos del archivo resultados
		boolean correcto =lectorArchivos.cantidadCampos();
		if(correcto) {
			//obtengo las lineas del archivo CSV correspondiente a partidos
			lectorArchivos.parsearArchivo();
			lectorArchivoPro.parsearPronostico();
			
		}
		
		
		//genera lista con equipos
		ArrayList<Equipos> equipos = lectorArchivos.listarEquipos();

		//genero la lista de pronosticadores
		ArrayList<Participantes>participantes = lectorArchivoPro.listarParticipantes();
		
		
		//generar lista de partidos
		ArrayList<Partido> partido = lectorArchivos.listarPartidos(equipos);
		//genero lista de rondas
		ArrayList<Rondas> rondas = lectorArchivos.listarRondas(partido);
	
		
		//genera lista con pronosticos
		ArrayList<Pronostico> pronostico = lectorArchivoPro.listarPronosticos(rondas);
		
	/*	
		
	 for(Pronostico pron:pronostico) {
		 List<Object> aciertos = new ArrayList<Object>();
		 String participante = pron.getParticipante();
		 aciertos.add(participante);
		 float sumaPuntos = 0;
		 boolean acerto = false;
		 float total = 0;
		 //Partido partidoAcertado;
		 //Resultado resultadoPronosticado;
		 if(aciertos.contains(participante)) {
			sumaPuntos = pron.obtenerPuntos();
			if(sumaPuntos >0) {
				total += pron.obtenerPuntos();;
				Partido partidoAcertado = pron.getPartido();
			    Resultado resultadoPronosticado = pron.getResultadoPronostico();
			    aciertos.add(total);
				aciertos.add(partidoAcertado);
				aciertos.add(resultadoPronosticado);
				
				
			}
			
			 
			 
			 
		 }
		 
		 System.out.println(aciertos);
	 }
		
		/*public List<Object> aciertosApostadores(String apostador){
			List<Object> aciertos = new ArrayList<Object>();	
			float puntaje = 0;
			boolean acerto = false;
			if(this.participante.equals(apostador)) {
				if(partido.obtenerResultado(equipo, partido.getIdronda()) == Resultado.GANADOR) {
					acerto = true;
				}
				if(partido.obtenerResultado(equipo, partido.getIdronda()) == Resultado.PERDEDOR) {
					acerto= true;
				}
				if (partido.obtenerResultado(equipo,  partido.getIdronda())== Resultado.EMPATE) {
					
					acerto = true;
					
				}
				puntaje += this.obtenerPuntos();
				
				if(acerto) {
					int idPartido = partido.getIdPartido();
					Equipos equipo1 = partido.getEquipo1();
					Equipos equipo2 = partido.getEquipo2();
					
					
					aciertos.add(apostador);
					aciertos.add(idPartido);
					aciertos.add(equipo1);
					aciertos.add(equipo2);
					
				}
				aciertos.add(puntaje);
				
				
			}
			 
			 
			 
			 
			 
			 
			return aciertos;
			
		}
		
		
	  
		
		/*System.out.println("lista de pronosticos");
		for(Pronostico pro:pronostico) {
			System.out.println(pro);
		}
		/*
		
		for(Equipos e: equipos) {
			System.out.println("lista de equipos");
			System.out.println(e);
		}
		
		System.out.println("lsta partidos");
		
		for(Partido p: partido) {
			System.out.println("lista de partidos");
			System.out.println(p);
		}
		
		System.out.println("lista de rondas");
		
		for(Rondas r :rondas) {
			System.out.println(r);
			
		}
		/*
		System.out.println("lista de participantes");
		
		for(Participantes part: participantes) {
			System.out.println(part);
		}*/
		
		
	
		
		 //determinar el puntaje del pronosticador
	/*float puntaje = 0;
	float puntaje2 = 0;
	
	//ArrayList<Pronosticos> puntajes = new ArrayList();
	int idpronostico= -1;
	String nombreApostador = null;
	for(Participantes part:participantes) {
		for(Pronostico pronosticos :pronostico) {
			
			nombreApostador = part.getNombreParticipante();
			int pronosticador = part.getIdParticipante();
			while(pronostico.contains(pronosticador)) {
				puntaje += pronosticos.obtenerPuntos();
				idpronostico = pronosticos.getIdPronostico();
				puntaje += pronosticos.obtenerPuntos();
				 
			}
		}
		System.out.println("el apostador: "  + nombreApostador + "obtuvo: " + puntaje + "Acerto en " + idpronostico );
		
		
	}
	
		*/
		float puntaje1= 0;
		float total = 0;
		List<Object> aciertos = new ArrayList<Object>();
	
		for (Pronostico pronosticos :pronostico) {
			
			String nombreApostador= null;
		
			
			int idPronostico = -1;
			
			if(pronosticos.obtenerPuntos() > 0){
				
					nombreApostador = pronosticos.getParticipante();
				
					idPronostico = pronosticos.getIdPronostico();
					 
					puntaje1 += pronosticos.obtenerPuntos();
					
					
					aciertos.add(nombreApostador);
					aciertos.add(idPronostico);
					//aciertos.add(partidoPronosticado);
					aciertos.add(puntaje1);	
					
									
			}
			
			else if(!(aciertos.contains(nombreApostador))){
				
				puntaje1 = 0;
			}
			
			
			
			
		
		}
		
		
		System.out.println(aciertos);
		
		for(Object lineaaciertos: aciertos) {
			System.out.println(lineaaciertos);
			
		}
		
		
		
		
		
	
			
			
			
			
			
			
			
			//System.out.println("el pronosticador: " + pronosticador + "obtuvo: " + puntaje + "acerto en : " + idpronostico);
		
		//}
		
		
		
		
		
	
		/*System.out.println("lista de pronosticos");
		for(Pronostico pro:pronostico) {
			System.out.println(pro);
		}
	

	
       }*/
	}

	
}

		

	


