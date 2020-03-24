package ingsoft1920.fnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.fnb.Beans.luisBean;

@Controller
public class pruebaController {
	
	@Autowired
	luisBean luisMesa;
	
	@GetMapping("/prueba")
	public String pruebaontroller(Model model) {
		
		model.addAttribute("luisMesa", luisMesa);
		
		return "dibujomesasprueba";
		
	}
}
