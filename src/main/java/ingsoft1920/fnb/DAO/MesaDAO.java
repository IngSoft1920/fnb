package ingsoft1920.fnb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.ComandaM;
import ingsoft1920.fnb.Model.MenuM;
import ingsoft1920.fnb.Model.MesaHabitacionM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.RestauranteM;
import ingsoft1920.fnb.Services.ConectorBBDD;

public class MesaDAO {

	private static Connection conn = null;

	
	public static boolean enPersona(int idMesa) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		boolean  resultado=false;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  enPersona FROM mesa_ubicacion "
					+ "WHERE mesa_id = ? AND  ABS(TIMESTAMPDIFF(MINUTE,?,fecha_reserva))<30;");

			stmt.setInt(1,idMesa);
			stmt.setString(2, LocalDateTime.now().toString());
			rs=stmt.executeQuery();

			if(rs.next()) {
				resultado = rs.getBoolean("enPersona");
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
		System.out.println("El resultado es : "+resultado);
		return resultado;
	}
	
	
	
	public static List<MesaM> mesasDisp() {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<MesaM> resultado= new ArrayList<MesaM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  r.nombre AS nombre_rest, m.mesa_id AS mesa_id, m.num_mesa AS num_mesa,m.capacidad AS capacidad,"
							+ " CASE WHEN mesa_id in "
							+ "(SELECT mesa_id "
							+ "FROM mesa_ubicacion "
							+ "WHERE ABS(TIMESTAMPDIFF(MINUTE,?,fecha_reserva))<30 )"
							+ " THEN FALSE"
							+ " ELSE TRUE"
							+ " END as disponible"
							+ " FROM mesa as m"
							+ " JOIN restaurante as r ON m.restaurante_id=r.restaurante_id;");

			stmt.setString(1, LocalDateTime.now().toString());
			rs=stmt.executeQuery();

			while(rs.next()) {
				RestauranteM restauranteTmp = new RestauranteM(rs.getString("nombre_rest"));
				resultado.add(new MesaM(rs.getInt("mesa_id"), rs.getInt("num_mesa"), rs.getInt("capacidad"), restauranteTmp, rs.getBoolean("disponible")));
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
	
	public static List<MesaHabitacionM> verHabitacion(int mesa_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<MesaHabitacionM> resultado= new ArrayList<MesaHabitacionM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT mh.num_habitacion AS num_habitacion, r.hotel_id AS hotel_id " + 
					"FROM mesa AS m  " + 
					"JOIN mesa_habitacion AS mh ON  m.mesa_id = mh.mesa_id " + 
					"JOIN restaurante AS r ON m.restaurante_id = r.restaurante_id " + 
					"WHERE mesa_id = ?;");

			stmt.setInt(1, mesa_id);
			rs=stmt.executeQuery();

			while(rs.next()) {
				
				resultado.add(new MesaHabitacionM(rs.getInt("num_habitacion")));
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
	
	public static void alojarMesa(int mesa_id, LocalDateTime fecha_hora,int [] num_habitaciones, int enpersona) {
		if(mesa_id>0) {

			if (conn == null)
				conn= ConectorBBDD.conectar();

			PreparedStatement stmt = null; 
			ResultSet rs = null;
			ComandaM resultado= null;
			try {
				stmt = conn.prepareStatement("INSERT INTO ubicacion VALUES (NULL);",Statement.RETURN_GENERATED_KEYS);
				stmt.execute();
				rs=stmt.getGeneratedKeys();
				if(rs.next())
					resultado=new ComandaM(rs.getInt(1));
				stmt= conn.prepareStatement(
						"INSERT INTO mesa_ubicacion VALUES (?,?,?,?);");
				stmt.setInt(1, mesa_id);
				stmt.setInt(2,resultado.getComanda_id());
				stmt.setString(3, fecha_hora == null ? LocalDateTime.now().toString() : fecha_hora.toString());
				stmt.setInt(4, enpersona);
				stmt.execute();
				
				String param1 ="";
				for (int i =0; i<num_habitaciones.length-1;i++)
					param1+="(?,?),";
				param1+="(?,?)";
				
				stmt= conn.prepareStatement(
						"INSERT INTO mesa_habitacion (mesa_id,num_habitacion) VALUES"+param1+";");
				
				for (int i =1,j=0; i<=(2*num_habitaciones.length);i+=2,j++) {
					stmt.setInt(i,mesa_id);
					stmt.setInt(i+1,num_habitaciones[j]);
				}
				
				stmt.execute();
				
			}catch(SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			}finally {
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
		}
	}

	public static void desalojarMesa(int mesa_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();
		ResultSet rs= null;
		PreparedStatement stmt = null;
		int ubicacion_id = 0;
		try {
			stmt = conn.prepareStatement(
					"select ubicacion_id "
							+ "from mesa_ubicacion"
							+ " where mesa_id=? AND TIMESTAMPDIFF(MINUTE,?,fecha_reserva)>=-30"
							+ " AND TIMESTAMPDIFF(MINUTE,?,fecha_reserva)<=0 ;");

			stmt.setInt(1,mesa_id);
			stmt.setString(2, LocalDateTime.now().toString());
			stmt.setString(3, LocalDateTime.now().toString());
			rs = stmt.executeQuery();

			if(rs.next())
				ubicacion_id = rs.getInt("ubicacion_id");
			if(ubicacion_id>0) {
				stmt= conn.prepareStatement("DELETE FROM mesa_ubicacion WHERE ubicacion_id =?;");
				stmt.setInt(1, ubicacion_id);
				stmt.execute();

				stmt= conn.prepareStatement("DELETE FROM ubicacion WHERE ubicacion_id =?;");
				stmt.setInt(1, ubicacion_id);
				stmt.execute();
				

				stmt= conn.prepareStatement("DELETE FROM mesa_habitacion WHERE mesa_id =?;");
				stmt.setInt(1, mesa_id);
				stmt.execute();
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}finally {
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
	}


	public static MesaM mesaDisp(String nom_rest,LocalDateTime fecha_hora, int capacidad) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		MesaM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT MIN(m.mesa_id) AS mesa_id " + 
							"FROM mesa as m " + 
							"JOIN restaurante as r ON m.restaurante_id=r.restaurante_id " + 
							"WHERE r.nombre = ? and m.capacidad=? and mesa_id not in "
							+ "(SELECT mu.mesa_id AS mesa_id "
							+ "FROM mesa as m "
							+ "JOIN restaurante as r ON m.restaurante_id=r.restaurante_id  "
							+ "JOIN  mesa_ubicacion as mu ON  mu.mesa_id= m.mesa_id "
							+ "WHERE r.nombre = ? and m.capacidad=? and mu.fecha_reserva = ?);");

			stmt.setString(1, nom_rest);
			stmt.setInt(2, capacidad);
			stmt.setString(3, nom_rest);
			stmt.setInt(4, capacidad);
			stmt.setString(5, fecha_hora.toString());
			rs=stmt.executeQuery();

			if(rs.next()) {
				resultado= new MesaM(rs.getInt("mesa_id"));
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

	public static void main(String[]args) {
		
		List<MesaM> lista = mesasDisp();
		for(MesaM m:lista)
			System.out.println(m);
	}
	
	
	
}
