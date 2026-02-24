module progs.proyectobibliotecafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens progs.proyectobibliotecafx.controller to javafx.fxml;
    exports progs.proyectobibliotecafx;
}
