package ingsoft1920.fnb.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import ingsoft1920.fnb.Controller.CamareroController;
@Component
public class NombreCantidaBean {
	
	List<platos> platos= new ArrayList<platos>();
	List<Integer> cantidades = new ArrayList<Integer>();
	String numbrePlato;
	int contador;
	
	
	public  void add() {
		System.out.println("--------------");
		int i=0;
		while(!this.platos.get(i).getNombre().equals(numbrePlato) && i<platos.size()) {
			
			
		i++;	
			
		}
		cantidades.set(i,contador);
		
		
		
		
		
	}
	
	

}
