package ingsoft1920.fnb.Model;

public class PlatoIngredienteM {
	
	private int plato_id;
	private IngredienteM ingrediente;
	private int cantidad;
	private String unidad;
	
	public PlatoIngredienteM(IngredienteM ingrediente, int cantidad, String unidad) {
		super();
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	public PlatoIngredienteM(int plato_id, IngredienteM ingrediente, int cantidad, String unidad) {
		super();
		this.plato_id = plato_id;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.unidad = unidad;
		
	}
	
	

	public int getPlato_id() {
		return plato_id;
	}
	public void setPlato_id(int plato_id) {
		this.plato_id = plato_id;
	}
	public IngredienteM getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(IngredienteM ingrediente) {
		this.ingrediente = ingrediente;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	
}
