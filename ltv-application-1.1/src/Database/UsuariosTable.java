package Database;

public class UsuariosTable {

	private String NOMBRE;
	private String EMAIL;
	private char CARGO;
	private String USUARIO;
	private String CLAVE;
	private boolean DISPONIBLE;
	
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public char getCARGO() {
		return CARGO;
	}
	public void setCARGO(char cARGO) {
		CARGO = cARGO;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getCLAVE() {
		return CLAVE;
	}
	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}
	public boolean isDISPONIBLE() {
		return DISPONIBLE;
	}
	public void setDISPONIBLE(boolean dISPONIBLE) {
		DISPONIBLE = dISPONIBLE;
	}
	
	
}
