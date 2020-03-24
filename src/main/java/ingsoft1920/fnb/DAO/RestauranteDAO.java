package ingsoft1920.fnb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.RestauranteM;
import ingsoft1920.fnb.Services.ConectorBBDD;

public class RestauranteDAO {
	
	private static Connection conn;
	
	public static RestauranteM horarioRest(String nombre) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		RestauranteM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT hora_apertura, hora_clausura " + 
					"FROM restaurante " + 
					"WHERE nombre = ?;");
			stmt.setString(1, nombre);
			rs=stmt.executeQuery();

			if(rs.next()) {
				resultado = new RestauranteM(rs.getObject(1,LocalTime.class),rs.getObject(2,LocalTime.class));
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}finally {
			if (rs!=null){
				try{rs.close();
				}catch(SQLException sqlEx){}
				rs=null;
			}
			if (stmt!=null){
				try{stmt.close();
				}catch(SQLException sqlEx){}
				stmt=null;
			}
			if (conn!=null){
				ConectorBBDD.desconectar();
				conn=null;
			}
		}
		return resultado;

	}
	
	
	public static List<RestauranteM> infoRest(){
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<RestauranteM> resultado= new ArrayList<RestauranteM>();
		Statement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM restaurante;");

			while(rs.next()) {
				resultado.add(new RestauranteM(rs.getInt(1),rs.getString(2),rs.getObject(3,LocalTime.class),rs.getObject(4,LocalTime.class)));
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}finally {
			if (rs!=null){
				try{rs.close();
				}catch(SQLException sqlEx){}
				rs=null;
			}
			if (stmt!=null){
				try{stmt.close();
				}catch(SQLException sqlEx){}
				stmt=null;
			}
			if (conn!=null){
				ConectorBBDD.desconectar();
				conn=null;
			}
		}
		return resultado;
	}
}
