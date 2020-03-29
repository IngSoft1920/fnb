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
public class MesaBean {
	
			List<Integer> listaMesas;

	
		
		@Override
			public String toString() {
				return "MesaBean [listaMesas=" + listaMesas + "]";
			}



		public List<Integer> getListaMesas() {
				return listaMesas;
			}



			public void setListaMesas(List<Integer> listaMesas) {
				this.listaMesas = listaMesas;
			}



		public MesaBean() {
			listaMesas= new ArrayList<Integer>();
			List<MesaM> list = MesaDAO.mesasDisp();
			
			for (MesaM mesa : list) {
				if(!mesa.isDisponible()) {
				listaMesas.add(mesa.getMesa_id());
				}
			}
			
		}
		



}
