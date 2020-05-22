package ingsoft1920.fnb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.fnb.Beans.InventarioBean;

@Controller
public class InventarioController {

    InventarioBean inventarioBean;

    public InventarioController(){

        inventarioBean= new InventarioBean();
    }

    @GetMapping("/inventario")
	public String modificacionIni(Model model) {

		inventarioBean= new InventarioBean();
		
		
		model.addAttribute("inventarioBean",inventarioBean);
		
		
		return "webInventario";
	}



    
}