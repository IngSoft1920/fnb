package ingsoft1920.fnb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.RestauranteM;
import ingsoft1920.fnb.Services.ConectorBBDD;

public class MesaDAO {

	private static Connection conn = null;

	public static List<MesaM> mesasDisp() {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<MesaM> resultado= new ArrayList<MesaM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  r.nombre AS nombre_rest, m.mesa_id AS mesa_id, m.num_mesa AS num_mesa,m.capacidad AS capacidad,"
							+ " CASE WHEN mesa_id in (SELECT mesa_id FROM mesa_ubicacion WHERE ABS(TIMESTAMPDIFF(MINUTE,?,fecha_reserva))<30 )"
							+ " THEN FALSE"
							+ " ELSE TRUE"
							+ " END as disponible"
							+ " FROM mesa as m"
							+ " JOIN restaurante as r ON m.restaurante_id=r.restaurante_id;");

			stmt.setObject(1, LocalDateTime.now());
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

	
	public static void alojarMesa(int mesa_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		PreparedStatement stmt = null; 
		try {
			stmt = conn.prepareStatement("INSERT INTO ubicacion VALUES (NULL);");
			stmt.execute();
			stmt= conn.prepareStatement("INSERT INTO mesa_ubicacion VALUES (?, (SELECT MAX(ubicacion_id) FROM  ubicacion),?);");
			stmt.setInt(1, mesa_id);
			stmt.setObject(2, LocalDateTime.now());
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
					+ " where mesa_id=? AND TIMESTAMPDIFF(MINUTE,?,fecha_reserva)>=-30 AND TIMESTAMPDIFF(MINUTE,?,fecha_reserva)<=0 ;");
			
			stmt.setInt(1,mesa_id);
			stmt.setObject(2, LocalDateTime.now());
			stmt.setObject(3, LocalDateTime.now());
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
	
	public static List<MesaM> horasNoDispRest(String nom_rest, int capacidad){
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<MesaM> resultado= new ArrayList<MesaM>();


		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT mu.fecha_reserva AS fecha_reserva"
					+ " FROM mesa as m"
					+ " JOIN restaurante as r ON m.restaurante_id=r.restaurante_id "
					+ "JOIN  mesa_ubicacion as mu ON  mu.mesa_id= m.mesa_id"
					+ " WHERE r.nombre = ? and m.capacidad=?;");

			stmt.setString(1, nom_rest);
			stmt.setInt(2, capacidad);
			rs=stmt.executeQuery();


			while(rs.next()) {
				resultado.add(new MesaM(rs.getObject("fecha_reserva",LocalDateTime.class)));
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
