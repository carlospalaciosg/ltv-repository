package Database;

import java.sql.*;

import javax.xml.stream.util.StreamReaderDelegate;

public class DataBase {
	private Connection Conexion;
	private PreparedStatement stInsert;
	private PreparedStatement stCheck;
	private PreparedStatement stDelete;
	private PreparedStatement stUpdate;
	
	
	public void PrepareSolicitudes() throws Exception {
		Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltv-database","root","");
		stInsert = Conexion.prepareStatement("INSERT INTO solicitudestable VALUES (?,?,?,?,?)");
	    stCheck = Conexion.prepareStatement("SELECT * FROM solicitudestable WHERE cliente=?");
	    stDelete = Conexion.prepareStatement("DELETE FROM solicitudestable WHERE cliente=?");
	    stUpdate = Conexion.prepareStatement("UPDATE solicitudestable SET usuario=?, estatus=? WHERE cliente=?");
	}

	public void PrepareUsuarios() throws Exception {
		Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltv-database","root","");
		stInsert = Conexion.prepareStatement("INSERT INTO usuariostable VALUES (?,?,?,?,?,?)");
	    stCheck = Conexion.prepareStatement("SELECT * FROM usuariostable WHERE usuario=?");
	    stDelete = Conexion.prepareStatement("DELETE FROM usuariostable WHERE nombre=?");
	    stUpdate = Conexion.prepareStatement("UPDATE usuariostable SET usuario=?, clave=? WHERE nombre=?");

	}
	
	public void PrepareClientes() throws Exception {
		Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltv-database","root","");
		stInsert = Conexion.prepareStatement("INSERT INTO clientestable VALUES (?,?,?,?)");
	    stCheck = Conexion.prepareStatement("SELECT * FROM clientestable WHERE nombre=?");
	    stDelete = Conexion.prepareStatement("DELETE FROM clientestable WHERE nombre=?");
	    stUpdate = Conexion.prepareStatement("UPDATE clientestable SET telefono=?, email=? WHERE nombre=?");

	}
	
	public void CloseDataBase() {
	      try {
	        Conexion.close();
	      } catch (SQLException ex) {
	          
	         System.out.println("Error al cerrar la Conexion a la BD");
	         System.out.println(ex.getMessage());
	          
	      }
	    }
	
	//////////// SOLICITUDES \\\\\\\\ \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public SolicitudesTable CheckSolicitudes(String Cliente) {
		SolicitudesTable Solicitud = null;
		try {
			
			stCheck.setString(1,Cliente);
			ResultSet miResulset = stCheck.executeQuery();
			
			while(miResulset.next()) {
				if(Cliente.equals(miResulset.getString("cliente"))) {
					Solicitud = new SolicitudesTable(miResulset.getString("fecha"), miResulset.getString("cliente"),
							miResulset.getString("solicitud"), miResulset.getString("estatus"), miResulset.getString("usuario"));
					break;}
			}
			miResulset.close();
			return Solicitud;
			
		}catch(SQLException ex) {System.out.println("Error al consultar solicitud");
	         System.out.println(ex.getMessage()); return null;}
		
	}
	
	public void UpdateSolicitudes(String Cliente) {
		try {
			SolicitudesTable Solicitud = new SolicitudesTable();
			stUpdate.setString(3, Cliente);
			stUpdate.setString(1, Solicitud.getUSUARIO());
			stUpdate.setString(2, Solicitud.getESTATUS());
			stUpdate.executeQuery();
		}catch(SQLException ex) {System.out.println("Error al actualizar solicitud");
        System.out.println(ex.getMessage());}
		
	}
	
	public void DeleteSolicitudes(String Cliente) {
		try {
			SolicitudesTable Solicitud = new SolicitudesTable();
			stDelete.setString(1, Cliente);
			stDelete.executeQuery();
			
		}catch(SQLException ex) {System.out.println("Error al eliminar solicitud");
        System.out.println(ex.getMessage());}
	}
	
	public void InsertSolicitudes() {
		try {
			SolicitudesTable Solicitud = new SolicitudesTable();
			stInsert.setString(1, Solicitud.getFECHA());
			stInsert.setString(2, Solicitud.getCLIENTE());
			stInsert.setString(3, Solicitud.getSOLICITUD());
			stInsert.setString(4, Solicitud.getESTATUS());
			stInsert.setString(5, Solicitud.getUSUARIO());
			stInsert.executeQuery();
		}catch(SQLException ex) {System.out.println("Error al ingresar solicitud");
        System.out.println(ex.getMessage());}
	}
	
	
	//////////// USUARIOS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void CheckUsuarios() {
		
	}
	
	public void UpdateUsuarios() {
		
	}
	
	public void DeleteUsuarios() {
		
	}
	
	public void InsertUsuarios() {
		
	}
	
	
	//////////// CLIENTES \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void CheckClientes() {
		
	}
	
	public void UpdateClientes() {
		
	}
	
	public void DeleteClientes() {
		
	}
	
	public void InsertClientes() {
		
	}
	
}//end class
