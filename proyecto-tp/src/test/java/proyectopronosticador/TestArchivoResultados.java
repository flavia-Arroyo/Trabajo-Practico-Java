
package proyectopronosticador;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modeladocsv.NumeroDeCamposException;

class TestArchivoResultados {
	public boolean  cantidadCampos(String rutaArchivo)  {
		
		int contadorCol = 0;
		int numCol = 2;
		boolean colCorrecta = true;
		try {
			BufferedReader br;
			
			br = new BufferedReader(new FileReader(rutaArchivo));
			System.out.println(rutaArchivo);
			System.out.println(br);
			String linea;
		    
				while((linea = br.readLine()) != null) {
					System.out.println("entro");
					System.out.println(linea);
					String[] colum = linea.split(",");
					System.out.println(colum);
					contadorCol = colum.length;
					System.out.println(contadorCol);
					if(contadorCol != numCol) {
						System.out.println("erroneos ");
						colCorrecta = false; 
						break;						
					}
				
			   } 
				if(!colCorrecta) {
					throw new NumeroDeCamposException("el numero de campos es incorrecto: tiene " +  contadorCol + "  deberia tener: " + numCol);
					
					
				}
			
			
			
		}catch(IOException e) {
			
		} catch (NumeroDeCamposException e) {
			
			System.out.println("se produzco un error  " + e);
			
		}
		
		return colCorrecta;
	
		
	}
	

	@Test
	void testDeNumerosDeCampos() {
		boolean resultado = cantidadCampos("src\\main\\resources\\resultados-errorcol3");
		System.out.println(resultado);
		Assertions.assertFalse(resultado);
	
	}
	
	
	/*@Test
	void testDeTipoDeDatos() {
		setup("src\\main\\resources\\resultados-errorgoles2");
	}*/

}
