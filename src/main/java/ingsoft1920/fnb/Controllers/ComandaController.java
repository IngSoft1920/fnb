package ingsoft1920.fnb.Controllers;

import java.util.Iterator;

import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.fnb.Beans.ComandaBean;
import ingsoft1920.fnb.Beans.bebidas;
import ingsoft1920.fnb.Beans.platos;

@Controller
public class ComandaController {
	@Autowired
	ComandaBean comandaBean;
	
	@GetMapping("/camareros")
	public String showPaginaComandaGet(Model model) {
		
		model.addAttribute("comandaBean", comandaBean);
		return "camareros";
	}
	
	@PostMapping("/anadirItem")
	public String anadirElementoComanda(
			@Valid @RequestParam("platoNuevo") String nuevoPlato
			,Model model) {
		
		/*if(comandaBean.getCantidades().containsKey(nuevoPlato)) {
			int cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
			
			//comandaBean.getCantidades().put(nuevoPlato,cant+1);
		}
		*/
		
		platos entrada;
		Iterator<platos> it =comandaBean.getCantidades().values().iterator();
		boolean found=false;
		
		while(it.hasNext() && !found){
			entrada=it.next();
			if(entrada.getId()==Integer.parseInt(nuevoPlato)) {
				found=true;
				entrada.setUnidades(entrada.getUnidades()+1);
				Set<String> keyList =comandaBean.getCantidades().keySet();
				boolean foundKey=false;
				String key=null;
				for (String string : keyList) {
					
					if(comandaBean.getCantidades().get(string).equals(entrada) && !foundKey) {
						
						foundKey=true;
						key=string;
					}
					
				}
				
			
				if(key!=null) {
					
					comandaBean.getCantidades().put(key, entrada);
				}
				
			}
		}
		
		
		
		
		
		
		
		model.addAttribute("comandaBean", comandaBean);
		
		
		return "camareros";
	}
	
	@PostMapping("/quitarItem")
	public String eliminarElementoComanda(
			@Valid @RequestParam("platoNuevo") String nuevoPlato
			,Model model) {
		
		/*if(comandaBean.getCantidades().containsKey(nuevoPlato)) {
			int cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
			
			//comandaBean.getCantidades().put(nuevoPlato,cant+1);
		}
		*/
		
		platos entrada;
		Iterator<platos> it =comandaBean.getCantidades().values().iterator();
		boolean found=false;
		
		while(it.hasNext() && !found){
			entrada=it.next();
			if(entrada.getId()==Integer.parseInt(nuevoPlato)) {
				found=true;
				entrada.setUnidades(entrada.getUnidades()-1);
				Set<String> keyList =comandaBean.getCantidades().keySet();
				boolean foundKey=false;
				String key=null;
				for (String string : keyList) {
					
					if(comandaBean.getCantidades().get(string).equals(entrada) && !foundKey) {
						
						foundKey=true;
						key=string;
					}
					
				}
				
			
				if(key!=null) {
					
					comandaBean.getCantidades().put(key, entrada);
				}
				
			}
		}
		
		
		
		
		
		
		
		model.addAttribute("comandaBean", comandaBean);
		
		
		return "camareros";
	}
	
	
	@PostMapping("/quitarBebida")
	public String eliminarBebidaComanda(
			@Valid @RequestParam("bebidaNueva") String nuevoPlato
			,Model model) {
		
		/*if(comandaBean.getCantidades().containsKey(nuevoPlato)) {
			int cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
			
			//comandaBean.getCantidades().put(nuevoPlato,cant+1);
		}
		*/
		
		bebidas entrada;
		Iterator<bebidas> it =comandaBean.getBebidas().values().iterator();
		boolean found=false;
		
		while(it.hasNext() && !found){
			entrada=it.next();
			if(entrada.getId()==Integer.parseInt(nuevoPlato)) {
				found=true;
				entrada.setUnidades(entrada.getUnidades()-1);
				Set<String> keyList =comandaBean.getBebidas().keySet();
				boolean foundKey=false;
				String key=null;
				for (String string : keyList) {
					
					if(comandaBean.getBebidas().get(string).equals(entrada) && !foundKey) {
						
						foundKey=true;
						key=string;
					}
					
				}
				
			
				if(key!=null) {
					
					comandaBean.getBebidas().put(key, entrada);
				}
				
			}
		}
		
		
		
		
		
		
		
		model.addAttribute("comandaBean", comandaBean);
		
		
		return "camareros";
	}
	
	@PostMapping("/anadirBebida")
	public String anadirBebidaComanda(
			@Valid @RequestParam("bebidaNueva") String nuevoPlato
			,Model model) {
		
		/*if(comandaBean.getCantidades().containsKey(nuevoPlato)) {
			int cant=comandaBean.getCantidades().get(nuevoPlato).getUnidades();
			
			//comandaBean.getCantidades().put(nuevoPlato,cant+1);
		}
		*/
		
		bebidas entrada;
		Iterator<bebidas> it =comandaBean.getBebidas().values().iterator();
		boolean found=false;
		
		while(it.hasNext() && !found){
			entrada=it.next();
			if(entrada.getId()==Integer.parseInt(nuevoPlato)) {
				found=true;
				entrada.setUnidades(entrada.getUnidades()+1);
				Set<String> keyList =comandaBean.getBebidas().keySet();
				boolean foundKey=false;
				String key=null;
				for (String string : keyList) {
					
					if(comandaBean.getBebidas().get(string).equals(entrada) && !foundKey) {
						
						foundKey=true;
						key=string;
					}
					
				}
				
			
				if(key!=null) {
					
					comandaBean.getBebidas().put(key, entrada);
				}
				
			}
		}
		
		
		
		
		
		
		
		model.addAttribute("comandaBean", comandaBean);
		
		
		return "camareros";
	}
	
	@PostMapping("/enviarComanda")
	public String enviarComandaPost(Model model) {
		ComandaBean comandaBean = this.comandaBean;
		
		
		//JSON AND INTERNAL STUFF HERE
		
		for(String item : comandaBean.getCantidades().keySet()) {
			System.out.println(item+" -> "+comandaBean.getCantidades().get(item));
		}
		
		this.comandaBean = new ComandaBean();
		model.addAttribute("comandaBean",this.comandaBean);
		return "camareros";
	}
	
}
