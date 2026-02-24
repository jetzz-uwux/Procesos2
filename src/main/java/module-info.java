module progs.proyectobibliotecafx {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires java.sql;     
    requires java.desktop;  
    requires jbcrypt;       

    opens progs.proyectobibliotecafx.controller to javafx.fxml;
    exports progs.proyectobibliotecafx;
}
