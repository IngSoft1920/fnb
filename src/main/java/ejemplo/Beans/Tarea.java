package ingsoft1920.ejemplo.Beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class Tarea {
	
	@Override
	public String toString() {
		return "Tarea [idMesa=" + idMesa + ", listaPlatos=" + listaPlatos + ", listaBebidas=" + listaBebidas + ", hora="
				+ hora + "]";
	}

	int idMesa;
	Map<String,platos> listaPlatos;
	Map<String,bebidas> listaBebidas;
	LocalDate hora;
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public Map<String, platos> getListaPlatos() {
		return listaPlatos;
	}
	public void setListaPlatos(Map<String, platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}
	public Map<String, bebidas> getListaBebidas() {
		return listaBebidas;
	}
	public void setListaBebidas(Map<String, bebidas> listaBebidas) {
		this.listaBebidas = listaBebidas;
	}
	public LocalDate getHora() {
		return hora;
	}
	public void setHora(LocalDate hora) {
		this.hora = hora;
	}
	public Tarea(int idMesa, Map<String, platos> listaPlatos, Map<String, bebidas> listaBebidas, LocalDate hora) {
		super();
		this.idMesa = idMesa;
		this.listaPlatos = listaPlatos;
		this.listaBebidas = listaBebidas;
		this.hora = hora;
	}
	
	public Tarea() {}
}
