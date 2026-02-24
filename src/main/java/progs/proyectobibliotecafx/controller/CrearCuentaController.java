package progs.proyectobibliotecafx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CrearCuentaController {
    
    @FXML private TextField txt_usuarionuevo;
    @FXML private Button btn_atras;
    @FXML private PasswordField txt_passwordnueva;
    
    @FXML
    private void handleCrear(ActionEvent event){
        
    }
    
    @FXML
    private void handleAtras(ActionEvent event){
        try {
            // Cargar el nuevo archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btn_atras.getScene().getWindow();

            // 3. Crear la nueva escena y mostrarla
            Scene scene = new Scene(root);

            scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());

            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
           e.printStackTrace();
        }   
    }
}
