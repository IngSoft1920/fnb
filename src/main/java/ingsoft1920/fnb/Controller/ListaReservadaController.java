package ingsoft1920.fnb.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.fnb.Beans.EjemploContadorBean;
import ingsoft1920.fnb.Beans.ListaReservasBean;

@Controller

public class ListaReservadaController {
	ListaReservasBean listareservabean;
	@PostMapping("/Reservas")
	public String setContadorFromForm(@Valid @ModelAttribute("ejemploContadorBean") EjemploContadorBean contadorForm,
			Model model) {
		
		model.addAttribute("ListaReservasBean", listareservabean);
		
		return "ejemploContador";
	}
	
}
