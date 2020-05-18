package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.fnb.Beans.CartaBean;
import ingsoft1920.fnb.Model.IngredienteM;
import ingsoft1920.fnb.Model.PlatoIngredienteM;
import ingsoft1920.fnb.Model.PlatoM;

@Controller
public class metreModificacionController {
	
	CartaBean cartaBean;
	
	@GetMapping("/modificacion")
	public String modificacionIni(Model model) {

		cartaBean= new CartaBean();
		
		model.addAttribute("cartaBean",cartaBean);
		
		
		return "webMetreModificacion";
	}
	

}
