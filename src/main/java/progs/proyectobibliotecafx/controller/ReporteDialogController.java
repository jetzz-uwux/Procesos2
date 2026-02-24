package progs.proyectobibliotecafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class ReporteDialogController {

    @FXML private TextField txtAutor;
    @FXML private TextField txtUbicacion;
    @FXML private TextField txtFechaReporte;

    @FXML private TextArea areaAutor;
    @FXML private TextArea areaUbicacion;
    @FXML private TextArea areaPrestamos;
    @FXML private TextArea areaDisponibles;
    @FXML private TextArea areaFecha;
    @FXML private TextArea areaVencenHoy;

    @FXML
    public void initialize() {
        txtFechaReporte.setText(LocalDate.now().toString());
    }

    @FXML
    private void handleReporteAutor() {
        areaAutor.setText("Generar reporte por autor: " + txtAutor.getText());
    }

    @FXML
    private void handleReporteUbicacion() {
        areaUbicacion.setText("Generar reporte por ubicación: " + txtUbicacion.getText());
    }

    @FXML
    private void handleReportePrestamos() {
        areaPrestamos.setText("Mostrar libros actualmente en préstamo");
    }

    @FXML
    private void handleReporteDisponibles() {
        areaDisponibles.setText("Mostrar libros disponibles");
    }

    @FXML
    private void handleReporteFecha() {
        areaFecha.setText("Reporte por fecha: " + txtFechaReporte.getText());
    }

    @FXML
    private void handlePrestamosHoy() {
        areaVencenHoy.setText("Mostrar préstamos que vencen hoy");
    }
}