package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DriverSQL {

	///////////////////////////////////////////////////////////////////////////
	// Attributes /////////////////////////////////////////////////////////////
	private static final String path = "jdbc:mysql://localhost:3306/ltv-database";
	private static final String user = "root";
	private static final String password = "";
	public Connection conn;
	public Statement  stat;
	public ResultSet  res;
	public PreparedStatement stmt;

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void errMess (String msg) { JOptionPane.showMessageDialog(new JFrame(), msg, " ¡Error!", JOptionPane.ERROR_MESSAGE); }
	public void infMess (String msg) { JOptionPane.showMessageDialog(new JFrame(), msg, " OK ", JOptionPane.INFORMATION_MESSAGE); }

	public void sqlOpen () throws Exception {
		try {
			conn = DriverManager.getConnection(path, user, password);
			stat = conn.createStatement();
		}catch (Exception e) { errMess(" Error al conectar con la base de datos."); }
	}

	public void sqlClose () throws Exception {
		try {
			conn.close();
		}catch (Exception e) { errMess(" Error al cerrar la base de datos."); }
	}

	public void sqlCommand (String cmd) throws Exception {
		try {
			res = stat.executeQuery(cmd);
		}catch (Exception e) { errMess(" Error al acceder a la base de datos."); }
	}

	public void sqlPrepareStmt (String query) throws Exception {
		try {
			stmt = conn.prepareStatement(query);
		}catch (Exception e) { errMess(" Error al registrar en la base de datos."); }
	}

	public void sqlExeStmt () throws Exception {
		try {
			stmt.execute();
		}catch (Exception e) { errMess(" Error al registrar en la base de datos."); }
	}
}
