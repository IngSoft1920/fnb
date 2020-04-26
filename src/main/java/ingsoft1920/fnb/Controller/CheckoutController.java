package ingsoft1920.fnb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CheckoutController {
	
	
	@RequestMapping("/pruebaliberarmesas")
	public String showcheckout(Model model) {
		
		
		return "checkout";
				
				
	}
}
