package ingsoft1920.fnb.Controller;

import com.google.gson.JsonObject;

public class ApisCM {
	/*Salida:
	 * {
	 * 	
  		"preferencias" : "alergia al tomate, sábanas azules, café muy caliente"
		
	 * }
	 */
	public static String recibirPreferencias(int id_cliente){
		
		
		String resultado = "";
		HttpClient client = null;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/preferencias/+id_cliente+","GET");

			int respCode = client.getResponseCode();

			if(respCode == 200) {
				resultado = client.getResponseBody();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	/*Entrada:
	 * {
	 * 	
  		"preferencias" : "miedo a las arañas,amante del vino"
		
	 * }
	 */
	public static void enviarPreferencias(int id_cliente,String preferencias){
		
		
		HttpClient client = null;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/preferencias/+id_cliente+","GET");
			JsonObject rqstJson = new JsonObject();
			rqstJson.addProperty("preferencias",preferencias);
			client.setRequestBody(rqstJson.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}


}
