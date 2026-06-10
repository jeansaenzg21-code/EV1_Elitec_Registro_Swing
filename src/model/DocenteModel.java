package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import entidad.Docente;
import util.MySqlDBConexion;

public class DocenteModel {
	public int insertaDocente(Docente obj) {

		int salida = -1;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
		//1 Crear conexión
		conn = MySqlDBConexion.getConexion();
		
		//2 Crear sentencia SQL
		String sql = "INSERT INTO docente (nombres, apellidos, fechaNacimiento, fechaIngreso, Dni, direccion, estado) VALUES (?,?,?,?,?,?,?)";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, obj.getNombres());
		pstm.setString(2, obj.getApellidos());
		pstm.setDate(3, java.sql.Date.valueOf(obj.getFechaNacimiento()));
		pstm.setDate(4, java.sql.Date.valueOf(obj.getFechaIngreso()));
		pstm.setString(5, obj.getDni());
		pstm.setString(6, obj.getDireccion());
		pstm.setString(7, obj.getEstado());
		
		//3 Ejecutar sentencia SQL 
		salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return salida;
	}
	
	public List<Docente> listaDocente(String nombre, String dni, String direccion) {

	    List<Docente> lista = new ArrayList<Docente>();

	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    try {

	        conn = MySqlDBConexion.getConexion();

	        String sql = "SELECT * FROM docente "
	                + "WHERE nombres LIKE ? "
	                + "AND dni LIKE ? "
	                + "AND direccion LIKE ?";

	        pstm = conn.prepareStatement(sql);

	        pstm.setString(1, "%" + nombre + "%");
	        pstm.setString(2, "%" + dni + "%");
	        pstm.setString(3, "%" + direccion + "%");

	        rs = pstm.executeQuery();

	        while (rs.next()) {

	            Docente obj = new Docente();

	            obj.setIdDocente(rs.getInt("idDocente"));
	            obj.setNombres(rs.getString("nombres"));
	            obj.setApellidos(rs.getString("apellidos"));
	            obj.setDni(rs.getString("dni"));
	            obj.setDireccion(rs.getString("direccion"));
	            obj.setEstado(rs.getString("estado"));

	            lista.add(obj);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    finally {
	        try {
	            if(rs != null) rs.close();
	            if(pstm != null) pstm.close();
	            if(conn != null) conn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }


	    return lista;
	}
	

}
