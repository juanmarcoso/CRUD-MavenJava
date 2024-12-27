// Paquete donde se encuentra la clase EstudianteDAO
package juan.datos;

// Importar clases necesarias para el manejo de bases de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Importar clases para el manejo de colecciones
import java.util.ArrayList;
import java.util.List;

// Importar clase para obtener la conexión a la base de datos
import static juan.conexion.Conexion.getConexion;

// Importar clase Estudiante para el manejo de objetos de este tipo
import juan.dominio.Estudiante;

/**
 * Clase que maneja el acceso a datos de la base de datos de estudiantes.
 * Implementa el patrón DAO (Data Access Object).
 */
public class EstudianteDAO {

    /**
     * Método que lista todos los estudiantes de la base de datos.
     * 
     * @return Lista de objetos Estudiante.
     */
    public List<Estudiante> listarEstudiantes() {

        // Crear una lista para almacenar los estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();

        // Declarar variables para el manejo de la base de datos
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion(); // Obtener la conexión a la base de datos

        // Sentencia SQL para seleccionar todos los estudiantes
        String sql = "SELECT * FROM estudiante ORDER BY idestudiante";

        try {
            // Preparar la sentencia SQL
            ps = con.prepareStatement(sql);

            // Ejecutar la sentencia SQL y obtener el resultado
            rs = ps.executeQuery();

            // Recorrer el resultado y crear objetos Estudiante
            while (rs.next()) {
                // Crear un objeto Estudiante
                var estudiante = new Estudiante();

                // Establecer los atributos del objeto Estudiante
                estudiante.setIdEstudiante(rs.getInt("idestudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                // Agregar el objeto Estudiante a la lista
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que se produzca durante la ejecución del método
            System.out.println("Ocurrió un error al seleccionar datos: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión a la base de datos
                con.close();
            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante el cierre de la conexión
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Retornar la lista de estudiantes
        return estudiantes;
    }

    /**
     * Método que busca un estudiante por su ID.
     * 
     * @param estudiante Objeto Estudiante con el ID a buscar.
     * @return Verdadero si el estudiante se encuentra en la base de datos, falso en
     *         caso contrario.
     */
    public boolean buscarEstudiantePorId(Estudiante estudiante) {

        // Declarar variables para el manejo de la base de datos
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion(); // Obtener la conexión a la base de datos

        // Sentencia SQL para seleccionar un estudiante por su ID
        String sql = "SELECT * FROM estudiante WHERE idestudiante = ?";

        try {
            // Preparar la sentencia SQL
            ps = con.prepareStatement(sql);

            // Establecer el parámetro de la sentencia SQL
            ps.setInt(1, estudiante.getIdEstudiante());

            // Ejecutar la sentencia SQL y obtener el resultado
            rs = ps.executeQuery();

            // Verificar si se encontró el estudiante
            if (rs.next()) {
                // Establecer los atributos del objeto Estudiante
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                // Retornar verdadero para indicar que se encontró el estudiante
                return true;
            }
        } catch (Exception e) {
            // Manejar cualquier excepción que se produzca durante la ejecución del método
            System.out.println("Ocurrió un error al buscar estudiante: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión a la base de datos
                con.close();
            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante el cierre de la conexión
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Retornar falso para indicar que no se encontró el estudiante
        return false;
    }

    /**
     * Método que agrega un nuevo estudiante a la base de datos.
     * 
     * @param estudiante Objeto Estudiante con los datos a agregar.
     * @return Verdadero si el estudiante se agrega correctamente, falso en caso
     *         contrario.
     */
    public boolean agregarEstudiante(Estudiante estudiante) {

        // Declarar variables para el manejo de la base de datos
        PreparedStatement ps;
        Connection con = getConexion(); // Obtener la conexión a la base de datos

        // Sentencia SQL para insertar un nuevo estudiante
        String sql = "INSERT INTO estudiante (nombre, apellido, telefono, email)" +
                "VALUES (?, ?, ?, ?)"; // Los '?' serán reemplazados por los valores del objeto Estudiante

        try {
            // Preparar la sentencia SQL
            ps = con.prepareStatement(sql);

            // Establecer los parámetros de la sentencia SQL
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());

            // Ejecutar la sentencia SQL para insertar el nuevo estudiante
            ps.execute(); // No se utiliza executeQuery() porque no se espera un resultado

            // Retornar verdadero para indicar que el estudiante se agregó correctamente
            return true;
        } catch (Exception e) {
            // Manejar cualquier excepción que se produzca durante la ejecución del método
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión a la base de datos
                con.close();
            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante el cierre de la conexión
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Retornar falso para indicar que el estudiante no se agregó correctamente
        return false;
    }

    /**
     * Método que modifica un estudiante existente en la base de datos.
     * 
     * @param estudiante Objeto Estudiante con los datos actualizados.
     * @return Verdadero si el estudiante se modifica correctamente, falso en caso
     *         contrario.
     */
    public boolean modificarEstudiante(Estudiante estudiante) {

        // Declarar variables para el manejo de la base de datos
        PreparedStatement ps;
        Connection con = getConexion(); // Obtener la conexión a la base de datos

        // Sentencia SQL para actualizar un estudiante
        String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE idestudiante = ?";

        try {
            // Preparar la sentencia SQL
            ps = con.prepareStatement(sql);

            // Establecer los parámetros de la sentencia SQL
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());

            // Ejecutar la sentencia SQL para actualizar el estudiante
            ps.execute(); // No se utiliza executeQuery() porque no se espera un resultado

            // Retornar verdadero para indicar que el estudiante se modificó correctamente
            return true;
        } catch (Exception e) {
            // Manejar cualquier excepción que se produzca durante la ejecución del método
            System.out.println("Error al modificar estudiante: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión a la base de datos
                con.close();
            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante el cierre de la conexión
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Retornar falso para indicar que el estudiante no se modificó correctamente
        return false;
    }

    /**
     * Método que elimina un estudiante de la base de datos.
     * 
     * @param estudiante Objeto Estudiante con el ID del estudiante a eliminar.
     * @return Verdadero si el estudiante se elimina correctamente, falso en caso
     *         contrario.
     */
    public boolean eliminarRegistro(Estudiante estudiante) {

        // Declarar variables para el manejo de la base de datos
        PreparedStatement ps;
        Connection con = getConexion(); // Obtener la conexión a la base de datos

        // Sentencia SQL para eliminar un estudiante
        String sql = "DELETE FROM estudiante WHERE idestudiante = ?";

        try {
            // Preparar la sentencia SQL
            ps = con.prepareStatement(sql);

            // Establecer el parámetro de la sentencia SQL
            ps.setInt(1, estudiante.getIdEstudiante());

            // Ejecutar la sentencia SQL para eliminar el estudiante
            ps.execute(); // No se utiliza executeQuery() porque no se espera un resultado

            // Retornar verdadero para indicar que el estudiante se eliminó correctamente
            return true;
        } catch (Exception e) {
            // Manejar cualquier excepción que se produzca durante la ejecución del método
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión a la base de datos
                con.close();
            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante el cierre de la conexión
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Retornar falso para indicar que el estudiante no se eliminó correctamente
        return false;
    }
}
