package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.fnb.Beans.ComandaBean;
import ingsoft1920.fnb.Beans.bebidas;
import ingsoft1920.fnb.Beans.platos;
import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.Services.ConectorBBDD;

@Controller
public class ComandaController {
	@Autowired
	ComandaBean comandaBean;

	@RequestMapping("/camareros")
	public String showPaginaComandaGet(Model model) {
		
		
		model.addAttribute("comandaBean", comandaBean);
		
		System.out.println(comandaBean.getCantidades());
		return "camareros";
	}

	@PostMapping("/anadirItem")
	public String anadirElementoComanda(@Valid @RequestParam("platoNuevo") String nuevoPlato,@Valid @RequestParam("numMesa") String numMesa, Model model) {

		/*
		 * if(comandaBean.getCantidades().containsKey(nuevoPlato)) { int
		 * cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
		 * 
		 * //comandaBean.getCantidades().put(nuevoPlato,cant+1); }
		 */
		System.out.println(nuevoPlato+"`+++++++++++++++++++++++");
		platos entrada;
		Iterator<platos> it = comandaBean.getCantidades().values().iterator();
		boolean found = false;

		while (it.hasNext() && !found) {
			entrada = it.next();
			if (entrada.getId() == Integer.parseInt(nuevoPlato)) {
				found = true;
				entrada.setUnidades(entrada.getUnidades() + 1);
				Set<String> keyList = comandaBean.getCantidades().keySet();
				boolean foundKey = false;
				String key = null;
				for (String string : keyList) {

					if (comandaBean.getCantidades().get(string).equals(entrada) && !foundKey) {

						foundKey = true;
						key = string;
					}

				}

				if (key != null) {

					comandaBean.getCantidades().put(key, entrada);
				}

			}
		}
		if(!numMesa.equals("null")) {
		comandaBean.setNumMesa(Integer.parseInt(numMesa));
		}
		model.addAttribute("comandaBean", comandaBean);
		
		return "camareros";
	}

	@PostMapping("/quitarItem")
	public String eliminarElementoComanda(@Valid @RequestParam("platoNuevo") String nuevoPlato,@Valid @RequestParam("numMesa") String numMesa, Model model) {

		/*
		 * if(comandaBean.getCantidades().containsKey(nuevoPlato)) { int
		 * cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
		 * 
		 * //comandaBean.getCantidades().put(nuevoPlato,cant+1); }
		 */

		platos entrada;
		Iterator<platos> it = comandaBean.getCantidades().values().iterator();
		boolean found = false;

		while (it.hasNext() && !found) {
			entrada = it.next();
			if (entrada.getId() == Integer.parseInt(nuevoPlato)) {
				found = true;
				if (entrada.getUnidades() == 0) {
					model.addAttribute("comandaBean", comandaBean);
					return "camareros";
				}
				entrada.setUnidades(entrada.getUnidades() - 1);
				Set<String> keyList = comandaBean.getCantidades().keySet();
				boolean foundKey = false;
				String key = null;
				for (String string : keyList) {

					if (comandaBean.getCantidades().get(string).equals(entrada) && !foundKey) {

						foundKey = true;
						key = string;
					}

				}

				if (key != null) {

					comandaBean.getCantidades().put(key, entrada);
				}

			}
		}
		if(!numMesa.equals("null")) {
			comandaBean.setNumMesa(Integer.parseInt(numMesa));
			}
		model.addAttribute("comandaBean", comandaBean);

		return "camareros";
	}

	@PostMapping("/quitarBebida")
	public String eliminarBebidaComanda(@Valid @RequestParam("bebidaNueva") String nuevoPlato,@Valid @RequestParam("numMesa") String numMesa, Model model) {

		/*
		 * if(comandaBean.getCantidades().containsKey(nuevoPlato)) { int
		 * cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
		 * 
		 * //comandaBean.getCantidades().put(nuevoPlato,cant+1); }
		 */

		bebidas entrada;
		Iterator<bebidas> it = comandaBean.getBebidas().values().iterator();
		boolean found = false;

		while (it.hasNext() && !found) {
			entrada = it.next();
			if (entrada.getId() == Integer.parseInt(nuevoPlato)) {
				found = true;
				if (entrada.getUnidades() == 0) {
					model.addAttribute("comandaBean", comandaBean);
					return "camareros";
				}
				entrada.setUnidades(entrada.getUnidades() - 1);
				Set<String> keyList = comandaBean.getBebidas().keySet();
				boolean foundKey = false;
				String key = null;
				for (String string : keyList) {

					if (comandaBean.getBebidas().get(string).equals(entrada) && !foundKey) {

						foundKey = true;
						key = string;
					}

				}

				if (key != null) {

					comandaBean.getBebidas().put(key, entrada);
				}

			}
		}
		if(!numMesa.equals("null")) {
			comandaBean.setNumMesa(Integer.parseInt(numMesa));
			}
		model.addAttribute("comandaBean", comandaBean);
		return "camareros";
	}

