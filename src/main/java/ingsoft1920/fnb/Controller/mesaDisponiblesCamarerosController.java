package ingsoft1920.fnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ingsoft1920.fnb.Beans.CheckoutBean;
import ingsoft1920.fnb.Beans.MesaBean;

@Controller
public class mesaDisponiblesCamarerosController {
	
	@Autowired
	MesaBean mesaBean;
	CheckoutBean checkout;
	
	@RequestMapping("/mesas")
	public String showPaginaComandaGet(Model model) {
		mesaBean=new MesaBean();
		model.addAttribute("mesaBean", mesaBean);
		return "mesasDisponiblesCamareros";
	}
	
	@PostMapping("/elcheckout")
	public String chekOut(Model model) {
		
		model.addAttribute("chequeos", checkout);
		
		
		return "checkout";
	}


}
