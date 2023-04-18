
package proyectopronosticador;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modeladocsv.LectorResultadosCsv;
import modeladocsv.NumeroDeCamposException;

class TestArchivoResultados {
	
	//void setup(String rutaArchivo) {
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv("src\\main\\resources\\resultados-errorcol3.csv"); 
		
	//}
	

	
	
	
	@Test
	void testNumeroDeCampos() {
		//setup("src\\main\\resources\\resultados-errorcol3.csv");
		Assertions.assertThrows(NumeroDeCamposException.class, 
				()->
		      {
			
			     lectorArchivos.cantidadCampos();
		    });
		
	    }
	}
	


