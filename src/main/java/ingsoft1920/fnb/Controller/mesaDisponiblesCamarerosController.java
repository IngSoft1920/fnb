package ingsoft1920.fnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ingsoft1920.fnb.Beans.MesaBean;

@Controller
public class mesaDisponiblesCamarerosController {
	
	@Autowired
	MesaBean mesaBean;
	
	@RequestMapping("/mesas")
	public String showPaginaComandaGet(Model model) {
		
		mesaBean = new MesaBean();
		
		model.addAttribute("mesaBean", mesaBean);
		return "mesasDisponiblesCamareros";
	}
	


}
