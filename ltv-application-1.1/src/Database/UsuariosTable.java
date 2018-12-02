package Database;

public class UsuariosTable extends DriverSQL {

	///////////////////////////////////////////////////////////////////////////
	// Attributes /////////////////////////////////////////////////////////////
	private String  NOMBRE;
	private String  EMAIL;
	private char    CARGO;
	private String  USUARIO;
	private String  CLAVE;
	private Boolean DISPONIBLE;
	private Boolean INICIO;

	///////////////////////////////////////////////////////////////////////////
	// Getters and Setters ////////////////////////////////////////////////////
	public String getNOMBRE() { return NOMBRE; }
	public void setNOMBRE(String nOMBRE) { NOMBRE = nOMBRE; }
	public String getEMAIL() { return EMAIL; }
	public void setEMAIL(String eMAIL) { EMAIL = eMAIL; }
	public char getCARGO() { return CARGO; }
	public void setCARGO(char cARGO) { CARGO = cARGO; }
	public String getUSUARIO() { return USUARIO; }
	public void setUSUARIO(String uSUARIO) { USUARIO = uSUARIO; }
	public String getCLAVE() { return CLAVE; }
	public void setCLAVE(String cLAVE) { CLAVE = cLAVE; }
	public Boolean getDISPONIBLE() { return DISPONIBLE; }
	public void setDISPONIBLE(Boolean dISPONIBLE) { DISPONIBLE = dISPONIBLE; }
	public Boolean getINICIO() { return INICIO; }
	public void setINICIO(Boolean iNICIO) { INICIO = iNICIO; }

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void findUSUARIO(String uSUARIO) {
		Boolean found = false;
		setUSUARIO(uSUARIO);
		try {
			sqlOpen();
			sqlCommand("SELECT * FROM usuariostable");
			while(res.next() && (found==false)) {
				if(res.getString("USUARIO").equals(uSUARIO)) {
					found = true;
					setNOMBRE(res.getString("NOMBRE"));
					setEMAIL(res.getString("EMAIL"));
					setCARGO(res.getString("CARGO").charAt(0));
					setCLAVE(res.getString("CLAVE"));
					setDISPONIBLE(res.getBoolean("DISPONIBLE"));
					sqlClose();
				}
			}
			if(found==false) {
				errMess(" Usuario inválido.");
				sqlClose();
			}
		}catch (Exception e){
			errMess(" Error al conectar con la base de datos.");
		}
	}

}
