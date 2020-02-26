package ingsoft1920.fnb.Model;

public class Plato_menuM {

	private PlatoM plato;
	private MenuM menu;
	private float precio;

	public Plato_menuM(float precio) {
		super();
		this.precio = precio;
	}
	public Plato_menuM(PlatoM plato, MenuM menu, float precio) {
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}


}
