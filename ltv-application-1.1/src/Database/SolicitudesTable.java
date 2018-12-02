package Database;

public class SolicitudesTable extends DriverSQL {

	///////////////////////////////////////////////////////////////////////////
	// Attributes /////////////////////////////////////////////////////////////
	private String FECHA;
	private String NOMBRE;
	private String CORREO;
	private String TELEFONO;
	private String DESTINO;
	private String COMENTARIOS;
	private String AGENTE;
	private char   STATUS;

	///////////////////////////////////////////////////////////////////////////
	// Getters and Setters ////////////////////////////////////////////////////
	public String getFECHA() {return FECHA; }
	public void setFECHA(String fECHA) { FECHA = fECHA; }
	public String getNOMBRE() { return NOMBRE; }
	public void setNOMBRE(String nOMBRE) { NOMBRE = nOMBRE; }
	public String getCORREO() { return CORREO; }
	public void setCORREO(String cORREO) { CORREO = cORREO; }
	public String getTELEFONO() { return TELEFONO; }
	public void setTELEFONO(String tELEFONO) { TELEFONO = tELEFONO; }
	public String getDESTINO() { return DESTINO; }
	public void setDESTINO(String dESTINO) { DESTINO = dESTINO; }
	public String getCOMENTARIOS() { return COMENTARIOS; }
	public void setCOMENTARIOS(String cOMENTARIOS) { COMENTARIOS = cOMENTARIOS; }
	public String getAGENTE() { return AGENTE; }
	public void setAGENTE(String aGENTE) { AGENTE = aGENTE; }
	public char getSTATUS() { return STATUS; }
	public void setSTATUS(char sTATUS) { STATUS = sTATUS; }

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void regSolicitud () {
		String reg = "INSERT INTO solicitudestable (FECHA, NOMBRE, CORREO, TELEFONO, DESTINO, COMENTARIOS, AGENTE, STATUS) "
				+"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			sqlOpen();
			sqlPrepareStmt(reg);
				stmt . setString (1, getFECHA());
				stmt . setString (2, getNOMBRE());
				stmt . setString (3, getCORREO());
				stmt . setString (4, getTELEFONO());
				stmt . setString (5, getDESTINO());
				stmt . setString (6, getCOMENTARIOS());
				stmt . setString (7, getAGENTE());
				stmt . setString (8, Character.toString(getSTATUS()));
			sqlExeStmt();
			sqlClose();
			infMess("Registro correcto.");
		}catch (Exception e) {
			errMess(" Error al registrar en la base de datos.");
		}
	}

	public void verSolicitud (String Usuario) {
		try {
			sqlOpen();
			sqlCommand("SELECT * FROM solicitudestable");
			while(res.next()) {
				if(res.getString("AGENTE").equals(Usuario)) {
					setFECHA(res.getString("FECHA"));
					setNOMBRE(res.getString("NOMBRE"));
					setCORREO(res.getString("CORREO"));
					setTELEFONO(res.getString("CORREO"));
					setDESTINO(res.getString("DESTINO"));
					setCOMENTARIOS(res.getString("COMENTARIOS"));
					sqlClose();
					break;
				}
			}
		}catch(Exception e) {
			errMess(" Error al acceder a la base de datos.");
		}
	}

}
