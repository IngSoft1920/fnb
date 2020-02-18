package ingsoft1920.ejemplo.Beans;

import org.springframework.stereotype.Component;

public class platos {
	@Override
	public String toString() {
		return "platos [id=" + id +"," + unidades + "]";
	}

	private int id;
	private String nombre;
	private int unidades=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public platos(int id, int unidades) {
	
		this.id = id;
		this.unidades = unidades;
	}
	
	public platos() {}
	

}
