package ingsoft1920.fnb.Model;

import java.time.LocalDateTime;

public class MesaM {

	private int mesa_id;
	private int num_mesa;
	private int capacidad;
	private LocalDateTime fecha_reserva;
	private RestauranteM restaurante;
	private Boolean disponible;

	public MesaM(LocalDateTime fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	
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

	public LocalDateTime getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(LocalDateTime fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


}
