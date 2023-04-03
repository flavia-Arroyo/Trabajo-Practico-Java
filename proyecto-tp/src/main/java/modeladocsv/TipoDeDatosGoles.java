package modeladocsv;

public class TipoDeDatosGoles  extends Exception{
    
	
	
	
    @Override
	public String getMessage() {
		return "el tipo de dato del campo de goles no es un entero, no se puede leer";
	}

}
