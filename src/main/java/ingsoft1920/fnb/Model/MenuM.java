package ingsoft1920.fnb.Model;

public class MenuM {

	private int menu_id;
	private boolean disponible;
	private String titulo;

	public MenuM(String titulo) {
		this.titulo = titulo;
	}
	public MenuM(int menu_id, boolean disponible, String titulo) {
		this.menu_id = menu_id;
		this.disponible = disponible;
		this.titulo = titulo;
	}

	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


}
