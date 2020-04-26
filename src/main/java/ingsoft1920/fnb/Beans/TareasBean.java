package ingsoft1920.fnb.Beans;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.DAO.InventarioDAO;
import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Model.ComandaM;
import ingsoft1920.fnb.Model.IngredienteInventarioM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoIngredienteM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Services.ConectorBBDD;
import ingsoft1920.fnb.Beans.bebidas;
import ingsoft1920.fnb.Beans.platos;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class TareasBean {

	Map<Integer, Tarea> listaTareas;
	public List<MyEntry<Integer, Integer>> getListaMesaComanda() {
		return listaMesaComanda;
	}

	public void setListaMesaComanda(List<MyEntry<Integer, Integer>> listaMesaComanda) {
		this.listaMesaComanda = listaMesaComanda;
	}

	List<Tarea> listaTar;
	List<IngredienteInventarioM> listaInventario;
	List<MyEntry<Integer, Integer>> listaMesaComanda;
	


	public Map<Integer, Tarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(Map<Integer, Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public TareasBean(Map<Integer, Tarea> listaTareas) {
		super();
		this.listaTareas = listaTareas;
	}

	public TareasBean() {
	
		// query
		/*
		List<String> listaPlatos = new ArrayList<String>();
		List<String> listaBebida = new ArrayList<String>();

		listaPlatos.add("lentejas");
		listaPlatos.add("potaje");
		listaBebida.add("Ron Barceló");
		listaBebida.add("almirante");
		Map<String, platos> cantidades = new HashMap<String, platos>();
		Map<String, bebidas> bebidas = new HashMap<String, bebidas>();
		int idComida = 0;
		int idBebida = 0;
		for (int i = 0; i < listaPlatos.size(); i++) {
			cantidades.put(listaPlatos.get(i), new platos(idComida++, 0));
			bebidas.put(listaBebida.get(i), new bebidas(idBebida++, 0));

		}

		listaTareas = new HashMap<Integer, Tarea>();
		listaTareas.put(1, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(2, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(3, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(4, new Tarea(1, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(5, new Tarea(3, cantidades, bebidas, LocalDate.now()));
		listaTareas.put(6, new Tarea(2, cantidades, bebidas, LocalDate.now()));
		System.out.println(listaTareas.toString());
		*/
		
		int id_comanda,contador=1;
		MesaM mesa;
		
		listaMesaComanda= new ArrayList<MyEntry<Integer,Integer>>();
		// tareas Cocina?
		
		List<ComandaM> comandas=new ArrayList<ComandaM>();
		listaTar=new ArrayList<Tarea>();

	 int i=0;
	 comandas=ComandaDAO.comandasTareaCocina(3);
	 comandas.add(new ComandaM(-2));
	 System.out.println("---------------------------------------------------------------------------+++-+-+-+");
	 System.out.println("size="+comandas.size());
	
	 int idAnterior=-1;
	 Tarea tar = null;
	 System.out.println(comandas.toString());
	 if(comandas!=null && comandas.size()>1) {
	 do {
	 
	 
	 id_comanda=comandas.get(i).getComanda_id();

	 System.out.println(id_comanda);
	 
	 if (comandas.get(i).getComanda_id()==-2) {
		 
		 //
			//System.out.println("ComandaMandada----->"+comandas.get(i).getComanda_id());
			//System.out.println("ComandaMandada----->"+mesa.getNum_mesa());
		//listaMesaComanda.add(new MyEntry<Integer, Integer>(mesa.getNum_mesa(), comm.getComanda_id()));
		 			
		 listaTar.add(tar);
		 System.out.println("comanda----->>>"+tar.getIdMesa());
		 if(tar.getIdMesa()!=-2) {
		 mesa=ComandaDAO.infoFacturas(tar.getIdMesa());
		 if(mesa!=null) {
			 listaMesaComanda.add(new MyEntry<Integer, Integer>(mesa.getNum_mesa(), tar.getIdMesa()));
		 }
		 }
		 break;
	 }
	 
	if(idAnterior!=id_comanda) {
		
		if(idAnterior!=-1) {
			 mesa=ComandaDAO.infoFacturas(comandas.get(i).getComanda_id());
				//System.out.println("ComandaMandada----->"+comandas.get(i).getComanda_id());
				//System.out.println("ComandaMandada----->"+mesa.getNum_mesa());
			//listaMesaComanda.add(new MyEntry<Integer, Integer>(mesa.getNum_mesa(), comm.getComanda_id()));
			 
			listaTar.add(tar);
			
		}
		System.out.println(comandas.get(i).getPlato().getNombre());
		
		//el numero de la comnada
		 tar =  new Tarea(id_comanda, new HashMap<String, platos>(), new HashMap<String, bebidas>(), comandas.get(i).getHora());
		 tar.addPlato(comandas.get(i).getPlato().getNombre(), comandas.get(i).getPlato().getPlato_id(),comandas.get(i).getPlato().getElemComanda().getN_elem());
		 
		 
		 idAnterior=id_comanda;
	
		
		 System.out.println("la bestia"+tar.toString());
	}else {

		tar.addPlato(comandas.get(i).getPlato().getNombre(), comandas.get(i).getPlato().getPlato_id(),comandas.get(i).getPlato().getElemComanda().getN_elem());
		System.out.println(comandas.get(i).getPlato().getPlato_id());
		System.out.println(comandas.get(i).getPlato().getNombre());
		
	}
	
	  
	 i++;
	 contador++;
	 
	 }
	 while(i<comandas.size());
	
	
	 }
	// System.out.println("he salido------------------------------------------------------");
	//System.out.println(listaTar.toString());
	 listaInventario=InventarioDAO.inventario("Mamma Mia");
	 
	 System.out.println("INVENTARIOO");
	 System.out.println(listaInventario.toString());
	 
	 idAnterior=-1;
	 
	 comandas= ComandaDAO.comandasTareaCocina(3);

	 for(ComandaM comm : comandas) {
		 
		 
		 if(idAnterior!=comm.getComanda_id()) {
		
		idAnterior=comm.getComanda_id();
		 }
		 
	 }
	
	}
	
	public List<IngredienteInventarioM> getListaInventario() {
		return listaInventario;
	}

	public void setListaInventario(List<IngredienteInventarioM> listaInventario) {
		this.listaInventario = listaInventario;
	}

	public List<Tarea> getListaTar() {
		return listaTar;
	}

	public void setListaTar(List<Tarea> listaTar) {
		this.listaTar = listaTar;
	}



	public List<Tarea> getLista(){
		return listaTar;
	}
	@Override
	public String toString() {
		return "TareasBean [listaTareas=" + listaTareas + "]";
	}
	
	public Tarea removeTask(int idComanda) {
		
		int i=0;
		while(i<listaTar.size()) {
			
			
			if(listaTar.get(i).getIdMesa()==idComanda) {
				break;
			}
			i++;
		}
		
		
		
		return (i!=listaTar.size())?listaTar.remove(i):null;
		
	}
	
	public void removeMesa(int comandaId) {		
		int i=0;
		boolean found=false;
		while(i<listaMesaComanda.size()&& !found) {
			
			if(listaMesaComanda.get(i).getValue()==comandaId) {
				
				found=true;
				listaMesaComanda.remove(i);
				
			}
		}
		
		
	}

}
