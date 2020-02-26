package ingsoft1920.fnb.Controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.fnb.Beans.EjemploContadorBean;

@Controller
public class EjemploContadorController {
	//Con la etiqueta Autowired conseguimos que automaticamente se cargue el Bean que hubiera en sesion.
	//Si no lo hubiera (primera visita), se crearia uno con el constructor vacio (el que no tiene parametros ni
	//instrucciones) y se asignaria a esta variable.
	@Autowired
	EjemploContadorBean contadorSesion;
	
	//Si refrescamos la pagina ira incrementando en 1 el contador
	@GetMapping("/contador")
	public String setContadorFormulario(Model model) {
		contadorSesion.addOne();
		
		//Publicamos el bean en el modelo
		model.addAttribute("ejemploContadorBean", contadorSesion);
		
		//Llamamos a la vista correspondiente
		return "ejemploContador";
	}
	
	//Tambien podemos recibir con este metodo el valor del formulario y asi setear el valor manualmente
	@PostMapping("/setContador")
	public String setContadorFromForm(@Valid @ModelAttribute("ejemploContadorBean") EjemploContadorBean contadorForm,
			Model model) {
		this.contadorSesion=contadorForm;
		
		model.addAttribute("ejemploContadorBean", contadorSesion);
		
		return "ejemploContador";
	}

}
