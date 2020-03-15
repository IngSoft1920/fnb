package ingsoft1920.fnb.Beans;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ingsoft1920.fnb.Controller.ApisFnb;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Model.MesaM;



@Component
public class ListaReservasBean {
	List<MesaM> listaMesas;
	Map<Integer,String> mapAsign;
	//ArrayList<reservas>listareservas;
	//JSONObject rs;

	public ListaReservasBean(List<MesaM> listaMesas) {
		super();
		this.listaMesas = listaMesas;
	}
	
	public ListaReservasBean() {
		
		listaMesas= new ArrayList<MesaM>();
		List<MesaM> list = MesaDAO.mesasDisp();
		mapAsign =  new HashMap<Integer, String>();
		for (MesaM mesa : list) {
			if(mesa.isDisponible()) {
			listaMesas.add(mesa);
			mapAsign.put(mesa.getNum_mesa(),"Asignar");
			}
		}
		
	}

	public Map<Integer, String> getMapAsign() {
		return mapAsign;
	}

	public void setMapAsign(Map<Integer, String> mapAsign) {
		this.mapAsign = mapAsign;
	}

	@Override
	public String toString() {
		return "ListaReservasBean [listaMesas=" + listaMesas + ", mapAsign=" + mapAsign + "]";
	}

	public List<MesaM> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<MesaM> listaMesas) {
		this.listaMesas = listaMesas;
	}
	
	/*public ListaReservasBean() {
		listareservas=new ArrayList<reservas>();
		listareservas.add(new reservas(LocalDate.now().toString(),4,"Julian"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Peter"));
		listareservas.add(new reservas(LocalDate.now().toString(),8,"Cloe"));
		
		
	}*/
	
}
