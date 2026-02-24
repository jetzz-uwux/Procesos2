package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PrestamoDialogController {

    @FXML private TableView<Object> tablaPrestamos;

    @FXML private TableColumn<Object, Integer> colId;
    @FXML private TableColumn<Object, String> colLibro;
    @FXML private TableColumn<Object, String> colSocio;
    @FXML private TableColumn<Object, String> colFechaInicio;
    @FXML private TableColumn<Object, String> colFechaLimite;
    @FXML private TableColumn<Object, String> colFechaEntrega;
    @FXML private TableColumn<Object, String> colEstado;

    @FXML private TextField txtBuscar;

    @FXML
    public void initialize() {
        ObservableList<Object> datos = FXCollections.observableArrayList();
        tablaPrestamos.setItems(datos);
    }

    @FXML
    private void handleBuscar() {
        System.out.println("Buscar préstamo: " + txtBuscar.getText());
    }

    @FXML
    private void handleEntregado() {
        System.out.println("Marcar como entregado");
    }

    @FXML
    private void handleNoEntregado() {
        System.out.println("Marcar como no entregado");
    }

    @FXML
    private void handleActualizar() {
        txtBuscar.clear();
        System.out.println("Actualizar lista");
    }
}