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
import ingsoft1920.fnb.Beans.confirmacionBean;
import ingsoft1920.fnb.DAO.MesaDAO;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Beans.portalMetreBean;
@Controller

public class IndiceMetreController {
	
	@Autowired
	ListaReservasBean listaReservasBean;
	confirmacionBean confirmacionBean;
	portalMetreBean portalMetreBean;
	
	@RequestMapping("/indice")

	public String show1(Model model) {

		return "WebMetre";
	}
	@RequestMapping("/metre")
	public String show2(Model model) {
		
		return "webMetreConfirmacion";
	}
	@RequestMapping("/mesasdisponibles")
	public String show10(Model model) {
		
		return "dibujomesasprueba";
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
		
		
		confirmacionBean= new confirmacionBean();
		confirmacionBean.setHab(listaReservasBean.getMapAsign().get(Integer.parseInt(idMesa)));
		confirmacionBean.setNumPersonas(listaReservasBean.getListaMesas().get(listaReservasBean.findCap(Integer.parseInt(idMesa))).getCapacidad());
		confirmacionBean.setMesa(Integer.parseInt(idMesa));
		model.addAttribute("confirmacionBean",confirmacionBean);
		
		
		
		
		
		return "webMetreConfirmacion";
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
	
	@GetMapping("/denegar")
	public String denegar(Model model){
		
		model.addAttribute("listaReservasBean",listaReservasBean);
		
		
		return "redirect:metremesas";
	}
	
	
	@GetMapping("/confirmar")
	public String confirmar(@Valid @RequestParam("idMesa") String idMesa,@Valid @RequestParam("habitacion") String habitacion,Model model){
		
		int habitaciones[]= new int[1];
		habitaciones[0]=Integer.parseInt(""+habitacion.charAt(11));
		System.out.println("habitacion_---------"+habitaciones[0]);
		MesaDAO.alojarMesa(Integer.parseInt(idMesa), LocalDateTime.now(),habitaciones);
		model.addAttribute("portalMetreBean", portalMetreBean);
		
		return "redirect:indice";
	}
	
	
	


}
