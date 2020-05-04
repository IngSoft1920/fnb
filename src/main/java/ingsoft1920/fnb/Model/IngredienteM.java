package ingsoft1920.fnb.Model;

public class IngredienteM {
	private int ingrediente_id;
	private String nombre;
	public IngredienteM(int ingrediente_id, String nombre) {
		super();
		this.ingrediente_id = ingrediente_id;
		this.nombre = nombre;
	}
	
	public IngredienteM(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIngrediente_id() {
		return ingrediente_id;
	}
	public void setIngrediente_id(int ingrediente_id) {
		this.ingrediente_id = ingrediente_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
