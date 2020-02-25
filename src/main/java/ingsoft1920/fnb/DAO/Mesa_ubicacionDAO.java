package ingsoft1920.fnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.Mesa_ubicacionM;
import ingsoft1920.fnb.Services.ConectorBBDD;

public class Mesa_ubicacionDAO {
	
	private static Connection conn;
	
	public static List<Mesa_ubicacionM> horasNoDispRest(String nombre_rest, int capacidad){
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<Mesa_ubicacionM> resultado= new ArrayList<Mesa_ubicacionM>();


		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT mu.fecha_reserva AS fecha_reserva"
					+ " FROM mesa as m"
					+ " JOIN restaurante as r ON m.restaurante_id=r.restaurante_id "
					+ "JOIN  mesa_ubicacion as mu ON  mu.mesa_id= m.mesa_id"
					+ " WHERE r.nombre = ? and m.capacidad=?;");

			stmt.setString(1, nombre_rest);
			stmt.setInt(2, capacidad);
			rs=stmt.executeQuery();


			while(rs.next()) {
				resultado.add(new Mesa_ubicacionM(rs.getObject("fecha_reserva",LocalDateTime.class)));
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