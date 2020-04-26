package ingsoft1920.fnb.Model;

public class IngredienteInventarioM {
	private int inventario_id;
	private int cantidad;
	private String unidad;
	private RestauranteM restaurante;
	public IngredienteInventarioM(int inventario_id, int cantidad, String unidad, RestauranteM restaurante) {
		super();
		this.inventario_id = inventario_id;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.restaurante = restaurante;
	}
	
	
	public IngredienteInventarioM(int cantidad, String unidad, RestauranteM restaurante) {
		super();
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.restaurante = restaurante;
	}


	public int getInventario_id() {
		return inventario_id;
	}
	public void setInventario_id(int inventario_id) {
		this.inventario_id = inventario_id;
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
	public RestauranteM getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteM restaurante) {
		this.restaurante = restaurante;
	} 
	
	
}