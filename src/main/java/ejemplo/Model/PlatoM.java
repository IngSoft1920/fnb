package ingsoft1920.ejemplo.Model;

public class PlatoM {
	private int plato_id;
	private String tipo;
	private int num_plato;
	private String nombre;
	private ElemComandaM elemComanda;
	private MenuM menu;
	private Plato_menuM plato_menu;

	public PlatoM(int plato_id, String tipo, int num_plato, String nombre, ElemComandaM elemComanda) {
		this.plato_id = plato_id;
		this.tipo = tipo;
		this.num_plato = num_plato;
		this.nombre = nombre;
		this.elemComanda = elemComanda;
	}
	public PlatoM(int plato_id, String tipo, int num_plato, String nombre, MenuM menu, Plato_menuM plato_menu) {
		this.plato_id = plato_id;
		this.tipo = tipo;
		this.num_plato = num_plato;
		this.nombre = nombre;
		this.menu = menu;
		this.plato_menu = plato_menu;
	}
	
	public PlatoM(int plato_id ,int num_plato, String nombre) {
		this.plato_id = plato_id;
		this.num_plato = num_plato;
		this.nombre = nombre;
	}

	public int getPlato_id() {
		return plato_id;
	}
	public void setPlato_id(int plato_id) {
		this.plato_id = plato_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNum_plato() {
		return num_plato;
	}
	public void setNum_plato(int num_plato) {
		this.num_plato = num_plato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ElemComandaM getElemComanda() {
		return elemComanda;
	}
	public void setElemComanda(ElemComandaM elemComanda) {
		this.elemComanda = elemComanda;
	}
	public MenuM getMenu() {
		return menu;
	}
	public void setMenu(MenuM menu) {
		this.menu = menu;
	}
	public Plato_menuM getPlato_menu() {
		return plato_menu;
	}
	public void setPlato_menu(Plato_menuM plato_menu) {
		this.plato_menu = plato_menu;
	}


}
