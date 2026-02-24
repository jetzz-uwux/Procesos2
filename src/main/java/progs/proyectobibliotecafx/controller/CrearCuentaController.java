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
import java.util.Optional;

public class CrearCuentaController {

    @FXML
    private TextField txtUsuarioNuevo;
    @FXML
    private Button btn_atras;
    @FXML
    private PasswordField txt_passwordnueva;

    @FXML
    private void handleCrear(ActionEvent event) {
        String user = txtUsuarioNuevo.getText();
        String pass = txt_passwordnueva.getText();

        // 1. Validación de campos vacíos
        if (user.isEmpty() || pass.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, llena todos los campos.", Alert.AlertType.WARNING);
            return;
        }

        try {
            SqlLib db = SqlLib.getInstance(null, null, null);

            //Método que encripta con BCrypt
            boolean creado = db.createUser(user, pass, "usuario");

            if (creado) {
                mostrarAlerta("Éxito", "Usuario '" + user + "' creado correctamente.", Alert.AlertType.INFORMATION);
                //Mandar al usuario de regreso al Login tras crear su cuenta
                handleAtras(event);
            } else {
                mostrarAlerta("Error", "No se pudo crear el usuario. Quizás el nombre ya existe.", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            mostrarAlerta("Error Fatal", "Error al conectar con la base de datos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void handleAtras(ActionEvent event) {
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
