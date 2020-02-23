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
					"INSERT INTO comanda (estado_acabado, ubicacion_id,tarea_cocinero_id,hora) VALUES " + 
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
				String param1 ="";
				for (int i =0; i<platos.length-1;i++)
					param1+="?,";
				param1+="?";

				String param2 ="";
				for (int i =0; i<items.length-1;i++)
					param2+="?,";
				param2+="?";
				stmt = conn.prepareStatement(
						"INSERT INTO comanda_elemComanda " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN plato AS p ON p.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM plato WHERE nombre in ("+param1+")) " + 
								"UNION " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN item AS i ON i.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM item WHERE nombre in ("+param2+"));");

				int i =1;
				stmt.setInt(i++,resultado.getComanda_id());

				if(platos.length==0)
					stmt.setString(i++,"NULL");
				else {
					int j =i;
					for(; i<platos.length+j;i++) 
						stmt.setString(i, platos[i-j]);
				}

				stmt.setInt(i++,resultado.getComanda_id());

				if(items.length==0)
					stmt.setString(i++,"NULL");
				else {
					int k =i;
					for(; i<items.length+k;i++) 
						stmt.setString(i, items[i-k]);

				}
				stmt.execute();
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

	public static ComandaM insertComandaHab(int habitacion_id,LocalDateTime fecha_hora, String[] platos, String[] items) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		ComandaM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO ubicacion VALUES (NULL);",Statement.RETURN_GENERATED_KEYS);
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			int ubicacion_id =0;
			if(rs.next())
				ubicacion_id=rs.getInt(1);
			stmt= conn.prepareStatement("INSERT INTO habitacion_ubicacion VALUES (?, ?,?);");
			stmt.setInt(1, habitacion_id);
			stmt.setInt(2, ubicacion_id);
			stmt.setObject(3, fecha_hora == null ? LocalDateTime.now() : fecha_hora);
			stmt.execute();

			stmt = conn.prepareStatement(
					"INSERT INTO comanda (estado_acabado, ubicacion_id,tarea_cocinero_id,hora) VALUES " + 
							"(FALSE, ?, ?,?);", Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, ubicacion_id);
			//TODO usar tarea_cocinero de DHO
			stmt.setInt(2, 3);
			stmt.setObject(3, LocalDateTime.now());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			if(rs.next())
				resultado=new ComandaM(rs.getInt(1));

			if(resultado != null) {
				String param1 ="";
				for (int i =0; i<platos.length-1;i++)
					param1+="?,";
				param1+="?";

				String param2 ="";
				for (int i =0; i<items.length-1;i++)
					param2+="?,";
				param2+="?";
				stmt = conn.prepareStatement(
						"INSERT INTO comanda_elemComanda " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN plato AS p ON p.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM plato WHERE nombre in ("+param1+")) " + 
								"UNION " + 
								"SELECT ? as comanda_id, ec.elemComanda_id as elemComanda_id " + 
								"FROM elemComanda AS ec " + 
								"JOIN item AS i ON i.elemComanda_id= ec.elemComanda_id " + 
								"WHERE ec.elemComanda_id in (SELECT elemComanda_id FROM item WHERE nombre in ("+param2+"));");

				int i =1;
				stmt.setInt(i++,resultado.getComanda_id());

				if(platos.length==0)
					stmt.setString(i++,"NULL");
				else {
					int j =i;
					for(; i<platos.length+j;i++) 
						stmt.setString(i, platos[i-j]);
				}

				stmt.setInt(i++,resultado.getComanda_id());

				if(items.length==0)
					stmt.setString(i++,"NULL");
				else {
					int k =i;
					for(; i<items.length+k;i++) 
						stmt.setString(i, items[i-k]);

				}
				stmt.execute();
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
