package ingsoft1920.fnb.Model;

public class Item_menuM {

	private ItemM item;
	private MenuM menu;
	private float precio;
	private boolean vip;
	
	public Item_menuM(float precio, boolean vip) {
		super();
		this.precio = precio;
		this.vip=vip;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

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