	@PostMapping("/anadirBebida")
	public String anadirBebidaComanda(@Valid @RequestParam("bebidaNueva") String nuevoPlato,@Valid @RequestParam("numMesa") String numMesa, Model model) {

		/*
		 * if(comandaBean.getCantidades().containsKey(nuevoPlato)) { int
		 * cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
		 * 
		 * //comandaBean.getCantidades().put(nuevoPlato,cant+1); }
		 */

		bebidas entrada;
		Iterator<bebidas> it = comandaBean.getBebidas().values().iterator();
		boolean found = false;

		while (it.hasNext() && !found) {
			entrada = it.next();
			if (entrada.getId() == Integer.parseInt(nuevoPlato)) {
				found = true;
				entrada.setUnidades(entrada.getUnidades() + 1);
				
				Set<String> keyList = comandaBean.getBebidas().keySet();
				boolean foundKey = false;
				String key = null;
				for (String string : keyList) {

					if (comandaBean.getBebidas().get(string).equals(entrada) && !foundKey) {

						foundKey = true;
						key = string;
					}

				}

				if (key != null) {

					comandaBean.getBebidas().put(key, entrada);
				}

			}
		}
		if(!numMesa.equals("null")) {
			comandaBean.setNumMesa(Integer.parseInt(numMesa));
			}
		model.addAttribute("comandaBean", comandaBean);

		return "camareros";
	}

	@PostMapping("/enviarComanda")
	public String enviarComandaPost(@Valid @RequestParam("numMesa") String numMesa, Model model) {
		ComandaBean comandaBean = this.comandaBean;
		System.out.println("Mesa: " + numMesa);

		// JSON AND INTERNAL STUFF HERE

		Map<String, Integer> listaBebidas = comandaBean.listabebidasApedir();
		Map<String, Integer> listaMenu = comandaBean.listaMenuApedir();
		List<String> platos = new ArrayList<String>();
		List<String> items = new ArrayList<String>();

		int i = 0;
		for (Entry<String, Integer> elem : listaBebidas.entrySet()) {

			items.add(elem.getKey());
			if (elem.getValue() != 0) {

				int cantidad = elem.getValue();
				while (cantidad != 0) {

					items.add(elem.getKey());
					cantidad--;

				}

			}

		}
		System.out.println("");
		for (Entry<String, Integer> elem : listaMenu.entrySet()) {
			platos.add(elem.getKey());
			if (elem.getValue() != 0) {

				int cantidad = elem.getValue();
				while (cantidad != 0) {

					platos.add(elem.getKey());
					cantidad--;

				}

			}

		}
		
		System.out.println( Arrays.toString(GetStringArray(items))+"+---------12345");
		System.out.println(Arrays.toString(GetStringArray(platos))+"+123456");

		ComandaDAO.insertComanda(Integer.parseInt(numMesa),GetStringArray(platos), GetStringArray(items));
		


		this.comandaBean = new ComandaBean();
		if(!numMesa.equals("null")) {
			comandaBean.setNumMesa(Integer.parseInt(numMesa));
			}
		model.addAttribute("comandaBean", this.comandaBean);

		return "redirect:mesas";
	}
	
	@PostMapping("/enviarObservaciones")
	public String enviarObservaciones(@Valid @RequestParam("observaciones") String observaciones, Model model) {
		
		System.out.println(observaciones);
		comandaBean.setObservaciones(observaciones);
		model.addAttribute("comandaBean", this.comandaBean);
		
		return "redirect:camareros";
	}
	
	private static String[] GetStringArray(List<String> platos) 
    { 
  
        // Convert ArrayList to object array 
        Object[] objArr = platos.toArray(); 
  
        // convert Object array to String array 
        String[] str = Arrays 
                           .copyOf(objArr, objArr 
                                               .length, 
                                   String[].class); 
  
        return str; 
    } 

}
