package ingsoft1920.fnb.Model;

public class Item_menuM {

	private ItemM item;
	private MenuM menu;
	private int precio;

	public Item_menuM(int precio) {
		super();
		this.precio = precio;
	}
	public Item_menuM(ItemM item, MenuM menu, int precio) {
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
