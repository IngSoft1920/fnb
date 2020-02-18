package ingsoft1920.fnb.Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ingsoft1920.fnb.Beans.platos;
import ingsoft1920.fnb.Beans.bebidas;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ComandaBean {
	ArrayList<String> listaPlatos;
	ArrayList<String> listaBebida;
	 Map<String, platos> cantidades;
	 Map<String, bebidas> bebidas;
	String platoNuevo;
	int cantidadNueva;
	
	public ComandaBean() {
		//query
		this.listaPlatos=new ArrayList<String>();
		this.listaBebida=new ArrayList<String>();
		this.listaPlatos.add("lentejas");
		this.listaPlatos.add("potaje");
		this.listaBebida.add("Ron Barceló");
		this.listaBebida.add("almirante");
		this.cantidades=new HashMap<String, platos>();
		this.bebidas=new HashMap<String, bebidas>();
		int idComida=0;
		int idBebida=0;
		for(int i=0;i<listaPlatos.size();i++) {
			this.cantidades.put(this.listaPlatos.get(i), new platos(idComida++,0));
			this.bebidas.put(this.listaBebida.get(i),new bebidas(idBebida++,0));
			
		}
		System.out.println(listaBebida.toString());
	}
	
	public String getPlatoNuevo() {
		return this.platoNuevo;
	}
	
	public void setPlatoNuevo(String platoNuevo) {
		this.platoNuevo= platoNuevo;
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
	

}
