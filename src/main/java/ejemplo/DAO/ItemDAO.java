package ingsoft1920.ejemplo.DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ingsoft1920.ejemplo.Model.ItemM;
import ingsoft1920.ejemplo.Model.Item_menuM;
import ingsoft1920.ejemplo.Model.MenuM;
import ingsoft1920.ejemplo.Services.ConectorBBDD;

public class ItemDAO {
	private static Connection conn = null;

	public static Map<String,ItemM> itemsRest(String nombre_rest) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		Map<String,ItemM> resultado= new HashMap<String,ItemM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  m.titulo AS nombre_menu, i.item_id AS item_id,"
							+ " i.tipo AS tipo_item, i.nombre AS nombre_item, im.precio as precio_item"
							+ " FROM item as i"
							+ " JOIN item_menu as im ON i.item_id= im.item_id "
							+ "JOIN menu as m ON m.menu_id = im.menu_id "
							+ "JOIN restaurante as r ON r.restaurante_id= m.restaurante_id "
							+ "WHERE r.nombre = ? and m.disponible=TRUE;");

			stmt.setString(1, nombre_rest);
			rs=stmt.executeQuery();

			while(rs.next()) {
				MenuM menuTmp = new MenuM(rs.getString("nombre_menu"));
				Item_menuM item_menuTmp = new Item_menuM(rs.getFloat("precio_item"));
				resultado.put(rs.getString("nombre_item"),new  ItemM(rs.getInt("item_id"), 
						rs.getString("tipo_item"),rs.getString("nombre_item"), menuTmp, item_menuTmp));
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
