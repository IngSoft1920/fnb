package ingsoft1920.ejemplo.Services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectorBBDD {

	private static Connection conn = null;	
	private static String servidor = "piedrafita.ls.fi.upm.es:8000";
	private static String usuario = "fnb"; 
	private static String contrasena = "ingSoft20fnb.224";
	private static String baseDeDatos = "fnb";

	public static Connection conectar (){
		if (conn==null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				conn = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+baseDeDatos+"?" +       
						"user="+usuario+"&password=" + contrasena +
						"&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC");
			} catch (SQLException ex) { 
				System.out.println("SQLException: " + ex.getMessage());     
				System.out.println("SQLState: " + ex.getSQLState()); 
				System.out.println("VendorError: " + ex.getErrorCode()); 
			}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}


	public static void desconectar (){
		if (conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}


}
