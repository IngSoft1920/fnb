package ingsoft1920.fnb.Model;

import java.time.LocalTime;

public class RestauranteM {
	private int restaurante_id;
	private String nombre;
	private LocalTime hora_apertura;
	private LocalTime hora_clausura;

	public RestauranteM(int restaurante_id, String nombre, LocalTime hora_apertura, LocalTime hora_clausura) {
		this.restaurante_id = restaurante_id;
		this.nombre = nombre;
		this.hora_apertura = hora_apertura;
		this.hora_clausura = hora_clausura;
	}

	public RestauranteM(String nombre) {
		this.restaurante_id = -1;
		this.nombre = nombre;
		this.hora_apertura = null;
		this.hora_clausura = null;	}

	public int getRestaurante_id() {
		return restaurante_id;
	}
	public void setRestaurante_id(int restaurante_id) {
		this.restaurante_id = restaurante_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalTime getHora_apertura() {
		return hora_apertura;
	}
	public void setHora_apertura(LocalTime hora_apertura) {
		this.hora_apertura = hora_apertura;
	}
	public LocalTime getHora_clausura() {
		return hora_clausura;
	}
	public void setHora_clausura(LocalTime hora_clausura) {
		this.hora_clausura = hora_clausura;
	}

}
