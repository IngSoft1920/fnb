package ingsoft1920.fnb.Beans;

import org.springframework.stereotype.Component;

@Component
public class EmpleadoBean {
	
	private int id_empleado;
	private String nombre;
	private boolean estado;
	
	public EmpleadoBean(int id_empleado, String nombre, boolean estado) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.estado = estado;
	}
	public EmpleadoBean() {}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
