
package proyectopronosticador;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modeladocsv.LectorResultadosCsv;
import modeladocsv.NumeroDeCamposException;

class TestArchivoResultados {
	
	
		LectorResultadosCsv lectorArchivos = new LectorResultadosCsv("src\\main\\resources\\resultadosErrorCamposTest.csv"); 
		
	
	
	@Test
	void testNumeroDeCampos() {
		
		Assertions.assertThrows(NumeroDeCamposException.class, 
				()->
		      {
			
			     lectorArchivos.cantidadCampos();
		    });
		
	    }
	}
	


