package ingsoft1920.ejemplo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ejemplo.Beans.SesionBean;
import ingsoft1920.ejemplo.Beans.SignupBean;
import ingsoft1920.ejemplo.DAO.UsuarioDAO;
import ingsoft1920.ejemplo.Model.UsuarioModel;

//Especificamos que la clase tiene métodos controladores
@Controller
public class SignupController {
	//Este campo estatico tiene que estar en TODAS las clases, adaptado al nombre de clase ue corresponda
	//final static Logger logger = LogManager.getLogger(NombreDeLaClase.class.getName());
	final static Logger logger = LogManager.getLogger(SignupController.class.getName());
	
	
	//Si tenemos un Bean con un scope de Session, automaticamente aparecera en este campo
	//sin necesidad de tener que hacer un set, y estara disponible siempre que no se salga de
	//la sesion (se cierre el navegador) y en cualquier metodo de esta clase
	@Autowired
	SesionBean sesionBean;
	
	
	//Esta etiqueta nos permite especificar que este metodo va a rsolver las peticiones
	//que lleguen a la ruta /signup de tipo GET
	//El parametro de entrada Model es el que tiene la informacion de la peticion y de
	//la respuesta. Es donde pondremos los Beans que queremos enlazar con la web, de donde
	//sacaremos los beans que nos llegan de la peticion...
	@GetMapping("/signup")
	public String signupGet(Model model) {
		//Creamos un bean nuevo para el signup, y lo anadimos al model
		SignupBean signupBean = new SignupBean();
		model.addAttribute("signupBean",signupBean);
		model.addAttribute("mensajeError","");
		
		//Aqui retornamos el nombre de la vista que vamos a utilizar (el nombre del archivo jsp)
		//sin la extension. Las vistas estan en src/main/webapp/WEB-INF/jsp/
		return "signup";
	}
	
	//Para recibir un bean de un formulario utilizamos las etiquetas @Valid @ModelAttribute("nombreDelBean")
	//y declaramos el argumento como hariamos con cualquier otra funcion en Java. Tambien capturamos el Model.
	//El objeto Model SIEMPRE se captura cuando estamos interactuando con la web.
	@PostMapping("/signup")
	public String signupPost(@Valid @ModelAttribute("signupBean") SignupBean signupBean,
			Model model) {
		//El checkeo de que todos los campos estan rellenos, y que cumplen el formato correcto (sin caracteres raros,
		//contraseña con longitud minima...) se comprueban en el bean (principio de ocultacion de información).
		//Una vez está correcto, transformamos el bean en un SignupModel, con el que interactuaremos durante el resto de
		//la peticion
		if(signupBean.checkCamposValidos()) {
			//Podemos utilizar los metodos debug, info, warn y error para loggear mensajes
			//Hay que evitar el uso de System.out.println(), ya que NO SE GUARDA UNA VEZ SE ACABA
			//LA EJECUCION
			logger.info("Peticion de Signup recibida correctamente y con campos validos");
			
			//La clase UsuarioModel representa el modelo de datos que vamos a manejar en la aplicacion
			UsuarioModel usuarioModel = new UsuarioModel(signupBean);
			
			//La clase UsuarioDAO es el "punto de conexion" entre nuestro modelo de datos (UsuarioModel) y la base de datos
			//con sus tablas correspondientes. Sera la encargada de "traducir" peticiones en forma de metodos Java en
			//SELECT, INSERT, UPDATE, DELETE... de la base de datos. Por lo tanto, en las clases DAO reside TODA la logica 
			//de base de datos, y no puede haber ninguna consulta SQL fuera de dichas clases
			UsuarioModel respuesta = UsuarioDAO.signup(usuarioModel);
			if(respuesta!=null) {
				//Puedo publicar un objeto, y dentro del jsp acceder a sus propiedades
				SesionBean sesionBean = new SesionBean(respuesta);
				model.addAttribute(sesionBean);
				
				//Tambien puedo publicar listas, e iterar por ellas en el jsp
				List<String> listaStrings = new ArrayList<String>();
				listaStrings.add("string1");
				listaStrings.add("string2");
				listaStrings.add("string3");
				model.addAttribute("listaStrings",listaStrings);
				
				//Devolvemos el nombre de la vista que corresponde (welcome.jsp)
				return "welcome";
			}else {
				model.addAttribute("signupBean",signupBean);
				
				//Esta linea publica el String "Usuario ya existe!" con el nombre mensajeError
				//en el model respuesta
				model.addAttribute("mensajeError","Usuario ya existe!");
				return "signup";
			}
			
		}
		
		
		
		return "welcome";
	}
}
