package ingsoft1920.fnb.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
							+ "WHERE c.tarea_cocinero_id=? and estado_acabado = FALSE;");

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

}
