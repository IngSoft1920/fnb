package ingsoft1920.fnb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndiceMetreController {
	@RequestMapping("/indice")

	public String show1(Model model) {

		return "WebMetre";
	}
	@RequestMapping("/metre")
	public String show2(Model model) {

		return "webMetreConfirmacion";
	}
	@RequestMapping("/metrerservas")
	public String show3(Model model) {
		
		return "webMetreMesasDisp";
	}
	@RequestMapping("/metremesas")
	public String show4(Model model) {

		return "webMetreReserva";
=======
	public String showPaginaComandaGet(Model model) {

		model.addAttribute("comandaBean", comandaBean);

		System.out.println(comandaBean.getCantidades());
		return "camareros";
	}
	@RequestMapping("/metre")
	public String showPaginaComandaGet(Model model) {

		model.addAttribute("comandaBean", comandaBean);

		System.out.println(comandaBean.getCantidades());
		return "camareros";
	}
	@RequestMapping("/metrerservas")
	public String showPaginaComandaGet(Model model) {

		model.addAttribute("comandaBean", comandaBean);

		System.out.println(comandaBean.getCantidades());
		return "camareros";
	}
	@RequestMapping("/metremesas")
	public String showPaginaComandaGet(Model model) {

		model.addAttribute("comandaBean", comandaBean);

		System.out.println(comandaBean.getCantidades());
		return "camareros";
>>>>>>> PaginasWeb
	}




}
