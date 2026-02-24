package lib;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
// Nota: Asegúrate de tener la librería jbcrypt en tu proyecto para usar esta clase
import org.mindrot.jbcrypt.BCrypt;

public class SqlLib {

    private static SqlLib instance;
    private Connection connection;
    private final String url;
    private String username;
    private String password;

    public SqlLib(String url, String username, String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        connect();
    }

    private void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión a Biblioteca establecida.");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    public static SqlLib getInstance(String url, String username, String password) throws SQLException {
        if (instance == null) {
            instance = new SqlLib(url, username, password);
        }
        return instance;
    }

    /* --- GESTIÓN DE PERSONAS --- */
    public boolean altaPersona(String nombre, String apP, String apM, String tel, String correo) {
        String query = "{ CALL sp_AltaPersona(?, ?, ?, ?, ?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apP);
            statement.setString(3, apM);
            statement.setString(4, tel);
            statement.setString(5, correo);
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en Alta Persona: " + e.getMessage());
            return false;
        }
    }

    public boolean bajaPersona(int idPersona) {
        String query = "{ CALL sp_BajaPersona(?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setInt(1, idPersona);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /* --- GESTIÓN DE LIBROS --- */
    public boolean altaLibro(String isbn, String titulo, String edicion, String anio, String formato, int paginas) {
        String query = "{ CALL sp_AltaLibro(?, ?, ?, ?, ?, ?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setString(1, isbn);
            statement.setString(2, titulo);
            statement.setString(3, edicion);
            statement.setString(4, anio); // Formato YYYY-MM-DD
            statement.setString(5, formato);
            statement.setInt(6, paginas);
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en Alta Libro: " + e.getMessage());
            return false;
        }
    }

    public boolean bajaLibro(String isbn) {
        String query = "{ CALL sp_BajaLibro(?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setString(1, isbn);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /* --- GESTIÓN DE PRÉSTAMOS --- */
    public boolean altaPrestamo(String fPrestamo, String fDevolucion, int idPersona, String isbn) {
        String query = "{ CALL sp_AltaPrestamo(?, ?, ?, ?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setString(1, fPrestamo);
            statement.setString(2, fDevolucion);
            statement.setInt(3, idPersona);
            statement.setString(4, isbn);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // MÉTODO PARA CREAR USUARIO (Registro)
    public boolean createUser(String username, String password, String role) {
        // Encriptamos la contraseña antes de mandarla a la BD
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        String query = "{ CALL sp_AltaUsuario(?, ?, ?) }";
        try (PreparedStatement statement = connection.prepareCall(query)) {
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, role);
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            return false;
        }
    }

    // MÉTODO PARA VALIDAR (Login)
    public boolean isValidCredentials(String username, String password) throws SQLException {
        String query = "SELECT contrasena FROM usuario WHERE nombre = ? AND is_deleted = 0";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("contrasena");
                // Compara la clave de la pantalla con la de la BD
                return BCrypt.checkpw(password, storedHash);
            }
        }
        return false;
    }

    /* --- CONSULTAS DE DATOS (LECTURA) --- */
    public List<String[]> cargarLibros() {
        List<String[]> lista = new ArrayList<>();
        String query = "SELECT ISBN, titulo, edicion, año, formato FROM libro";
        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                String[] fila = new String[5];
                fila[0] = rs.getString("ISBN");
                fila[1] = rs.getString("titulo");
                fila[2] = rs.getString("edicion");
                fila[3] = rs.getString("año");
                fila[4] = rs.getString("formato");
                lista.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar libros: " + e.getMessage());
        }
        return lista;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

}
