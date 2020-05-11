package ingsoft1920.fnb.Beans;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.Model.ComandaM;


@Component
@SessionScope
public class CheckoutBean {
	Map<Integer,ArrayList<ComandaM>> listaComandas;
	
	public CheckoutBean() {
		java.util.List<ComandaM> lista= ComandaDAO.comandasCompletadasCocina(3);
		listaComandas= new HashMap<Integer, ArrayList<ComandaM>>();
		ArrayList<ComandaM> aux = new ArrayList<ComandaM>();
		
		
		if(lista.size()>1) {
			
			aux= new ArrayList<ComandaM>();
			aux.add(lista.get(0));
			listaComandas.put(lista.get(0).getMesa().getNum_mesa(),aux);
			
		
		for (int i = 1; i < lista.size(); i++) {
			
			
			if (listaComandas.containsKey(lista.get(i).getMesa().getNum_mesa())) {
				
				aux.add(lista.get(i));
				
			}else {
				
				ArrayList<ComandaM> listaAnterior= (ArrayList<ComandaM>) listaComandas.get(lista.get(i-1).getMesa().getNum_mesa()).clone();
				
				for (int j = 0; j < listaAnterior.size(); j++) {
					
					aux.add(listaAnterior.get(j));
				}
				
				listaComandas.put(lista.get(0).getMesa().getNum_mesa(),aux);
				
				aux= new ArrayList<ComandaM>();
				
				
				
				
			}
			
			
			
		}
		}
		
		
		
	}

	public Map<Integer, ArrayList<ComandaM>> getListaComandas() {
		return listaComandas;
	}

	public void setListaComandas(Map<Integer, ArrayList<ComandaM>> listaComandas) {
		this.listaComandas = listaComandas;
	}


	
	
	
	

}
