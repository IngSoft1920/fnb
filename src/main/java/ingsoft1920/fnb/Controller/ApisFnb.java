package ingsoft1920.fnb.Controller; 

import ingsoft1920.fnb.Model.*;

import java.time.LocalTime;
import java.util.*;  
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody; 

import com.google.gson.JsonArray; 
import com.google.gson.JsonObject; 
import com.google.gson.JsonParser; 

import ingsoft1920.fnb.DAO.PlatoDAO;
import ingsoft1920.fnb.DAO.RestauranteDAO;
import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.DAO.Mesa_ubicacionDAO;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoM; 

@Controller 
public class ApisFnb { 

	/*
	Entrada:{ 'rest_nom':String } 

	Salida: 
	{ 
		'nombre_menu': String[], 
		'plato_id': int[], 
		'num_plato': int[], 
		'tipo_plato': String[], 
		'nombre_plato': String[], 
		'precio_plato': float[] 
	} 
	 */ 
	@ResponseBody 
	@GetMapping("/platosRest") 
	public static String platosRestAPI(@RequestBody String req){ 

		// 
		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		String rest_nom = obj.get("rest_nom").getAsString(); 

		//Json array para cada salida que sea un array 

		JsonArray listaNombreMenu = new JsonArray(); 
		JsonArray listaIDPlatos = new JsonArray(); 
		JsonArray listaNumPlato = new JsonArray(); 
		JsonArray listaTipoPlato = new JsonArray(); 
		JsonArray listaNombrePlato = new JsonArray(); 
		JsonArray listaPrecioPlato = new JsonArray(); 

		//lista de platos dentro del Map 
		Set<Map.Entry<String, PlatoM>> platosSet = PlatoDAO.platosRest(rest_nom).entrySet(); 
		for (Map.Entry<String, PlatoM> elemSet: platosSet) { 
			PlatoM plato = elemSet.getValue(); 

			listaNombreMenu.add(plato.getMenu().getTitulo()); 
			listaIDPlatos.add(plato.getPlato_id()); 
			listaNumPlato.add(plato.getNum_plato()); 
			listaTipoPlato.add(plato.getTipo()); 
			listaNombrePlato.add(plato.getNombre()); 
			listaPrecioPlato.add(plato.getPlato_menu().getPrecio()); 
		} 

		JsonObject resJson = new JsonObject(); 

		resJson.add("nombre_menu", listaNombreMenu); 
		resJson.add("plato_id", listaIDPlatos); 
		resJson.add("num_plato", listaNumPlato); 
		resJson.add("tipo_plato", listaTipoPlato); 
		resJson.add("nombre_plato", listaNombrePlato); 
		resJson.add("precio_plato", listaPrecioPlato); 

		return resJson.toString(); 
	}

	/*
	Entrada:{ 'rest_nom':String } 

	Salida:
	{

		'nombre_menu': String[],
		'item_id': int[],
		'tipo_item': String[],
		'nombre_item': String[],
		'precio_item': float[]
	}
	 */
	@ResponseBody 
	@GetMapping("/itemsRest") 
	public static String itemsRest(@RequestBody String req){

		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		String items_rest = obj.get("rest_nom").getAsString(); 

		JsonArray listaNombreMenu = new JsonArray(); 
		JsonArray listaIDItems = new JsonArray(); 
		JsonArray listaTipoItem = new JsonArray(); 
		JsonArray listaNombreItem = new JsonArray(); 
		JsonArray listaPrecioItem = new JsonArray();

		//lista de items dentro del Map
		Set<Map.Entry<String, ItemM>> itemsSet = ItemDAO.itemsRest(items_rest).entrySet();
		for (Map.Entry<String, ItemM> elemSet: itemsSet) { 
			ItemM item = elemSet.getValue();

			listaNombreMenu.add(item.getMenu().getTitulo());
			listaIDItems.add(item.getItem_id());
			listaTipoItem.add(item.getTipo());
			listaNombreItem.add(item.getNombre());
			listaPrecioItem.add(item.getItem_menu().getPrecio());
		}

		JsonObject resJson = new JsonObject();

		resJson.add("nombre_menu", listaNombreMenu); 
		resJson.add("item_id", listaIDItems);  
		resJson.add("tipo_item", listaTipoItem); 
		resJson.add("nombre_item", listaNombreItem); 
		resJson.add("precio_item", listaPrecioItem); 


		return resJson.toString();
	}

	/*
	Salida: 
	{ 
		'restaurante_id': int[],
		'nombre': String[],
		'hora_apertura': String[];
		'hora_clausura': String[];
	} 
	Donde hora_apertura y hora_clasura siguen el formato LocalTime [ hh:mm ]
	 */ 
	@ResponseBody 
	@GetMapping("/infoRest") 
	public static String platosRestAPI(){ 

		JsonArray listaRestauranteId = new JsonArray(); 
		JsonArray listaNombre = new JsonArray(); 
		JsonArray listaHoraApertura = new JsonArray(); 
		JsonArray listaHoraClausura = new JsonArray(); 

		List<RestauranteM> listaRest = RestauranteDAO.infoRest(); 
		for (RestauranteM rest: listaRest) { 
			listaRestauranteId.add(rest.getRestaurante_id()); 
			listaNombre.add(rest.getNombre()); 
			listaHoraApertura.add(rest.getHora_apertura().toString()); 
			listaHoraClausura.add(rest.getHora_clausura().toString()); 
		} 

		JsonObject resJson = new JsonObject(); 

		resJson.add("restaurante_id", listaRestauranteId); 
		resJson.add("nombre", listaNombre); 
		resJson.add("hora_apertura", listaHoraApertura); 
		resJson.add("hora_clausura", listaHoraClausura); 


		return resJson.toString(); 
	}

	/*
	Entrada:
	{
		'rest_nom': String,
		'capacidad': int
	}
	Salida: 
	{ 
		'fecha_reserva': String[];
	} 
	Donde fecha_reserva sigue el formato LocalDateTime [ yyyy-mm-ddThh:mm:ss ]
	 */ 
	@ResponseBody 
	@GetMapping("/checkReservRest") 
	public static String checkReservRest(@RequestBody String req){

		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		String rest_nom = obj.get("rest_nom").getAsString(); 
		int capacidad = obj.get("capacidad").getAsInt();
		
		JsonArray listaFechaReserva = new JsonArray(); 

		//lista de items dentro del Map
		List<Mesa_ubicacionM> listaFechas = Mesa_ubicacionDAO.horasNoDispRest(rest_nom, capacidad);
		for (Mesa_ubicacionM fecha: listaFechas) {
			listaFechaReserva.add(fecha.getFecha_reserva().toString());
		}

		JsonObject resJson = new JsonObject();
		resJson.add("fecha_reserva", listaFechaReserva);  
		
		return resJson.toString();
	}



} 
