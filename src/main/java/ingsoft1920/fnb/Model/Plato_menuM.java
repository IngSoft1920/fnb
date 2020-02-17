package ingsoft1920.fnb.Model;

public class Plato_menuM {
	
	private PlatoM plato;
	private MenuM menu;
	private int precio;
	
	public Plato_menuM(int precio) {
		super();
		this.precio = precio;
	}
	public Plato_menuM(PlatoM plato, MenuM menu, int precio) {
		super();
		this.plato = plato;
		this.menu = menu;
		this.precio = precio;
	}
	
	public PlatoM getPlato() {
		return plato;
	}
	public void setPlato(PlatoM plato) {
		this.plato = plato;
	}
	public MenuM getMenu() {
		return menu;
	}
	public void setMenu(MenuM menu) {
		this.menu = menu;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
