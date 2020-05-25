package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.Map.Entry;

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
import ingsoft1920.fnb.Model.ComandaM;
@Controller
public class CheckoutController {
	
	
	CheckoutBean checkOut;
	
	
	@RequestMapping("/pruebaliberarmesas")
	public String showcheckout(Model model) {
		
		checkOut= new CheckoutBean();
		
		
		model.addAttribute("checkOutBean",checkOut);
		
		return "checkout";
				
				
	}
	
	@PostMapping("/chekinOut")
	public String checkOut( @Valid @RequestParam("checkOut") String checkOut, Model model){
		// necesita hacerse un bucle sobre la lista para quitar todas las comandas de una mesa
		
		ArrayList<ComandaM> list = this.checkOut.list(Integer.parseInt(checkOut));
		System.out.println("lista checkout-->"+list.toString());
		for (int i = 0; i < list.size()-1; i++) {
			
			ComandaDAO.checkout(list.get(i).getComanda_id(), false);
			
		}
		
		ComandaDAO.checkout(list.get(list.size()-1).getComanda_id(), true);
		this.checkOut= new CheckoutBean();
		model.addAttribute("tareasBean",this.checkOut);
		
		
		return "checkout";
	}
}
