package ingsoft1920.fnb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.IngredienteInventarioM;
import ingsoft1920.fnb.Model.IngredienteM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.RestauranteM;
import ingsoft1920.fnb.Services.ConectorBBDD;

public class InventarioDAO {

		private static Connection conn = null;
		
		public static List<IngredienteInventarioM> inventario(String restaurante) {
			
				if (conn == null)
					conn= ConectorBBDD.conectar();

				List<IngredienteInventarioM> resultado= new ArrayList<IngredienteInventarioM>();
				PreparedStatement stmt = null; 
				ResultSet rs = null;
				try {
					stmt = conn.prepareStatement(
							"SELECT ing.nombre AS nombre, ii.cantidad AS cantidad, ii.unidad AS unidad " + 
							"FROM ingrediente_inventario AS ii " + 
							"JOIN ingrediente AS ing ON ing.ingrediente_id = ii.ingrediente_id " + 
							"JOIN inventario AS inv ON inv.inventario_id = ii.inventario_id " + 
							"JOIN restaurante AS r ON r.restaurante_id = inv.restaurante_id " + 
							"WHERE r.nombre = ? " + 
							"UNION  " + 
							"SELECT itm.nombre AS nombre, ii.cantidad AS cantidad, \"unidad\" AS unidad " + 
							"FROM item_inventario AS ii " + 
							"JOIN item AS itm ON itm.item_id = ii.item_id " + 
							"JOIN inventario AS inv ON inv.inventario_id = ii.inventario_id " + 
							"JOIN restaurante AS r ON r.restaurante_id = inv.restaurante_id " + 
							"WHERE r.nombre = ?");

					stmt.setString(1,restaurante);
					stmt.setString(2,restaurante);
					rs=stmt.executeQuery();

					while(rs.next()) {
						IngredienteM ingrediente = new IngredienteM(rs.getString("nombre"));
						resultado.add(new IngredienteInventarioM(rs.getInt("cantidad"), rs.getString("unidad"), ingrediente));
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


