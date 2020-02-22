package ingsoft1920.fnb.DAO;


import java.sql.Array;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.fnb.Model.ComandaM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Services.ConectorBBDD;


public class ComandaDAO {
	private static Connection conn = null;

	public static List<ComandaM> comandasTareaCocina(int tareaCocina) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<ComandaM> resultado= new ArrayList<ComandaM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT c.comanda_id AS comanda_id, c.hora as hora,p.plato_id AS plato_id, p.nombre AS nombre_plato, p.num_plato AS num_plato"
							+ " FROM comanda AS c"
							+ " JOIN comanda_elemComanda AS ce ON  c.comanda_id=ce.comanda_id "
							+ "JOIN elemComanda AS e ON e.elemComanda_id = ce.elemComanda_id "
							+ "JOIN plato AS p ON p.elemComanda_id = e.elemComanda_id "
							+ "WHERE c.tarea_cocinero_id=? and estado_acabado = FALSE "
							+ "ORDER BY c.hora;");

			stmt.setInt(1, tareaCocina);
			rs=stmt.executeQuery();

			while(rs.next()) {
				PlatoM platoTmp = new PlatoM(rs.getInt("plato_id") ,rs.getInt("num_plato"), rs.getString("nombre_plato"));
				resultado.add(new ComandaM(rs.getInt("comanda_id"), rs.getObject("hora", LocalDateTime.class), platoTmp));
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

	public static void completarComanda(int comanda_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		PreparedStatement stmt = null; 
		try {
			stmt = conn.prepareStatement("UPDATE comanda SET estado_acabado=1 WHERE comanda_id=?;");
			stmt.setInt(1, comanda_id);
			stmt.executeUpdate();
			
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
	public static ComandaM insertComanda(int mesa_id,String[] platos, String[] items) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		ComandaM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO comanda (esta_acabado, ubicacion_id,tarea_cocinero_id,hora) VALUES \r\n" + 
							"(FALSE, (SELECT ubicacion_id FROM mesa_ubicacion WHERE mesa_id = ?), ?,?);", Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, mesa_id);
			//TODO usar tarea_cocinero de DHO
			stmt.setInt(2, 3);
			stmt.setObject(3, LocalDateTime.now());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			if(rs.next())
				resultado=new ComandaM(rs.getInt(1));

			if(resultado != null) {
				stmt = conn.prepareStatement(
						"INSERT INTO comanda_elemComanda " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN plato AS p ON p.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM plato WHERE nombre in (?)) " + 
								"UNION " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN item AS i ON i.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM item WHERE nombre in (?));");
				stmt.setInt(1,resultado.getComanda_id());
				stmt.setArray(2, stmt.getConnection().createArrayOf("VARCHAR", platos));
				stmt.setInt(3,resultado.getComanda_id());
				stmt.setArray(4, stmt.getConnection().createArrayOf("VARCHAR", items));
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
