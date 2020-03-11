package ingsoft1920.fnb.Controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ingsoft1920.fnb.Beans.ComandaBean;
import ingsoft1920.fnb.Beans.LoginBean;
import ingsoft1920.fnb.Beans.TareasBean;

@Controller
public class LoginController {
	
	@Autowired
	LoginBean loginBean;
	TareasBean tareasBean;
	ComandaBean comandaBean;
	
	@GetMapping("/")
	public String showPaginaLoginGet(Model model) {
		
		model.addAttribute("loginBean",loginBean);
		return "login";
	}
	
	
	@GetMapping("/entrar")
	public String Redirigir(@Valid @RequestParam("username") String username,@Valid @RequestParam("pass") String pass,Model model) {
		
		
		System.out.println(username);
		System.out.println(pass);
		switch (username) {
		case "coc1":
			
			if(!pass.equals("1234")) {
				loginBean.setHabilitated(true);
				
				model.addAttribute("loginBean",loginBean);
				
				return "login";
			}
			
			model.addAttribute("tareasBean",tareasBean);
			return "redirect:cocina";
		case"cam1":
			
			if(!pass.equals("1234")) {
				loginBean.setHabilitated(true);
				
				model.addAttribute("loginBean",loginBean);
				return "login";
			}
			
			model.addAttribute("comandaBean",comandaBean);
			return "redirect:mesas";
			
		case "me1":
			
			if(!pass.equals("1234")) {
				loginBean.setHabilitated(true);
				
				model.addAttribute("loginBean",loginBean);
				return "login";
			}
			
			model.addAttribute("metreBean",null);
			////parte de luis
			return "redirect:metre";
		default:
			
			loginBean.setHabilitated(true);
			
			model.addAttribute("loginBean",loginBean);
			return "login";
			
			
		}
	}

}
