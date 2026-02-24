
package progs.proyectobibliotecafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML Button btn_crearcuenta ;

    @FXML
    private void handleLogin(ActionEvent event) {
        
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        // Validación básica estática
        if (user.equals("admin") && pass.equals("123")) {
            System.out.println("¡Bienvenido!");

        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
    
    @FXML
    private void handleCrearCuenta (ActionEvent event){
        try {
        // 1. Cargar el nuevo archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CrearCuenta.fxml"));
        Parent root = loader.load();

        // 2. Obtener el Stage (la ventana) actual desde el botón que se presionó
        Stage stage = (Stage) btn_crearcuenta.getScene().getWindow();

        // 3. Crear la nueva escena y mostrarla
        Scene scene = new Scene(root);
        
        // OPCIONAL: Volver a cargar el CSS y las fuentes si es necesario
        scene.getStylesheets().add(getClass().getResource("/fonts/fuentes.css").toExternalForm());
        
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
