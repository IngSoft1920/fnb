package ingsoft1920.fnb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class metreModificacionController {
	
	
	@GetMapping("/modificacion")
	public String modificacionIni(Model model) {
		
		
		return "webMetreModificacion";
	}
	

}
