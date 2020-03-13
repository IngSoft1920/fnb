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
	@RequestMapping("/metremesas")
	public String show3(Model model) {
		
		return "webMetreMesasDisp";
	}
	@RequestMapping("/metreReservas")
	public String show4(Model model) {

		return "webMetreReserva";

	}

	


}
