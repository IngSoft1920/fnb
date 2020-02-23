package ingsoft1920.fnb.Beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
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
	
	public void addPlato(String plato,int id) {
		
		if (listaPlatos.containsKey(plato)) {
			platos p =listaPlatos.get(plato);
			p.setUnidades(p.getUnidades()+1);
			listaPlatos.replace(plato, p);
			
			
		}else {
			
			listaPlatos.put(plato, new platos(id,1));
			
		}
		
		
		
	}
	
	public Tarea() {
		
		listaPlatos= new HashMap<String, platos>();
		listaBebidas = new HashMap<String, bebidas>();
	}

}
