// Paquete donde se encuentra la clase Conexion
package juan.conexion;

// Importar clases necesarias para el manejo de bases de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión a la base de datos.
 */
public class Conexion {

    /**
     * Método que establece la conexión a la base de datos.
     * @return Objeto Connection que representa la conexión a la base de datos.
     */
    public static Connection getConexion() {

        // Declarar variable para almacenar la conexión
        Connection conexion = null;

        // Configuración de la base de datos
        // String baseDatos = "estudiante_db"; // Nombre de la base de datos
        String url = "jdbc:mysql://localhost:3306/estudiante_db"; // URL de la base de datos

        // Credenciales para acceder a la base de datos
        String usuario = "root"; // Usuario para acceder a la base de datos
        String password = "12345678"; // Contraseña para acceder a la base de datos

        // Driver JDBC para MySQL
        String driver = "com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC

        try {
            // Cargar la clase del driver JDBC en memoria
            Class.forName(driver);

            // Establecer la conexión a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException | SQLException e) {
            // Manejar cualquier excepción que se produzca durante la conexión
            System.out.println("Ocurrió un error en la conexión: " + e.getMessage());
        }

        // Retornar la conexión establecida
        return conexion;
    }
}