package ingsoft1920.fnb.Controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.ejemplo.Beans.Tarea;
import ingsoft1920.ejemplo.Beans.TareasBean;
import ingsoft1920.ejemplo.Beans.platos;

@Controller
public class CocinaController {
	@Autowired
	TareasBean tareasBean;

	@GetMapping("/cocina")
	public String showPaginaComandaGet(Model model) {

		model.addAttribute("tareasBean", tareasBean);
		return "webCocinero";
	}

	@PostMapping("/quitarTarea")
	public String quitarLista(@Valid @RequestParam("pedidoAtendido") String check, Model model) {

		Map<Integer,Tarea> lis=tareasBean.getListaTareas();
		lis.remove(Integer.parseInt(check));
		tareasBean.setListaTareas(lis);

		model.addAttribute("tareasBean", tareasBean);
		System.out.println("--------------------");

		return "webCocinero";

	}

}
