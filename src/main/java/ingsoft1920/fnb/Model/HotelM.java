package ingsoft1920.fnb.Model;

public class HotelM {
	private int hotel_id;
	private String nombre;
	public HotelM(int hotel_id, String nombre) {
		super();
		this.hotel_id = hotel_id;
		this.nombre = nombre;
	}
	public HotelM(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
