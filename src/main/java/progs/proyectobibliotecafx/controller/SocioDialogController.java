package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SocioDialogController {

    @FXML private TableView<Object> tablaSocios;

    @FXML private TableColumn<Object, Integer> colNoSocio;
    @FXML private TableColumn<Object, String> colNombre;
    @FXML private TableColumn<Object, String> colDireccion;
    @FXML private TableColumn<Object, String> colEmail;
    @FXML private TableColumn<Object, String> colTelefono;

    @FXML private TextField txtBuscar;

    @FXML
    public void initialize() {
        ObservableList<Object> datos = FXCollections.observableArrayList();
        tablaSocios.setItems(datos);
    }

    @FXML
    private void handleBuscar() {
        System.out.println("Buscar socio: " + txtBuscar.getText());
    }

    @FXML
    private void handleNuevo() {
        System.out.println("Nuevo socio");
    }

    @FXML
    private void handleEditar() {
        Object seleccionado = tablaSocios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección requerida");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione un socio para editar.");
            alert.showAndWait();
            return;
        }

        System.out.println("Editar socio");
    }

    @FXML
    private void handleEliminar() {
        Object seleccionado = tablaSocios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección requerida");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione un socio para eliminar.");
            alert.showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar eliminación");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Está seguro de eliminar el socio?");

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("Socio eliminado");
            }
        });
    }
}