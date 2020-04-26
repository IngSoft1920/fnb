package ingsoft1920.fnb.Beans;

import java.util.ArrayList;



import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Beans.platos;
import ingsoft1920.fnb.Model.ItemM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Beans.bebidas;

import org.apache.coyote.Request;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.annotation.SessionScope;
import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.Services.ConectorBBDD;

@Component
@SessionScope
public class ComandaBean {
	ArrayList<String> listaPlatos;
	ArrayList<String> listaBebida;
	 Map<String, platos> cantidades;
	 Map<String, bebidas> bebidas;
	 Map<String,PlatoM> listaPlat;
	 Map<String,ItemM> listBebidas;
	 
	public Map<String, PlatoM> getListaPlat() {
		return listaPlat;
	}

	public Map<String, ItemM> getListBebidas() {
		return listBebidas;
	}

	String nombreRestaurante="Mamma Mia";
	int numMesa;
	String observaciones="";
	@Override
	public String toString() {
		return "ComandaBean [listaPlatos=" + listaPlatos + ", listaBebida=" + listaBebida + ", cantidades=" + cantidades
				+ ", bebidas=" + bebidas + ", nombreRestaurante=" + nombreRestaurante + ", numMesa=" + numMesa
				+ ", observaciones=" + observaciones + ", cantidadNueva=" + cantidadNueva + "]";
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ArrayList<String> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(ArrayList<String> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	public ArrayList<String> getListaBebida() {
		return listaBebida;
	}

	public void setListaBebida(ArrayList<String> listaBebida) {
		this.listaBebida = listaBebida;
	}

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public void setCantidades(Map<String, platos> cantidades) {
		this.cantidades = cantidades;
	}

	public void setBebidas(Map<String, bebidas> bebidas) {
		this.bebidas = bebidas;
	}

	int cantidadNueva;
	
	public ComandaBean() {
		//query
		int idComida=0;
		int idBebida=0;
		this.listaPlatos=new ArrayList<String>();
		this.listaBebida=new ArrayList<String>();
		this.cantidades=new HashMap<String, platos>();
		this.bebidas=new HashMap<String, bebidas>();
		ConectorBBDD.conectar();
		listaPlat=PlatoDAO.platosRest(nombreRestaurante);
		for (Entry<String,PlatoM> plato : listaPlat.entrySet()) {
	
			this.cantidades.put(plato.getKey(),new platos(idComida++,0));
			
		}
		listBebidas = ItemDAO.itemsRest(nombreRestaurante);
		for (Entry<String,ItemM> listaItem : listBebidas.entrySet()) {
			
			this.bebidas.put(listaItem.getKey(), new bebidas(idBebida++,0));
			
		}
		ConectorBBDD.desconectar();
		
		/*List<String> listaPlatos = new ArrayList<String>();
		List<String> listaBebida = new ArrayList<String>();

		listaPlatos.add("lentejas");
		listaPlatos.add("potaje");
		listaBebida.add("Ron Barceló");
		listaBebida.add("almirante");
		cantidades = new HashMap<String, platos>();
		bebidas = new HashMap<String, bebidas>();
		
		for (int i = 0; i < listaPlatos.size(); i++) {
			this.cantidades.put(listaPlatos.get(i), new platos(idComida++, 0));
			this.bebidas.put(listaBebida.get(i), new bebidas(idBebida++, 0));

		}*/
		System.out.println(bebidas.toString());
		System.out.println(cantidades.toString());
		 
	}
	
	public String getPlatoNuevo() {
		return this.nombreRestaurante;
	}
	
	public void setPlatoNuevo(String platoNuevo) {
		this.nombreRestaurante= platoNuevo;
	}
	
	public int getCantidadNueva() {
		return this.cantidadNueva;
	}
	
	public void setCantidadNueva(int cantidadNueva) {
		this.cantidadNueva=cantidadNueva;
	}
	
	public  Map<String, platos> getCantidades(){
		return cantidades;
	}
	
	public Map<String, bebidas> getBebidas(){
		
		
		return bebidas;
	}                                                                                                           
	public Map<String,Integer> listabebidasApedir(){
		
		Map<String,Integer> lista = new HashMap<String, Integer>();
		
		for(Entry<String,bebidas> bebidas :this.bebidas.entrySet()) {
			
			if(bebidas.getValue().getUnidades()!=0) {
				
				lista.put(bebidas.getKey(), bebidas.getValue().getUnidades());
			}
			
			
		}
		return lista;
		
	}

public Map<String,Integer> listaMenuApedir(){
		
		Map<String,Integer> lista = new HashMap<String, Integer>();
		
		for(Entry<String,platos> menu :this.cantidades.entrySet()) {
			
			if(menu.getValue().getUnidades()!=0) {
				
				lista.put(menu.getKey(), menu.getValue().getUnidades());
			}
			
			
		}
		return lista;
		
	}
}
