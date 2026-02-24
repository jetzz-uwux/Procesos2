/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progs.proyectobibliotecafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 *
 * @author Jetzaly
 */
public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;


    @FXML
    private void handleLogin(ActionEvent event) {
        
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        // Validación básica estática
        if (user.equals("admin") && pass.equals("123")) {
            System.out.println("¡Bienvenido!");
            // Aquí puedes cargar la siguiente ventana usando FXMLLoader
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }

}
