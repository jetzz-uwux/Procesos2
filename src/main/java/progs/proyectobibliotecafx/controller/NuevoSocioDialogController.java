package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NuevoSocioDialogController {

    @FXML
    private TextField txtNoSocio;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefono;

    @FXML
    private void handleAceptar() {
        System.out.println("Aceptar presionado");
        cerrarVentana();
    }

    @FXML
    private void handleCancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}