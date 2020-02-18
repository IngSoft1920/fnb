package ingsoft1920.fnb.DAO;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(
					"SELECT  r.nombre AS nombre_rest, m.mesa_id AS mesa_id, m.num_mesa AS num_mesa,m.capacidad AS capacidad,"
							+ " CASE WHEN mesa_id in (SELECT mesa_id FROM mesa_ubicacion) THEN FALSE"
							+ " ELSE TRUE"
							+ " END as disponible"
							+ " FROM mesa as m"
							+ " JOIN restaurante as r ON m.restaurante_id=r.restaurante_id;");

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


}
