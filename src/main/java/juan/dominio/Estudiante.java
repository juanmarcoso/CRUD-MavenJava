// Paquete donde se encuentra la clase Estudiante
package juan.dominio;

/**
 * Clase que representa un estudiante con sus atributos y métodos correspondientes.
 */
public class Estudiante {

    // Atributos de la clase Estudiante
    private int idEstudiante; // Identificador único del estudiante
    private String nombre; // Nombre del estudiante
    private String apellido; // Apellido del estudiante
    private String telefono; // Teléfono del estudiante
    private String email; // Correo electrónico del estudiante

    /**
     * Constructor vacío para crear un objeto Estudiante sin inicializar sus atributos.
     */
    public Estudiante() {}

    /**
     * Constructor que inicializa el atributo idEstudiante.
     * @param idEstudiante Identificador único del estudiante.
     */
    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * Constructor que inicializa los atributos nombre, apellido, telefono y email.
     * @param nombre Nombre del estudiante.
     * @param apellido Apellido del estudiante.
     * @param telefono Teléfono del estudiante.
     * @param email Correo electrónico del estudiante.
     */
    public Estudiante(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Estudiante.
     * @param idEstudiante Identificador único del estudiante.
     * @param nombre Nombre del estudiante.
     * @param apellido Apellido del estudiante.
     * @param telefono Teléfono del estudiante.
     * @param email Correo electrónico del estudiante.
     */
    public Estudiante(int idEstudiante, String nombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase Estudiante

    /**
     * Obtiene el identificador único del estudiante.
     * @return Identificador único del estudiante.
     */
    public int getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * Establece el identificador único del estudiante.
     * @param idEstudiante Identificador único del estudiante.
     */
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * Obtiene el nombre del estudiante.
     * @return Nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     * @param nombre Nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     * @return Apellido del estudiante.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante.
     * @param apellido Apellido del estudiante.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono del estudiante.
     * @return Teléfono del estudiante.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del estudiante.
     * @param telefono Teléfono del estudiante.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del estudiante.
     * @return Correo electrónico del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del estudiante.
     * @param email Correo electrónico del estudiante.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna una representación en cadena del objeto Estudiante.
     * @return Representación en cadena del objeto Estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante: IdEstudiante = " + idEstudiante + ", Nombre = " + nombre + ", Apellido = " + apellido
                + ", Telefono = " + telefono + ", Email = " + email;
    }
}
