package model;

import java.sql.Connection;
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

}
