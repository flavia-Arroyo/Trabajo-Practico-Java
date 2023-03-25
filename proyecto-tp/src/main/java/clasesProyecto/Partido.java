package clasesProyecto;

public class Partido {
	private int idPartido;
	private Equipos equipo1;
	private Equipos equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	
	
	
	
	
	
	
	public Partido(int idPartido, Equipos equipo1, Equipos equipo2, int golesEquipo1, int golesEquipo2) {
		
		this.idPartido = idPartido;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}





	




	public int getIdPartido() {
		return idPartido;
	}










	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}










	@Override
	public String toString() {
		return "Partido [idPartido=" + idPartido + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1="
				+ golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + "]";
	}










	public Resultado obtenerResultado(Equipos equipo) {
		if(this.golesEquipo1 > this.golesEquipo2) {
			
			if(this.equipo1 == equipo) {
				return Resultado.GANADOR;
			}else {
				return Resultado.PERDEDOR;
			}
		}else if(this.golesEquipo1 < this.golesEquipo2) {
			if(this.equipo2 == equipo) {
				return Resultado.GANADOR;
			}else {
				return Resultado.PERDEDOR;
			}
		}else {
			return Resultado.EMPATE;
		}
					
		
		
	}
	
	


	public Equipos getEquipo1() {
		return equipo1;
	}


	public void setEquipo1(Equipos equipo1) {
		this.equipo1 = equipo1;
	}


	public Equipos getEquipo2() {
		return equipo2;
	}


	public void setEquipo2(Equipos equipo2) {
		this.equipo2 = equipo2;
	}


	public int getGolesEquipo1() {
		return golesEquipo1;
	}


	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}


	public int getGolesEquipo2() {
		return golesEquipo2;
	}


	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	
	
	
	
	
	
	
	
	
	
	

}
