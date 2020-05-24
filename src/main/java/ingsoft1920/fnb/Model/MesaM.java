package ingsoft1920.fnb.Model;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Controller.ApisDHO;
import ingsoft1920.fnb.Model.MesaHabitacionM;

public class MesaM {

	private int mesa_id;
	private int num_mesa;
	private int capacidad;
	private RestauranteM restaurante;
	private Boolean disponible;
	private MesaHabitacionM habitacion;
	private MenuM menu;
	private HotelM hotel;
	
	public MesaM(int mesa_id, int num_mesa, MesaHabitacionM habitacion, MenuM menu, HotelM hotel) {
		super();
		this.mesa_id = mesa_id;
		this.num_mesa = num_mesa;
		this.habitacion = habitacion;
		this.menu = menu;
		this.hotel=hotel;
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

	
	
	public MesaM(int mesa_id, int num_mesa) {
		super();
		this.mesa_id = mesa_id;
		this.num_mesa = num_mesa;
	}

	public MesaHabitacionM getHabitacion() {
		return habitacion;
	}

	public HotelM getHotel() {
		return hotel;
	}

	public void setHotel(HotelM hotel) {
		this.hotel = hotel;
	}

	public void setHabitacion(MesaHabitacionM habitacion) {
		this.habitacion = habitacion;
	}

	public MesaM(int mesa_id) {
		this.mesa_id = mesa_id;
	}

	public MenuM getMenu() {
		return menu;
	}

	public void setMenu(MenuM menu) {
		this.menu = menu;
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
				+ ", disponible=" + disponible + "]";
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public boolean filtro(int mesaid) {
		System.out.println("el valor es tal tal");
		return MesaDAO.enPersona(mesaid);
	}
	public String apinombre(String numero) {
		
		if(numero.equals("Asignar")) {
			
			return "";
			
		}else {
		
		return ApisDHO.nombreHabitacion(Integer.parseInt(numero));
		}
	}
	public int numhabitación() {
		return habitacion.getNum_habitacion();
	}


}
