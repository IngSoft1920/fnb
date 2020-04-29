package ingsoft1920.fnb.DAO;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ingsoft1920.fnb.Model.IngredienteM;
import ingsoft1920.fnb.Model.MenuM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoIngredienteM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Model.Plato_menuM;
import ingsoft1920.fnb.Model.RestauranteM;
import ingsoft1920.fnb.Services.ConectorBBDD;

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
							+ " WHERE r.nombre = ? and m.disponible=TRUE"
							+ " ORDER BY  m.titulo,p.num_plato ;");

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

	public static List<PlatoIngredienteM> ingredientes(int plato_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<PlatoIngredienteM> resultado= new ArrayList<PlatoIngredienteM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT  pi.ingrediente_id AS ingrediente_id, i.nombre AS nombre, pi.cantidad AS cantidad, pi.unidad AS unidad " + 
							"FROM plato_ingrediente AS pi " + 
							"JOIN  ingrediente AS i ON i.ingrediente_id=pi.ingrediente_id " + 
					"WHERE plato_id = ?;");

			stmt.setInt(1,plato_id);
			rs=stmt.executeQuery();

			while(rs.next()) {
				IngredienteM ingrediente = new IngredienteM(rs.getInt("ingrediente_id"),rs.getString("nombre"));
				resultado.add(new PlatoIngredienteM(ingrediente, rs.getInt("cantidad"), rs.getString("unidad")));

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
	public static void decrementarIngrediente(Map<Integer,Integer> ingredientes,String restaurante) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		PreparedStatement stmt = null; 

		try {
			for (Map.Entry<Integer, Integer> entry : ingredientes.entrySet()) { //MAP= <INGREDIENTE_ID, CANTIDAD>
				System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());

				stmt = conn.prepareStatement(
						"UPDATE ingrediente_inventario " + 
								"SET cantidad = (CASE WHEN cantidad - ? < 0 THEN 0 ELSE cantidad - ? END) " + 
								"WHERE ingrediente_id = ? " + 
								"and inventario_id = ( " + 
								"SELECT i.inventario_id AS inventario " + 
								"FROM inventario AS i " + 
								"JOIN restaurante AS r ON r.restaurante_id = i.restaurante_id " + 
								"WHERE r.nombre = ? " + 
						") ;");

				System.out.println(restaurante);
				stmt.setInt(1,entry.getValue());
				stmt.setInt(2,entry.getValue());
				stmt.setInt(3,entry.getKey());
				stmt.setString(4,restaurante);
				stmt.executeUpdate();

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
	public static void decrementarItem(Map<Integer,Integer> items,String restaurante) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		PreparedStatement stmt = null; 

		try {
			for (Map.Entry<Integer, Integer> entry : items.entrySet()) { //MAP= <Item_id, cantidad>
				System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());

				stmt = conn.prepareStatement(
						"UPDATE item_inventario " + 
								"SET cantidad = (CASE WHEN cantidad - ? < 0 THEN 0 ELSE cantidad - ? END) " + 
								"WHERE item_id = ? " + 
								"and inventario_id = ( " + 
								"SELECT i.inventario_id AS inventario " + 
								"FROM inventario AS i " + 
								"JOIN restaurante AS r ON r.restaurante_id = i.restaurante_id " + 
								"WHERE r.nombre = ? " + 
						") ;");

				stmt.setInt(1,entry.getValue());
				stmt.setInt(2,entry.getValue());
				stmt.setInt(3,entry.getKey());
				stmt.setString(4,restaurante);
				stmt.executeUpdate();

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
	public static void main(String[]args) {
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
		m.put(1, 10);
		m.put(5,4);
		decrementarItem(m,"Mamma Mia");
		
	}

}
