package ingsoft1920.fnb.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;
import ingsoft1920.fnb.Model.ComandaM;
import ingsoft1920.fnb.DAO.ComandaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.fnb.Beans.Tarea;
import ingsoft1920.fnb.Beans.TareasBean;
import ingsoft1920.fnb.Beans.platos;
import ingsoft1920.fnb.DAO.ComandaDAO;

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
		
		List<ComandaM> l = ComandaDAO.comandasTareaCocina(0);
		
		Map<Integer,Tarea> lis=tareasBean.getListaTareas();
		lis.remove(Integer.parseInt(check));
		tareasBean.setListaTareas(lis);

		model.addAttribute("tareasBean", tareasBean);
		System.out.println("--------------------");

		return "webCocinero";

	}

}
