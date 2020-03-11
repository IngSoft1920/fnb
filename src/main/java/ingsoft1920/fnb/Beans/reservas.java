package ingsoft1920.fnb.Beans;

public class reservas {
	private String hora;
	private int npersonas;
	private String nombre;

	
	public reservas(String hora, int npersonas, String nombre) {
		super();
		this.hora = hora;
		this.npersonas = npersonas;
		this.nombre = nombre;
		
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getNpersonas() {
		return npersonas;
	}
	public void setNpersonas(int npersonas) {
		this.npersonas = npersonas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "reservas [hora=" + hora + ", npersonas=" + npersonas + ", nombre=" + nombre
				+ "]";
	}
	

}
