package ingsoft1920.fnb.Controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.fnb.Beans.ListaReservasBean;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Model.MesaM;

@Controller

public class IndiceMetreController {
	
	@Autowired
	ListaReservasBean listaReservasBean;
	
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
		
		
		listaReservasBean = new ListaReservasBean();
		List<MesaM> lis =listaReservasBean.getListaMesas();
		//System.out.println(lis.toString());
		System.out.println(listaReservasBean.getMapAsign().toString());
		System.out.println(listaReservasBean.getMapAsign().get("1"));
		model.addAttribute("listaReservasBean", listaReservasBean);
		
		return "webMetreMesasDisp";
	}
	
	@RequestMapping("/metreReservas")
	public String show4(Model model) {

		return "webMetreReserva";

	}

	@PostMapping("/alojarMesa")
	public String alojarMesa(@Valid @RequestParam("idMesa") String idMesa,Model model) {
		
		MesaDAO.alojarMesa(Integer.parseInt(idMesa), LocalDateTime.now());
		
		this.listaReservasBean=new ListaReservasBean();
		model.addAttribute("listaReservasBean",listaReservasBean);
		
		return "webMetreMesasDisp";
	}
	
	@GetMapping("/asignarHab")
	public String asignarHab(@Valid @RequestParam("idMesa") String idMesa,@Valid @RequestParam("hab1") String hab1,Model model) {
		
		this.listaReservasBean.getMapAsign().put(Integer.parseInt(idMesa), hab1);
		model.addAttribute("listaReservasBean",listaReservasBean);
		
		return "webMetreMesasDisp";
	}
	
	@GetMapping("/asignarRev")
	public String asignarReserva(@Valid @RequestParam("idMesa") String idMesa,@Valid @RequestParam("rev") String rev,Model model) {
		
		this.listaReservasBean.getMapAsignRes().put(Integer.parseInt(idMesa), rev);
		model.addAttribute("listaReservasBean",listaReservasBean);
		
		return "webMetreMesasDisp";
	}


}
