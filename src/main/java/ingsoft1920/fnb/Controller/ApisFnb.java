package ingsoft1920.fnb.Controller; 
 
import ingsoft1920.fnb.Model.*;

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
import ingsoft1920.fnb.DAO.ItemDAO;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoM; 
 
@Controller 
public class ApisFnb { 
 
	/* 
	 * Entrada:{ 'rest_nom':String } 
 
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
		/* 
		 * Entrada:{ 'rest_nom':String } 
 
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
		 
		resJson.add("nombre_menu", listaNombreMenu); 
		resJson.add("plato_id", listaIDPlatos); 
		resJson.add("num_plato", listaNumPlato); 
		resJson.add("tipo_plato", listaTipoPlato); 
		resJson.add("nombre_plato", listaNombrePlato); 
		resJson.add("precio_plato", listaPrecioPlato); 
		 
		return resJson.toString(); 
	}
		
	
	@ResponseBody 
	@GetMapping("/itemsRest") 
	public static String itemsRest(@RequestBody String req){
		JsonObject obj = (JsonObject) JsonParser.parseString(req); 
		String items_rest = obj.get("rest_nom").getAsString(); 
		
		
		/*
		 * {

 'nombre_menu': String[],
 'item_id': int[],
 
 'tipo_item': String[],
 'nombre_item': String[],
 'precio_item': float[]
   }
		 */
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
		
 
	
	
	
	
	
	
 
} 
