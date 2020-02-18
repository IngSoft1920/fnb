package ingsoft1920.fnb.Beans;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Beans.platos;
import ingsoft1920.fnb.Model.ItemM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Beans.bebidas;
import org.springframework.stereotype.Component;
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
	String nombreRestaurante="Mamma Mia";
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
		Map<String,PlatoM> listaPlat=PlatoDAO.platosRest(nombreRestaurante);
		for (Entry<String,PlatoM> plato : listaPlat.entrySet()) {
			
			this.cantidades.put(plato.getKey(),new platos(idComida++,0));
			
		}
		Map<String,ItemM> listBebidas = ItemDAO.itemsRest(nombreRestaurante);
		for (Entry<String,ItemM> listaItem : listBebidas.entrySet()) {
			
			this.bebidas.put(listaItem.getKey(), new bebidas(idBebida++,0));
			
		}
		ConectorBBDD.desconectar();
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
