package ingsoft1920.fnb.Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Model.MesaM;


@Component
@SessionScope
public class luisBean {
	
	List<MesaM> listaMesas;

	
	public luisBean() {
		
		
	
		listaMesas = new ArrayList<MesaM>();
		listaMesas = MesaDAO.mesasDisp();
		System.out.println(listaMesas.toString());
		
		
	}


	@Override
	public String toString() {
		return "luisBean [listaMesas=" + listaMesas + "]";
	}


	public List<MesaM> getListaMesas() {
		return listaMesas;
	}


	public void setListaMesas(List<MesaM> listaMesas) {
		this.listaMesas = listaMesas;
	}
	public Integer prueba() {
		
		return 5;
	}
	

}
