package ingsoft1920.fnb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ingsoft1920.fnb.Model.ComandaM;
import ingsoft1920.fnb.Model.ElemComandaM;
import ingsoft1920.fnb.Model.MenuM;
import ingsoft1920.fnb.Model.MesaHabitacionM;
import ingsoft1920.fnb.Model.MesaM;
import ingsoft1920.fnb.Model.PlatoM;
import ingsoft1920.fnb.Services.ConectorBBDD;


public class ComandaDAO {
	private static Connection conn = null;
	
	
	public static void checkout(int comanda_id) {
		MesaM mesa= infoFacturas(comanda_id);
		if(mesa!= null) {
			MesaDAO.desalojarMesa(mesa.getMesa_id());
			eliminarComanda(comanda_id);
			// TODO: llamar API DHO
			// enviarFactura( int habitacion_id, String hotel, float Factura);
			
		}
		
		
	}

	public static List<ComandaM> comandasTareaCocina(int tareaCocina) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		List<ComandaM> resultado= new ArrayList<ComandaM>();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT c.comanda_id AS comanda_id, c.hora as hora, "
							+ "p.plato_id AS plato_id, p.nombre AS nombre_plato, "
							+ "p.num_plato AS num_plato, ce.n_elem AS n_elem"
							+ " FROM comanda AS c"
							+ " JOIN comanda_elemComanda AS ce ON  c.comanda_id=ce.comanda_id "
							+ "JOIN elemComanda AS e ON e.elemComanda_id = ce.elemComanda_id "
							+ "JOIN plato AS p ON p.elemComanda_id = e.elemComanda_id "
							+ "WHERE c.tarea_cocinero_id=? and estado_acabado = FALSE "
							+ "ORDER BY c.hora;");

			stmt.setInt(1, tareaCocina);
			rs=stmt.executeQuery();

			while(rs.next()) {
				ElemComandaM elemCtmp = new ElemComandaM(0,rs.getInt("n_elem"));
				PlatoM platoTmp = new PlatoM(rs.getInt("plato_id") ,rs.getInt("num_plato"), rs.getString("nombre_plato"), elemCtmp);
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
	
	public static float calcularPrecio(int comanda_id, int menu_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();
		float res1, res2, precio =0;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt= conn.prepareStatement("SELECT ce.n_elem AS numVeces, pm.precio AS precio " 
					+ "FROM  comanda_elemComanda AS ce " 
					+ "JOIN elemComanda AS e ON  e.elemComanda_id = ce.elemComanda_id " 
					+ "JOIN plato AS p ON  p.elemComanda_id = e.elemComanda_id " 
					+ "JOIN plato_menu AS pm ON pm.plato_id= p.plato_id "
					+ "WHERE ce.comanda_id=? AND  pm.menu_id=?;");
			stmt.setInt(1, comanda_id);
			stmt.setInt(2, menu_id);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
			res1=rs.getInt("numVeces");
			res2=rs.getFloat("precio");
			System.out.println(res1);
			System.out.println(res2);
			precio += res1*res2;
			}
			
			
			stmt= conn.prepareStatement("SELECT ce.n_elem AS numVeces, im.precio AS precio " 
					+ "FROM comanda_elemComanda AS ce " 
					+ "JOIN elemComanda AS e ON  e.elemComanda_id = ce.elemComanda_id " 
					+ "JOIN item AS i ON  i.elemComanda_id = e.elemComanda_id "
					+ "JOIN item_menu AS im ON im.item_id= i.item_id "
					+ "WHERE ce.comanda_id=? AND  im.menu_id=?;");
			
			stmt.setInt(1, comanda_id);
			stmt.setInt(2, menu_id);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
			res1=rs.getInt("numVeces");
			res2=rs.getFloat("precio");
			System.out.println(res1);
			System.out.println(res2);
			precio += res1*res2;
			}
			
		} catch(SQLException ex) {
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
		
		return precio;
			
	}
	
	public static void eliminarComanda(int comanda_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();
	
		PreparedStatement stmt = null;
		
		try {
		
				stmt= conn.prepareStatement("DELETE FROM comanda_elemComanda WHERE comanda_id =?;");
				stmt.setInt(1, comanda_id);
				stmt.execute();

				stmt= conn.prepareStatement("DELETE FROM comanda WHERE comanda_id = ?;");
				stmt.setInt(1, comanda_id);
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

	
	
	public static ComandaM insertComanda(int mesa_id,String[] platos, String[] items) {
		if (conn == null)
			conn= ConectorBBDD.conectar();
		for(String p: platos)
			System.out.println(p);

		ComandaM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		System.out.println(mesa_id);

		try {
			stmt = conn.prepareStatement(
					"INSERT INTO comanda (estado_acabado, ubicacion_id,tarea_cocinero_id,hora) VALUES " + 
							"(FALSE, "
							+ "(SELECT ubicacion_id FROM mesa_ubicacion WHERE mesa_id = ? AND ABS(TIMESTAMPDIFF(MINUTE,?,fecha_reserva))<30)"
							+ " , ?,?);", Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, mesa_id);
			stmt.setString(2, LocalDateTime.now().toString());
			//TODO usar tarea_cocinero de DHO
			stmt.setInt(3, 3);
			stmt.setString(4, LocalDateTime.now().toString());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			if(rs.next())
				resultado=new ComandaM(rs.getInt(1));

			if(resultado != null) {

				String param1 ="";
				int num =0;
				for (int i =0; i<platos.length-1;i++) 
					param1+="?,";
				param1+="?";

				String param2 ="";
				for (int i =0; i<items.length-1;i++)
					param2+="?,";
				param2+="?";
				stmt = conn.prepareStatement(
						"SELECT nombre, elemComanda_id FROM plato WHERE nombre in ("+param1+") " + 
								"UNION " + 
								"SELECT nombre, elemComanda_id FROM item WHERE nombre in ("+param2+");");
				int i =1;

				Map<String,Integer> contador= new HashMap<String,Integer>();
				Integer n;

				if(platos.length==0)
					stmt.setString(i++,"NULL");
				else {
					int j =i;
					for(; i<platos.length+j;i++) {
						stmt.setString(i, platos[i-j]);
						n= contador.get(platos[i-j]);
						contador.put(platos[i-j], n==null? 1:(n+1));
					}
				}

				if(items.length==0)
					stmt.setString(i++,"NULL");
				else {
					int k =i;
					for(; i<items.length+k;i++) {
						stmt.setString(i, items[i-k]);
						n= contador.get(items[i-k]);
						contador.put(items[i-k], n==null? 1:(n+1));
					}

				}
				rs=stmt.executeQuery();

				rs.last();
				int lon =rs.getRow();
				System.out.println(lon);	

				String param3 ="";
				for(i=0; i<lon-1; i++) {
					param3 += "(?,?,?),";
				}
				param3 += "(?,?,?)";
				System.out.println(param3);
				stmt = conn.prepareStatement(
						"INSERT INTO comanda_elemComanda VALUES " + param3);
				i=1;
				if 	(rs.first()) {
					do {
						System.out.println(i);
						stmt.setInt(i++, resultado.getComanda_id());
						System.out.println(i);
						stmt.setInt(i++, rs.getInt("elemComanda_id"));
						System.out.println(i);
						stmt.setInt(i++,contador.get(rs.getString("nombre")));
					}while(rs.next());
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
	public static MesaM infoFacturas(int comanda_id) {
		if (conn == null)
			conn= ConectorBBDD.conectar();

		MesaM resultado= null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT mh.habitacion_id AS habitacion_id, m.mesa_id AS mesa_id, m.num_mesa AS num_mesa, menu.menu_id AS menu_id " + 
					"FROM comanda AS c " + 
					"JOIN ubicacion AS u ON u.ubicacion_id= c.ubicacion_id " + 
					"JOIN mesa_ubicacion AS mu ON mu.ubicacion_id = u.ubicacion_id " + 
					"JOIN mesa AS m ON mu.mesa_id= m.mesa_id " + 
					"JOIN mesa_habitacion AS mh ON mh.mesa_id=m.mesa_id " + 
					"JOIN restaurante AS r ON r.restaurante_id = m.restaurante_id " + 
					"JOIN menu ON menu.restaurante_id = r.restaurante_id " + 
					"WHERE c.comanda_id=? ;");

			stmt.setInt(1,comanda_id);
			
			rs=stmt.executeQuery();

			if(rs.next()) {
				MesaHabitacionM habitacion = new MesaHabitacionM(rs.getInt("habitacion_id"));
				MenuM menu= new MenuM(rs.getInt("menu_id"));
				resultado= new MesaM(rs.getInt("mesa_id"),rs.getInt("num_mesa"), habitacion, menu);
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
				int num =0;
				for (int i =0; i<platos.length-1;i++) 
					param1+="?,";
				param1+="?";

				String param2 ="";
				for (int i =0; i<items.length-1;i++)
					param2+="?,";
				param2+="?";
				stmt = conn.prepareStatement(
						"SELECT nombre, elemComanda_id FROM plato WHERE nombre in ("+param1+") " + 
								"UNION " + 
								"SELECT nombre, elemComanda_id FROM item WHERE nombre in ("+param2+");");
				int i =1;

				Map<String,Integer> contador= new HashMap<String,Integer>();
				Integer n;

				if(platos.length==0)
					stmt.setString(i++,"NULL");
				else {
					int j =i;
					for(; i<platos.length+j;i++) {
						stmt.setString(i, platos[i-j]);
						n= contador.get(platos[i-j]);
						contador.put(platos[i-j], n==null? 1:n+1);
					}
				}

				if(items.length==0)
					stmt.setString(i++,"NULL");
				else {
					int k =i;
					for(; i<items.length+k;i++) {
						stmt.setString(i, items[i-k]);
						n= contador.get(items[i-k]);
						contador.put(items[i-k], n==null? 1:n+1);
					}

				}
				rs=stmt.executeQuery();

				rs.last();
				int lon =rs.getRow();
				System.out.println(lon);	

				String param3 ="";
				for(i=0; i<lon-1; i++) {
					param3 += "(?,?,?),";
				}
				param3 += "(?,?,?)";
				System.out.println(param3);
				stmt = conn.prepareStatement(
						"INSERT INTO comanda_elemComanda VALUES " + param3);
				i=1;
				if 	(rs.first()) {
					do {
						System.out.println(i);
						stmt.setInt(i++, resultado.getComanda_id());
						System.out.println(i);
						stmt.setInt(i++, rs.getInt("elemComanda_id"));
						System.out.println(i);
						stmt.setInt(i++,contador.get(rs.getString("nombre")));
					}while(rs.next());
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
	public static void main(String[] args) {
		
		System.out.println(calcularPrecio(83,1));
		
	}
}
