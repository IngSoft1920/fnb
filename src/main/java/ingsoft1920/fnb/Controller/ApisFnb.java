package ingsoft1920.fnb.Controller; 

import ingsoft1920.fnb.Model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.DAO.MesaDAO;
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
	@PostMapping("/platosRest") 
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
	@PostMapping("/itemsRest") 
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
		'capacidad': int,
		'fecha': String
	}
	Salida: 
	{ 
		'horas_disp': String[];
	} 
	Donde fecha sigue el formato LocalDate [ yyyy-mm-dd ]
	Donde horas_disp sigue el formato LocalTime [ hh:mm ]
	 */ 
	@ResponseBody 
	@PostMapping("/checkReservRest") 
	public static String checkReservRest(@RequestBody String req){

		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		String rest_nom = obj.get("rest_nom").getAsString(); 
		int capacidad = obj.get("capacidad").getAsInt();
		LocalDate fecha = LocalDate.parse(obj.get("fecha").getAsString());
				
		JsonArray listaFechaReserva = new JsonArray(); 

		//lista de items dentro del Map
		List<Mesa_ubicacionM> listaFechas = Mesa_ubicacionDAO.horasNoDispRest(rest_nom, capacidad,fecha);
		
		RestauranteM rest = RestauranteDAO.horarioRest(rest_nom);
		LocalDateTime fecha_limite = LocalDateTime.of(fecha,rest.getHora_clausura());
		for(LocalDateTime fechas_dia = LocalDateTime.of(fecha,rest.getHora_apertura()); 
				fechas_dia.isBefore(fecha_limite);fechas_dia=fechas_dia.plusMinutes(30)) {
			boolean encontrado =false;
			int i =0;
			while(!encontrado & i<listaFechas.size()) {
				encontrado = listaFechas.get(i).getFecha_reserva().equals(fechas_dia);
				i++;
			}
			if(!encontrado)
				listaFechaReserva.add(fechas_dia.toLocalTime().toString());
			else
				listaFechas.remove(i-1);
		} 

		JsonObject resJson = new JsonObject();
		resJson.add("horas_disp", listaFechaReserva);  

		return resJson.toString();
	}

	/*
	Entrada:
	{
		'servicio_id': int,
		'fecha_hora': String,
		'num_clientes': int,
		'tipoUbicacion': int,
		'ubicacion': String,
		'habitaciones_id': int[]
		'platos':String[],
		'items':String[]
	}
	Donde:
		- fecha_hora sigue el formato LocalDateTime [ yyyy-mm-ddThh:mm:ss ] 
	 	- tipoUbicacion: 1 para hacer una reserva en un restaurante
	 					 2 para hacer un pedido a una habitacion
	 	- ubicacion: si tipoUbicacion=1 -> nombre del restaurante
	 	 			 si tipoUbicacion=2 -> numero de habitacion
	 	- platos e items: si tipoUbicacion=1 -> lista vacia en ambos
	 	 				  si tipoUbicacion=2 -> lista con los nombres de los platos e items solicitados 
	 	 				  						(si no se ha solicitado de un tipo puede ir vacia su lista)
	 */ 
	@ResponseBody 
	@PostMapping("/nuevoServicio") 
	public static void  nuevoServicio(@RequestBody String req){

		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		int servicio_id = obj.get("servicio_id").getAsInt(); 
		LocalDateTime fecha_hora = LocalDateTime.parse(obj.get("fecha_hora").getAsString());
		int num_clientes = obj.get("num_clientes").getAsInt();
		JsonArray listaHabitaciones = obj.get("habitaciones_id").getAsJsonArray();
		int tipoUbicacion = obj.get("tipoUbicacion").getAsInt();
		switch(tipoUbicacion) {
		case 1: //CASO: Reserva Mesa
			int habitaciones[] = new int[listaHabitaciones.size()];
			for(int i =0; i<habitaciones.length; i++) {
				habitaciones[i]=listaHabitaciones.get(i).getAsInt();
			}
			String rest_nomb= obj.get("ubicacion").getAsString();
			MesaDAO.alojarMesa(MesaDAO.mesaDisp(rest_nomb, fecha_hora,num_clientes).getMesa_id(), fecha_hora,habitaciones);
			break;
		case 2: //CASO: Pedido Habitacion
			int habitacion_id = Integer.parseInt(obj.get("ubicacion").getAsString());

			JsonArray listaPlatos = obj.get("platos").getAsJsonArray();
			String platos[] = new String[listaPlatos.size()];
			for(int i =0; i<platos.length; i++) {
				platos[i]=listaPlatos.get(i).getAsString();
			}

			JsonArray listaItems = obj.get("items").getAsJsonArray();
			String items[] = new String[listaItems.size()];
			for(int i =0; i<items.length; i++) {
				items[i]=listaItems.get(i).getAsString();
			}

			ComandaDAO.insertComandaHab(habitacion_id, fecha_hora, platos, items);
			break;

		}
	}
} 
