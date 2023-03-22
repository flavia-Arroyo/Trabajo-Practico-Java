package clasesProyecto;

public class Equipos {
	private int idEquipo;
	private String nombreEquipo;
	private String descripcion;
	
	
	public Equipos(int idEquipo, String nombreEquipo, String descripcion) {
		
		this.idEquipo = idEquipo;
		this.nombreEquipo = nombreEquipo;
		this.descripcion = descripcion;
	}
	
	


	@Override
	public String toString() {
		return "Equipos [idEquipo=" + idEquipo + ", NombreEquipo=" + nombreEquipo + ", Descripcion=" + descripcion
				+ "]";
	}




	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
