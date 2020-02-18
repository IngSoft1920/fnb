package ingsoft1920.ejemplo.DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ingsoft1920.ejemplo.Model.MenuM;
import ingsoft1920.ejemplo.Model.PlatoM;
import ingsoft1920.ejemplo.Model.Plato_menuM;
import ingsoft1920.ejemplo.Services.ConectorBBDD;

public class PlatoDAO {
	private static Connection conn = null;

	public static Map<String,PlatoM> platosRest(String nombre_rest) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		Map<String,PlatoM> resultado= new HashMap<String,PlatoM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  m.titulo AS nombre_menu, p.plato_id AS plato_id, p.num_plato as num_plato, "
							+ "p.tipo AS tipo_plato, p.nombre AS nombre_plato, pm.precio as precio_plato"
							+ " FROM plato as p"
							+ " JOIN plato_menu as pm ON p.plato_id= pm.plato_id"
							+ " JOIN menu as m ON m.menu_id = pm.menu_id"
							+ " JOIN restaurante as r ON r.restaurante_id= m.restaurante_id"
							+ " WHERE r.nombre = ? and m.disponible=TRUE;");

			stmt.setString(1, nombre_rest);
			rs=stmt.executeQuery();

			while(rs.next()) {
				MenuM menuTmp = new MenuM(rs.getString("nombre_menu"));
				Plato_menuM plato_menuTmp = new Plato_menuM(rs.getFloat("precio_plato"));
				resultado.put(rs.getString("nombre_plato"),new PlatoM(rs.getInt("plato_id"), rs.getString("tipo_plato"), rs.getInt("num_plato"),
						rs.getString("nombre_plato"), menuTmp, plato_menuTmp));
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
