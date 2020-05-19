package ingsoft1920.fnb.Beans;

import org.springframework.stereotype.Component;

public class platos {
	@Override
	public String toString() {
		return "platos [id=" + id +"," + unidades + "]";
	}

	private int id;
	private String nombre;
	private int unidades=0;
	private boolean vip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getVip(){
		return vip;
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
	public platos(int id, int unidades,boolean vip) {
	
		this.id = id;
		this.unidades = unidades;
		this.vip=vip;
	}
	public platos(int id, int unidades) {
	
		this.id = id;
		this.unidades = unidades;
		
	}
	
	public platos() {}
	

}
