package ingsoft1920.ejemplo.Model;

public class MesaM {

	private int mesa_id;
	private int num_mesa;
	private int capacidad;
	RestauranteM restaurante;
	Boolean disponible;

	public MesaM(int mesa_id, int num_mesa, int capacidad) {
		this.mesa_id = mesa_id;
		this.num_mesa = num_mesa;
		this.capacidad = capacidad;
		this.restaurante=null;
		this.disponible=null;
	}

	public MesaM(int mesa_id, int num_mesa, int capacidad, RestauranteM restaurante, boolean disponible) {
		this.mesa_id = mesa_id;
		this.num_mesa = num_mesa;
		this.capacidad = capacidad;
		this.restaurante = restaurante;
		this.disponible = disponible;
	}


	public int getMesa_id() {
		return mesa_id;
	}
	public void setMesa_id(int mesa_id) {
		this.mesa_id = mesa_id;
	}
	public int getNum_mesa() {
		return num_mesa;
	}
	public void setNum_mesa(int num_mesa) {
		this.num_mesa = num_mesa;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public RestauranteM getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteM restaurante) {
		this.restaurante = restaurante;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "MesaM [mesa_id=" + mesa_id + ", num_mesa=" + num_mesa + ", capacidad=" + capacidad + ", restaurante="
				+ restaurante.getNombre() + ", disponible=" + disponible + "]";
	}


}
