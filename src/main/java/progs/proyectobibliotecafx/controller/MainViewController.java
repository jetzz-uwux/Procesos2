package progs.proyectobibliotecafx.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    private Button btn_reportes;
    
    @FXML
    private Button btn_prestamo;
    
    @FXML
    private Button btn_socios;

    @FXML
    private Button btn_buscar;
    
    @FXML
    private Button btn_prestar;
    
    @FXML
    private Button btn_nuevo;
    
    @FXML
    private Button btn_editar;
    
    @FXML
    private Button btn_eliminar;
    
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
    private void handleNuevo(){
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
        try {
        // 1. Cargar el nuevo archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PrestamoDialog.fxml"));
        Parent root = loader.load();

        // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
        Stage stage = (Stage) btn_reportes.getScene().getWindow();

        // 3. Crear la nueva escena y mostrarla
        Scene scene = new Scene(root);
        
        // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        System.out.println("Abrir socios");
    }

    @FXML
    private void handlePrestamos() {
        try {
        // 1. Cargar el nuevo archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PrestamoDialog.fxml"));
        Parent root = loader.load();

        // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
        Stage stage = (Stage) btn_reportes.getScene().getWindow();

        // 3. Crear la nueva escena y mostrarla
        Scene scene = new Scene(root);
        
        // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        System.out.println("Abrir préstamos");
    }

    @FXML
    private void handleReportes() {
        try {
        // 1. Cargar el nuevo archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReporteDialog.fxml"));
        Parent root = loader.load();

        // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
        Stage stage = (Stage) btn_reportes.getScene().getWindow();

        // 3. Crear la nueva escena y mostrarla
        Scene scene = new Scene(root);
        
        // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        System.out.println("Abrir reportes");
    }
}