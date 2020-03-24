package ingsoft1920.fnb.Beans;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	LocalDateTime hora;
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
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}
	public Tarea(int idMesa, Map<String, platos> listaPlatos, Map<String, bebidas> listaBebidas, LocalDateTime hora) {
		super();
		this.idMesa = idMesa;
		this.listaPlatos = listaPlatos;
		this.listaBebidas = listaBebidas;
		this.hora = hora;
	}
	
	public void addPlato(String plato,int id,int cantidad) {
		System.out.println(plato+"plato que le viene!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(cantidad+"plato que le viene!!!!!!!!!!!!!!!!!!!!!!");
		
		/*if (listaPlatos.containsKey(plato)) {
			platos p =listaPlatos.get(plato);
			p.setUnidades(p.getUnidades()+1);
			System.out.println("plato con nueva cantidad!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			listaPlatos.replace(plato, p);
			//System.out.println(":------------:"+listaPlatos.toString());
			
			
		}else {
			//System.out.println(":------------:"+listaPlatos.toString());
			listaPlatos.put(plato, new platos(id,1));
			
		}
		*/
		
		listaPlatos.put(plato,new platos(id, cantidad));
		
		
	}
	
	public Tarea() {
		
		listaPlatos= new HashMap<String, platos>();
		listaBebidas = new HashMap<String, bebidas>();
	}

}
