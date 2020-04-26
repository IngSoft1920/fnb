package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.fnb.Beans.TareaEmpleadoBean;


@Controller
public class ApisDHO {
	/*
	 * Flujo de ejecucion:
	 * 1. Instancio esta clase
	 * 	HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/getLoQueSea","GET");
	 * 2. Establezco el cuerpo de la peticion
	 * 	client.setRequestBody(cuerpoDeLaPeticionEnJson);
	 * 3. Envio y obtengo codigo respuesta
	 * 	int respCode = client.getResponseCode();
	 * 4. Si resp ok->200, obtengo cuerpo de respuesta
	 * 	if(respCode==200){
	 * 		String resp=client.getResponseBody();
	 * 		//tratamiento del JSON como tengais que hacerlo
	 * 	}
	 */


	/*Entrada:
	 * {
	 * 	'id_rol': int
	 * }
	 *Salida:
	 * {
	 * 	'id_empleado': int[],
	 *	'nombre': String[]
	 * 	'estado': boolean[]
	 * }
	 */
	public static TareaEmpleadoBean asignarTarea(int id_empleado, String tipoTrabjo, 
			String lugar){
		
		
		TareaEmpleadoBean resultado = null;
		HttpClient client = null;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirTarea","POST");

			JsonObject rqstJson = new JsonObject();
			rqstJson.addProperty("id_empleado", id_empleado);
			rqstJson.addProperty("tipoTrabjo", tipoTrabjo);
			rqstJson.addProperty("lugar", lugar);
			client.setRequestBody(rqstJson.toString());

			int respCode = client.getResponseCode();

			if(respCode == 200) {
				String resp = client.getResponseBody();

				JsonObject resJson = (JsonObject) JsonParser.parseString(resp);
				resultado = new TareaEmpleadoBean(resJson.get("id_incidencia").getAsInt());
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	/*Entrada:
	 * {
	 * 	'num_habitacion': int
	 * 	'hotel' : String
	 * 	'factura': float
	 * 	
	 * }
	 *Salida:
	 */
	public static void enviarFactura(int num_habitacion, String hotel, float factura){
		

		HttpClient client = null;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirMesa","POST");

			JsonObject rqstJson = new JsonObject();
			rqstJson.addProperty("habitacion", num_habitacion);
			rqstJson.addProperty("Hotel", hotel);
			rqstJson.addProperty("Factura", factura);
			client.setRequestBody(rqstJson.toString());

			int respCode = client.getResponseCode();

			if(respCode == 200) {
				System.out.println("Factura enviada");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
