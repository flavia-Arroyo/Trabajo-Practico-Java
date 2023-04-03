package modeladocsv;

public class NumeroDeCampos extends Exception{
	
	
		private final int numeroCampos;

		public NumeroDeCampos(int numeroCampos) {
			
			this.numeroCampos = numeroCampos;
		}

		public int getNumeroCampos() {
			return numeroCampos;
		}
		
	    @Override
		public String getMessage() {
			return "el archivo tiene mas campos que los requeridos";
		}
		
		
		
		

	


}
