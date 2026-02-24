package progs.proyectobibliotecafx.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lib.SqlLib;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    Button btn_crearcuenta;
    @FXML Button btn_iniciarsesion;

    @FXML
    private void handleLogin(ActionEvent event) {
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        try {
            // 1. Obtener la instancia de la base de datos
            SqlLib db = SqlLib.getInstance(null, null, null);

            // 2. USAR TU MÉTODO DE LA BASE DE DATOS
            if (db.isValidCredentials(user, pass)) {
                System.out.println("¡Login exitoso desde la BD!");

                // Aquí podrías cargar la ventana principal después del éxito
                // loadMainApp(); 
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
                Parent root = loader.load();

                // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
                Stage stage = (Stage) btn_iniciarsesion.getScene().getWindow();

                // 3. Crear la nueva escena y mostrarla
                Scene scene = new Scene(root);

                // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
                scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());

                stage.setScene(scene);
                stage.show();
            } else {
                // Si la base de datos dice que no coinciden
                mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
            }
            
            
        } catch (SQLException e) {
            mostrarAlerta("Error de Conexión", "No se pudo consultar la base de datos.");
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método de apoyo para mostrar mensajes de error en pantalla
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void handleCrearCuenta(ActionEvent event) {
        try {
            // 1. Cargar el nuevo archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CrearCuenta.fxml"));
            Parent root = loader.load();

            // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
            Stage stage = (Stage) btn_crearcuenta.getScene().getWindow();

            // 3. Crear la nueva escena y mostrarla
            Scene scene = new Scene(root);

            // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
            scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
