package ingsoft1920.fnb.Beans;

public class DatoUsuarioBean {
	String nombre;
	String apellido;
	String mail;
	int[] notas;
	
	public DatoUsuarioBean() {}
	
	public DatoUsuarioBean(String nombre, String apellido, String mail, int[] notas) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.mail=mail;
		this.notas=notas;
	}
	
	public void doWhatEver() {}

}
