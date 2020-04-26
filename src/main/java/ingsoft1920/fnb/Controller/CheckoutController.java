package ingsoft1920.fnb.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.fnb.Beans.CheckoutBean;
import ingsoft1920.fnb.Beans.TareasBean;
import ingsoft1920.fnb.DAO.ComandaDAO;
@Controller
public class CheckoutController {
	@Autowired
	
	TareasBean tareasBean;
	
	
	@RequestMapping("/pruebaliberarmesas")
	public String showcheckout(Model model) {
		
		tareasBean= new TareasBean();
		model.addAttribute("tareasBean",tareasBean);
		
		return "checkout";
				
				
	}
	
	@PostMapping("/chekinOut")
	public String checkOut( @Valid @RequestParam("checkOut") String checkOut, Model model){
		
		ComandaDAO.checkout(Integer.parseInt(checkOut));
		tareasBean.removeMesa(Integer.parseInt(checkOut));
		
		model.addAttribute("tareasBean",tareasBean);
		
		
		return "checkout";
	}
}
