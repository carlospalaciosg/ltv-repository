package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	///////////////////////////////////////////////////////////////////////////
	// Methods ////////////////////////////////////////////////////////////////
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("InicioScene.fxml"));
		primaryStage.setTitle("La Tienda del Viaje");
		primaryStage.setScene(new Scene(root, 300, 450));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void changeScene(String newFXML) throws Exception {
		Stage stage = new Stage();
		Parent pane = FXMLLoader.load(getClass().getResource(newFXML));
		stage.setTitle("La Tienda del Viaje");
		stage.setScene(new Scene(pane));
		stage.setResizable(false);
		stage.setHeight(600);
		stage.setWidth(900);
		stage.show();
	}

	public void addScene(String addFXML) throws Exception {
		Stage stage = new Stage();
		Parent pane = FXMLLoader.load(getClass().getResource(addFXML));
		stage.setTitle("La Tienda del Viaje");
		stage.setScene(new Scene(pane));
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}

	public static void main(String[] args) { launch(args); }

}