package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.catalina.startup.Catalina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ingsoft1920.fnb.Beans.CartaBean;
import ingsoft1920.fnb.DAO.InventarioDAO;
import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.Model.IngredienteInventarioM;
import ingsoft1920.fnb.Model.IngredienteM;
import ingsoft1920.fnb.Model.ItemM;
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
	


	@GetMapping("/asignarUnidad")
	public String asignarUnidad(@Valid @RequestParam("w") String unidad,@Valid @RequestParam("producto") String producto,@Valid @RequestParam("cantidad") String cantidad, Model model){
		System.out.println(producto+"Hola");
		System.out.println(cantidad+"WTF");
		System.out.println(unidad+"Unidad");
		cartaBean.setUnidad(unidad);
		cartaBean.setCantidades(cantidad);
		cartaBean.setProducto(producto);
		System.out.println(cartaBean.getProducto()+"Esto es");
		model.addAttribute("cartaBean",cartaBean);
		return "webMetreModificacion";
	}
	@PostMapping("/pedidoRecibido")
	public String pedidoRecibido(@Valid @RequestParam("producto") String producto,@Valid @RequestParam("cantidad") String cantidad,Model model){
		System.out.println(producto+"Hola2");
		System.out.println(cantidad);
		String unit =cartaBean.getUnidad();
		List<IngredienteInventarioM> list = InventarioDAO.inventario("Mamma Mia");
		Map<String, ItemM> listBeb=ItemDAO.itemsRest("Mamma Mia");
		int cant;
		
		for (IngredienteInventarioM ingredienteInventarioM : list) {
			if(ingredienteInventarioM.getIngrediente().getNombre().equals(producto)){

				try {  
					cant= Integer.parseInt(cantidad); 
					
					if(listBeb.containsKey(producto)){

						PlatoDAO.updateItem(producto, Integer.parseInt(cantidad));
		
						}else {

							PlatoDAO.updateIngrediente(producto, cant, unit);
		
						}

				 } catch(NumberFormatException nfe) {  
					 // Log exception.
					 cant= 0;
				 } 

				

			}
			
		}
		for (IngredienteInventarioM ingredienteInventarioM : list) {
			
		}
		
		model.addAttribute("cartaBean",cartaBean);
		
		return "webMetreModificacion";
	}

	@RequestMapping("/Adho")
public RedirectView localRedirect() {
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl("http://piedrafita.ls.fi.upm.es:7001/homePageDHO/menu/pedidos");
    return redirectView;
}

}
