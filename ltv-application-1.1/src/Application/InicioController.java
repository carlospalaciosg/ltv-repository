package Application;

import Database.UsuariosTable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InicioController extends UsuariosTable {

	///////////////////////////////////////////////////////////////////////////
	// Attributes /////////////////////////////////////////////////////////////
	public Button			btnInicio;
	public TextField		txtUsuario;
	public PasswordField	txtContrasena;
	public Main objMain = new Main();

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void vdInicio () {
		findUSUARIO(txtUsuario.getText());
		if(getCLAVE().equals(txtContrasena.getText())) {
			btnInicio.getScene().getWindow().hide();
			try {
				switch (getCARGO()) {
				case 'R': objMain.changeScene("ReservacionesScene.fxml");	break;
				case 'A': objMain.changeScene("AdministracionScene.fxml");	break;
				case 'C': objMain.changeScene("ContabilidadScene.fxml");	break;
				case 'D': objMain.changeScene("DireccionScene.fxml");		break;
				default: break;
				}
			}catch (Exception e) {
				errMess(" Error al iniciar sesión.");
			}
		}else {
			errMess(" Contraseña incorrecta.");
		}
	}

}
