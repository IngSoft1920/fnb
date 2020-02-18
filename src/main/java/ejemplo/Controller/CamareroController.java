package ingsoft1920.ejemplo.Controller;

import java.util.ArrayList;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ingsoft1920.ejemplo.Beans.SignupBean;
import ingsoft1920.ejemplo.Beans.platos;
import ingsoft1920.ejemplo.Controller.*;
import ingsoft1920.ejemplo.Model.*;



@Controller
@RequestMapping("/home")
public class CamareroController {
	
	public List<platos> getListaPlatos(){
		List<platos> listaPlatos = new ArrayList<platos>();
		//query
		/*listaPlatos.add(new platos(0, "alubias",0));
		listaPlatos.add(new platos(1, "cocacola",0));
		listaPlatos.add(new platos(2, "gazpacho",0));
		listaPlatos.add(new platos(3, "arroz",0));
		listaPlatos.add(new platos(4, "alcachofa",0));*/
		
		return listaPlatos;
		
	}
	@GetMapping("/camareros")
	public String platos(Model model) {
		
		model.addAttribute("listaPlatos",getListaPlatos());
		
		System.out.println(getListaPlatos().toString());
		
		
		return "camareros";
				
				
	}
	

	

}
