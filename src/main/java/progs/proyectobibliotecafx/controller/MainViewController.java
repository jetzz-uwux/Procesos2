package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewController {

    @FXML
    private TableView<Object> tablaLibros;

    @FXML
    private TableColumn<Object, String> colIsbn;

    @FXML
    private TableColumn<Object, String> colTitulo;

    @FXML
    private TableColumn<Object, String> colEdicion;

    @FXML
    private TableColumn<Object, String> colAnio;

    @FXML
    private TableColumn<Object, String> colFormato;

    @FXML
    private TableColumn<Object, String> colPaginas;

    @FXML
    private TextField txtBuscar;

    @FXML
    public void initialize() {
        // Datos de prueba para que la tabla no esté vacía
        ObservableList<Object> datos = FXCollections.observableArrayList();
        tablaLibros.setItems(datos);
    }

    @FXML
    private void handleBuscar() {
        System.out.println("Buscar: " + txtBuscar.getText());
    }

    @FXML
    private void handleNuevo() {
        System.out.println("Nuevo libro");
    }

    @FXML
    private void handleEditar() {
        System.out.println("Editar libro");
    }

    @FXML
    private void handleEliminar() {
        System.out.println("Eliminar libro");
    }

    @FXML
    private void handlePrestar() {
        System.out.println("Prestar libro");
    }

    @FXML
    private void handleSocios() {
        System.out.println("Abrir socios");
    }

    @FXML
    private void handlePrestamos() {
        System.out.println("Abrir préstamos");
    }

    @FXML
    private void handleReportes() {
        System.out.println("Abrir reportes");
    }
}