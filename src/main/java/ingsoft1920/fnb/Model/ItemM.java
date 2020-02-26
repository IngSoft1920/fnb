package ingsoft1920.fnb.Model;

public class ItemM {

	private int item_id;
	private String tipo;
	private String nombre;
	private ElemComandaM elemcomanda;
	private MenuM menu;
	private Item_menuM item_menu;

	public ItemM(int item_id, String tipo,String nombre, ElemComandaM elemcomanda) {
		this.item_id = item_id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.elemcomanda = elemcomanda;
	}
	public ItemM(int item_id, String tipo,String nombre, MenuM menu, Item_menuM item_menu) {
		this.nombre = nombre;
		this.item_id = item_id;
		this.tipo = tipo;
		this.menu = menu;
		this.item_menu = item_menu;
	}

	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ElemComandaM getElemcomanda() {
		return elemcomanda;
	}
	public void setElemcomanda(ElemComandaM elemcomanda) {
		this.elemcomanda = elemcomanda;
	}
	public MenuM getMenu() {
		return menu;
	}
	public void setMenu(MenuM menu) {
		this.menu = menu;
	}
	public Item_menuM getItem_menu() {
		return item_menu;
	}
	public void setItem_menu(Item_menuM item_menu) {
		this.item_menu = item_menu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
