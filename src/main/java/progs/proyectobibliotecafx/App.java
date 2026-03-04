package progs.proyectobibliotecafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import lib.SqlLib;
import java.sql.SQLException;

public class App extends Application {
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. Carga el archivo FXML de del login

        Font.loadFont(getClass().getResourceAsStream("/fonts/LEMONMILK-Regular.otf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/fonts/KGPerfectPenmanship.otf"), 14);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = loader.load();

        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

        //Conexión a sql
        try {           
            lib.SqlLib.getInstance("jdbc:mysql://localhost:3306/biblioteca", "root", "Gatitos1510");
            System.out.println(">>> DEBUG: Llamando a SqlLib desde el arranque de App");
        } catch (Exception e) {
            System.err.println(">>> ERROR: Falló la conexión inicial: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args); // Esto arranca la aplicación JavaFX
    }
    
}
