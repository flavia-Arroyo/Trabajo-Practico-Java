package clasesProyecto;

public class Participantes {
	private int idParticipante;
	private String nombreParticipante;
	
	
	public Participantes(int idParticipante, String nombreParticipante) {
		
		this.idParticipante = idParticipante;
		this.nombreParticipante = nombreParticipante;
	}


	public int getIdParticipante() {
		return idParticipante;
	}


	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}


	public String getNombreParticipante() {
		return nombreParticipante;
	}


	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}


	@Override
	public String toString() {
		return "Participantes [idParticipante=" + idParticipante + ", nombreParticipante=" + nombreParticipante + "]";
	}
	
	
	
	
	
	
	
	

}
