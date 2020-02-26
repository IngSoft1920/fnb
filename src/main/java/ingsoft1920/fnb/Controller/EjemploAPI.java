package ingsoft1920.fnb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.fnb.Beans.DatoUsuarioBean;


//Mas info sobre JSON y Spring aqui:
//https://www.baeldung.com/spring-request-response-body
@Controller
public class EjemploAPI {
	//OPCION MAS SIMPLE: TENEMOS QUE HACER MAS TRABAJO PERO TENEMOS MAS CONTROL SOBRE
	//LO QUE OCURRE

	//Con la etiqueta responseBody estamos especificando que el string que devolvamos
	//sera el cuerpo de la respuesta HTTP que daremos a la peticion
	@ResponseBody
	@GetMapping("/datoUsuario1")
	public String getDatosUsuario1() {
		//Instanciamos un nuevo objeto Json
		JsonObject obj = new JsonObject();

		//Si estamos añadiedo propiedades (String, Number, Boolean, Character), utilizamos
		//addProperty("nombrePropiedad",valor)
		obj.addProperty("nombre", "Jorge");
		obj.addProperty("apellido", "Vazquez");
		obj.addProperty("email", "jorge.vazquez.acevedo@alumnos.upm.es");

		//Declaramos una nueva lista (array) en Json y añadimos elementos
		JsonArray listaNotas = new JsonArray();
		listaNotas.add(6);
		listaNotas.add(9);
		listaNotas.add(10);

		//Si estamos añadiendo un objeto Json (como es un array) a otro, tenemos que utilizar
		//el metodo add("nombrePropiedad",valor)
		obj.add("notas", listaNotas);

		//Obtenemos la representacion en String del objeto JSON y la enviamos como respuesta
		return obj.getAsString();

		//Devolvera lo siguiente en el cuerpo de la respuesta
		/*
		 * {
		 * 	"nombre":"jorge",
		 * 	"apellido":"vazquez",
		 * 	"mail":"jorge.vazquez.acevedo@alumnos.upm.es",
		 * 	"notas":[6,9,10]
		 * }
		 */
	}

	@ResponseBody
	@PostMapping("/procesaDatos1")
	public String procesaDatos1(@RequestBody String req) {
		//Suponiendo que me llega algo como
		/*
		 * {
		 * 	"nombre":"jorge",
		 * 	"apellido":"vazquez",
		 * 	"mail":"jorge.vazquez...",
		 * 	"notas":[6,9,10]
		 * }
		 */
		//Este texto estaria en la variable req

		//Parseamos el texto a un JsonObject
		JsonObject obj = (JsonObject) JsonParser.parseString(req);

		//Vamos accediendo a sus propiedades, y las guardamos en un objeto de nuestro modelo
		//de datos
		String nombre=obj.get("nombre").getAsString();
		String apellido=obj.get("apellido").getAsString();
		String email=obj.get("mail").getAsString();
		JsonArray notas=obj.get("notas").getAsJsonArray();
		int[] notasInt= new int[notas.size()];
		for(int i=0;i<notas.size();i++) {
			notasInt[i]=notas.get(i).getAsInt();
		}
		DatoUsuarioBean datoUsuario = new DatoUsuarioBean(nombre,apellido,email,notasInt);
		datoUsuario.doWhatEver();

		return "Procesado correctamente";
	}




	//fnbS MAS AVANZADOS, EN LOS QUE SPRING HACE GRAN PARTE DEL TRABAJO, PERO PUEDE LLEVAR
	//A ERRORES RAROS QUE NO SON FACILES DE ENTENDER

	//fnb devolviendo directamente un objeto de una clase. Spring intentara transformarlo
	//en JSON
	@ResponseBody
	@GetMapping("/datoUsuario2")
	public DatoUsuarioBean getDatosUsuario2() {
		int[] notas = {6,9,10};
		DatoUsuarioBean datosUsuario = new DatoUsuarioBean("jorge","vazquez","email",notas);
		return datosUsuario;
	}


	@ResponseBody
	@PostMapping("/procesaDatos")
	//Spring automaticamente parsea el Json que viene a esa clase. Los nombres de los campos de la 
	//clase y los de las propiedades que vienen en Json tienen que ser iguales
	public String procesaDatos(@RequestBody DatoUsuarioBean datoUsuarioBean) {
		datoUsuarioBean.doWhatEver();

		return "Procesado correctamente";
	} 

}
