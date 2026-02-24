package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LibroDialogController {

    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtEdicion;
    @FXML private TextField txtAnio;
    @FXML private TextField txtPaginas;
    @FXML private TextField txtUbicacion;
    @FXML private ComboBox<String> cmbFormato;

    private boolean esNuevoLibro = true;

    @FXML
    public void initialize() {
        cmbFormato.getItems().addAll("Físico", "Digital", "Mixto");
        cmbFormato.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleAceptar() {

        if (!validarCampos()) {
            return;
        }

        System.out.println("Libro guardado correctamente");
        cerrarVentana();
    }

    @FXML
    private void handleCancelar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar cancelación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de cancelar?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                cerrarVentana();
            }
        });
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtTitulo.getScene().getWindow();
        stage.close();
    }

    private boolean validarCampos() {

        if (txtIsbn.getText().trim().isEmpty()) {
            mostrarError("El ISBN es obligatorio", txtIsbn);
            return false;
        }

        if (!txtIsbn.getText().matches("\\d{13}")) {
            mostrarError("El ISBN debe tener 13 dígitos", txtIsbn);
            return false;
        }

        if (txtTitulo.getText().trim().isEmpty()) {
            mostrarError("El título es obligatorio", txtTitulo);
            return false;
        }

        if (txtEdicion.getText().trim().isEmpty()) {
            mostrarError("La edición es obligatoria", txtEdicion);
            return false;
        }

        try {
            int paginas = Integer.parseInt(txtPaginas.getText().trim());
            if (paginas <= 0) {
                mostrarError("Las páginas deben ser mayor a 0", txtPaginas);
                return false;
            }
        } catch (Exception e) {
            mostrarError("Ingrese un número válido en páginas", txtPaginas);
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje, TextField campo) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();

        campo.requestFocus();
        campo.selectAll();
    }
}