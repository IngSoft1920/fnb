package ingsoft1920.fnb.Model;

public class MesaHabitacionM {
	private int mesa_id;
	private int habitacion_id;
	
	public MesaHabitacionM(int habitacion_id) {
		super();
		this.habitacion_id = habitacion_id;
	}
	public MesaHabitacionM(int mesa_id, int habitacion_id) {
		super();
		this.mesa_id = mesa_id;
		this.habitacion_id = habitacion_id;
	}
	public int getMesa_id() {
		return mesa_id;
	}
	public void setMesa_id(int mesa_id) {
		this.mesa_id = mesa_id;
	}
	public int getHabitacion_id() {
		return habitacion_id;
	}
	public void setHabitacion_id(int habitacion_id) {
		this.habitacion_id = habitacion_id;
	}
	
	
}

