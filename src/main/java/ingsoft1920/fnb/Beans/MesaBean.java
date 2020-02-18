package ingsoft1920.fnb.Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MesaBean {
	
		Map<Integer,Boolean> listaMesas;

		public Map<Integer, Boolean> getListaMesas() {
			return listaMesas;
		}

		public void setListaMesas(Map<Integer, Boolean> listaMesas) {
			this.listaMesas = listaMesas;
		}

		public MesaBean(Map<Integer, Boolean> listaMesas) {
			super();
			this.listaMesas = listaMesas;
		}
		
		
		public MesaBean() {
			
			
			
			
			
			//query
		}
		



}
