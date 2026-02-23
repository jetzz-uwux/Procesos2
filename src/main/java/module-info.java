module progs.proyectobibliotecafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens progs.proyectobibliotecafx to javafx.fxml;
    exports progs.proyectobibliotecafx;
}
