package ingsoft1920.ejemplo.Model;

public class Item_menuM {

	private ItemM item;
	private MenuM menu;
	private float precio;

	public Item_menuM(float precio) {
		super();
		this.precio = precio;
	}
	public Item_menuM(ItemM item, MenuM menu, float precio) {
		super();
		this.item = item;
		this.menu = menu;
		this.precio = precio;
	}

	public ItemM getItem() {
		return item;
	}
	public void setItem(ItemM item) {
		this.item = item;
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
