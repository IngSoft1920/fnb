package ingsoft1920.fnb.Beans;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.Controller.ApisDHO;
import ingsoft1920.fnb.Controller.ApisFnb;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Model.MesaM;



@Component
@SessionScope
public class ListaReservasBean {
	List<MesaM> listaMesas;
	Map<Integer,String> mapAsign;
	Map<Integer,String> mapAsignRes;
	Map<Integer,String> mapNombreCliente;
	List<Integer> mesasReservadas;
	//ArrayList<reservas>listareservas;
	//JSONObject rs;

	public Map<Integer, String> getMapAsignRes() {
		return mapAsignRes;
	}

	public void setMapAsignRes(Map<Integer, String> mapAsignRes) {
		this.mapAsignRes = mapAsignRes;
	}

	public ListaReservasBean(List<MesaM> listaMesas) {
		super();
		this.listaMesas = listaMesas;
	}
	
	public ListaReservasBean() {
		listaMesas= new ArrayList<MesaM>();
		mesasReservadas= ApisDHO.habitacionesReservadas();
		
		List<MesaM> list = MesaDAO.mesasDisp();
		mapAsign =  new HashMap<Integer, String>();
		mapAsignRes= new HashMap<Integer, String>();
		mapNombreCliente= new HashMap<Integer, String>();
		for (MesaM mesa : list) {
			if(mesa.getRestaurante().getNombre().equals("Mamma Mia")) {
			listaMesas.add(mesa);
			mapAsign.put(mesa.getNum_mesa(),"Asignar");
			mapAsignRes.put(mesa.getNum_mesa(), "Asignar reserva");
			mapNombreCliente.put(mesa.getNum_mesa(),"");
			}
		}
		
		
	}
	
	
	public List<Integer> getListaHabReservadas(){
		
		return this.mesasReservadas;
	}
	
	public void  putNombre(int idMesa,String nombre) {
		
		mapNombreCliente.put(idMesa, nombre);
		
		
		
		
	} 
	
	public String getNombre(int idMesa) {
		
		return mapNombreCliente.get(idMesa);
		
		
	}
	
	
	public Map<Integer, String> getMapAsign() {
		return mapAsign;
	}

	public void setMapAsign(Map<Integer, String> mapAsign) {
		this.mapAsign = mapAsign;
	}

	@Override
	public String toString() {
		return "ListaReservasBean [listaMesas=" + listaMesas + ", mapAsign=" + mapAsign + ", mapAsignRes=" + mapAsignRes
				+ "]";
	}

	public List<MesaM> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<MesaM> listaMesas) {
		this.listaMesas = listaMesas;
	}
	public int findCap(int id) {
		
		
		int i=0;
		boolean found=false;
		while(i<listaMesas.size() && !found) {
			
			if(listaMesas.get(i).getMesa_id()==id){
				
				found=true;
			}else {
			
			i++;
			}
		}
		
		return i;
		
		
	}
	
	/*public ListaReservasBean() {
		listareservas=new ArrayList<reservas>();
		listareservas.add(new reservas(LocalDate.now().toString(),4,"Julian"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Peter"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Cloe"));
		
		
	}*/
	
}
