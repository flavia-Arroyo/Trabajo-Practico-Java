package clasesProyecto;

public class Equipos {
	private int idEquipo;
	private String NombreEquipo;
	private String Descripcion;
	
	
	public Equipos(int idEquipo, String nombreEquipo, String descripcion) {
		
		this.idEquipo = idEquipo;
		this.NombreEquipo = nombreEquipo;
		this.Descripcion = descripcion;
	}
	
	


	@Override
	public String toString() {
		return "Equipos [idEquipo=" + idEquipo + ", NombreEquipo=" + NombreEquipo + ", Descripcion=" + Descripcion
				+ "]";
	}




	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


	public String getNombreEquipo() {
		return NombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		NombreEquipo = nombreEquipo;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
