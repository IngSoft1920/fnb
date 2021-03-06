package ingsoft1920.fnb.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.fnb.Beans.EmpleadoBean;
import ingsoft1920.fnb.DAO.ComandaDAO;
import ingsoft1920.fnb.Model.PlatoM;

@Controller
public class ApisEM {

	public final static int CAMARERO = 1;
	public final static int COCINERO = 2;
	public final static int METRE = 3;

	/*
	 * Flujo de ejecucion:
	 * 1. Instancio esta clase
	 * 	HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/getLoQueSea","GET");
	 * 2. Establzco el cuerpo de la peticion
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
	public static List<EmpleadoBean> peticionPedirEmpleado(int id_rol){
		List<EmpleadoBean> resultado = new ArrayList<EmpleadoBean>();
		HttpClient client = null;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7002/empleadoTipo","POST");

			JsonObject rqstJson = new JsonObject();
			rqstJson.addProperty("id_rol", id_rol);
			client.setRequestBody(rqstJson.toString());

			int respCode = client.getResponseCode();

			if(respCode == 200) {
				String resp = client.getResponseBody();

				JsonObject resJson = (JsonObject) JsonParser.parseString(resp);
				JsonArray listaIdEmpleado = resJson.get("id_empleado").getAsJsonArray();
				JsonArray listaNombre = resJson.get("nombre").getAsJsonArray();
				JsonArray listaEstado = resJson.get("estado").getAsJsonArray();

				for (int i =0; i<listaIdEmpleado.size(); i++) {
					resultado.add(new EmpleadoBean(listaIdEmpleado.get(i).getAsInt(),
							listaNombre.get(i).getAsString(),
							listaEstado.get(i).getAsBoolean()));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}


	public static void productoVip(int comanda_id, int menu_id){
		List<PlatoM> resultado= ComandaDAO.calcularPrecioVIP(comanda_id, menu_id);
		HttpClient client = null;
		for (PlatoM p:resultado) {
			try {
				client = new HttpClient("http://piedrafita.ls.fi.upm.es:7002/incentivos","POST");

				JsonObject rqstJson = new JsonObject();
				rqstJson.addProperty("id_empleado", 1);
				rqstJson.addProperty("descripcion", p.getNombre());
				rqstJson.addProperty("valor", p.getPlato_menu().getPrecio());
				client.setRequestBody(rqstJson.toString());

				int respCode = client.getResponseCode();
				System.out.println(client.getResponseBody());

				if(respCode != 200) {
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String []args) {
		productoVip(174, 1);
	}
	
	
}