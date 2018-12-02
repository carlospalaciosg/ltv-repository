package Application;

import Database.SolicitudesTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReservacionesController extends SolicitudesTable {

	///////////////////////////////////////////////////////////////////////////
	// Attributes /////////////////////////////////////////////////////////////
	public DatePicker txtFecha;
	public TextField  txtNombre;
	public TextField  txtCorreo;
	public TextArea   txtComentarios;
	public TextField  txtTelefono;
	public TextField  txtDestino;	
	public Button     btnRegistrar;
	public Button     btnNuevo;
	public Main objMain = new Main();
	public ListView<String> reservacionesList;
	public ObservableList<String> solicitudes = FXCollections.observableArrayList();

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void vdRegistrar () {
		setFECHA(String.valueOf(txtFecha.getValue()));
		setNOMBRE(txtNombre.getText());
		setCORREO(txtCorreo.getText());
		setTELEFONO(txtTelefono.getText());
		setDESTINO(txtDestino.getText());
		setCOMENTARIOS(txtComentarios.getText());
		setAGENTE("Sin asignar");
		setSTATUS('P');
		regSolicitud();
	}

	public void vdBorrar () {
		txtNombre.setText("");
		txtCorreo.setText("");
		txtComentarios.setText("");
		txtTelefono.setText("");
		txtDestino.setText("");
	}

	public void vdCapturaTab () {
		
		verSolicitud("Sin asignar");		
		solicitudes.add(getNOMBRE() + " - " + getDESTINO());
		reservacionesList.setItems(solicitudes);
	}
}
