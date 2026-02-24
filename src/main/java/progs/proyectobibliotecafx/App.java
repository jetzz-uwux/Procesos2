package progs.proyectobibliotecafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App extends Application {

    
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        // 1. Carga el archivo FXML de tu login
        // Asegúrate de que el nombre coincida exactamente con tu archivo .fxml
        
        Font.loadFont(getClass().getResourceAsStream("/fonts/LEMONMILK-Regular.otf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/fonts/KGPerfectPenmanship.otf"), 14);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = loader.load();
        
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Esto arranca la aplicación JavaFX
    }

}