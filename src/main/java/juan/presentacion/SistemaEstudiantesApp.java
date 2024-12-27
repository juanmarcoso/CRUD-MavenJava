package juan.presentacion;

// Importar clases necesarias
import java.util.Scanner;

// Importar clases de la capa de datos y dominio
import juan.datos.EstudianteDAO;
import juan.dominio.Estudiante;

/**
 * Clase principal de la aplicación que maneja la interacción con el usuario.
 */
public class SistemaEstudiantesApp {

    /**
     * Método principal de la aplicación.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Variable para controlar la salida del programa
        var salir = false;

        // Crear un objeto Scanner para leer la entrada del usuario
        var teclado = new Scanner(System.in);

        // Crear una instancia de la clase EstudianteDAO para interactuar con la base de
        // datos
        var estudianteDao = new EstudianteDAO();

        // Ciclo principal del programa
        while (!salir) {

            try {
                // Mostrar el menú de opciones al usuario
                mostrarMenu();

                // Ejecutar la opción seleccionada por el usuario
                salir = ejecutarOpciones(teclado, estudianteDao);

            } catch (Exception e) {
                // Manejar cualquier excepción que se produzca durante la ejecución del programa
                System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
            }

            // Imprimir una línea en blanco para separar las diferentes iteraciones del
            // ciclo
            System.out.println(" ");
        } // fin del ciclo while
    }

    /**
     * Método que muestra el menú de opciones al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("""
                *** Sistema de estudiantes ***
                1. Listar Estudiantes
                2. Buscar Estudiante por ID
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir

                Elige una opción
                """);
    }

    /**
     * Método que ejecuta la opción seleccionada por el usuario.
     * 
     * @param teclado       Objeto Scanner para leer la entrada del usuario.
     * @param estudianteDAO Instancia de la clase EstudianteDAO para interactuar con
     *                      la base de datos.
     * @return Verdadero si el usuario seleccionó la opción de salir, falso en caso
     *         contrario.
     */
    private static boolean ejecutarOpciones(Scanner teclado, EstudianteDAO estudianteDAO) {

        // Leer la opción seleccionada por el usuario
        var opcion = Integer.parseInt(teclado.nextLine());

        // Variable para controlar la salida del programa
        var salir = false;

        // Ejecutar la opción seleccionada por el usuario
        switch (opcion) {
            case 1: { // Listar estudiantes
                System.out.println("Listado de Estudiantes");
                var estudiantes = estudianteDAO.listarEstudiantes();

                // Utilizar una función lambda para imprimir cada estudiante
                estudiantes.forEach(System.out::println);

                break;
            }

            case 2: { // Buscar estudiante por ID
                System.out.println("Introduce el ID del estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(teclado.nextLine());

                // Crear un objeto Estudiante con el ID proporcionado
                var estudiante = new Estudiante(idEstudiante);

                // Buscar el estudiante en la base de datos
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);

                if (encontrado) {
                    System.out.println("Estudiante encontrado: " + estudiante);
                } else {
                    System.out.println("Estudiante NO encontrado: " + estudiante);
                }

                break;
            }

            // Opción para agregar un nuevo estudiante
            case 3: {
                // Mostrar mensaje para indicar la acción a realizar
                System.out.println("Agregar estudiante: ");

                // Leer los datos del estudiante a agregar
                System.out.print("Nombre: ");
                var nombre = teclado.nextLine(); // Leer el nombre del estudiante
                System.out.print("Apellido: ");
                var apellido = teclado.nextLine(); // Leer el apellido del estudiante
                System.out.print("Teléfono: ");
                var telefono = teclado.nextLine(); // Leer el teléfono del estudiante
                System.out.print("Email: ");
                var email = teclado.nextLine(); // Leer el email del estudiante

                // Crear un objeto Estudiante con los datos proporcionados
                var estudiante = new Estudiante(nombre, apellido, telefono, email);

                // Agregar el estudiante a la base de datos
                var agregado = estudianteDAO.agregarEstudiante(estudiante);

                // Mostrar mensaje según el resultado de la operación
                if (agregado) {
                    System.out.println("Estudiante agregado: " + estudiante);
                } else {
                    System.out.println("Estudiante NO agregado: " + estudiante);
                }

                break;
            }

            // Opción para modificar un estudiante existente
            case 4: {
                // Mostrar mensaje para indicar la acción a realizar
                System.out.println("Modificar estudiante: ");

                // Leer el ID del estudiante a modificar
                System.out.println("Id estudiante: ");
                var idEstudiante = Integer.parseInt(teclado.nextLine()); // Leer el ID del estudiante

                // Leer los nuevos datos del estudiante
                System.out.print("Nombre: ");
                var nombre = teclado.nextLine(); // Leer el nuevo nombre del estudiante
                System.out.print("Apellido: ");
                var apellido = teclado.nextLine(); // Leer el nuevo apellido del estudiante
                System.out.print("Teléfono: ");
                var telefono = teclado.nextLine(); // Leer el nuevo teléfono del estudiante
                System.out.print("Email: ");
                var email = teclado.nextLine(); // Leer el nuevo email del estudiante

                // Crear un objeto Estudiante con los datos actualizados
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);

                // Modificar el estudiante en la base de datos
                var modificado = estudianteDAO.modificarEstudiante(estudiante);

                // Mostrar mensaje según el resultado de la operación
                if (modificado) {
                    System.out.println("Se modificó con éxito el registro: " + estudiante);
                } else {
                    System.out.println("No se pudo modificar el registro: " + estudiante);
                }

                break;
            }

            // Opción para eliminar un estudiante existente
            case 5: {
                // Mostrar mensaje para indicar la acción a realizar
                System.out.println("Eliminar estudiante: ");

                // Leer el ID del estudiante a eliminar
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(teclado.nextLine()); // Leer el ID del estudiante

                // Crear un objeto Estudiante con el ID proporcionado
                var estudiante = new Estudiante(idEstudiante);

                // Eliminar el estudiante de la base de datos
                var eliminado = estudianteDAO.eliminarRegistro(estudiante);

                // Mostrar mensaje según el resultado de la operación
                if (eliminado) {
                    System.out.println("Se eliminó el registro con éxito: " + estudiante);
                } else {
                    System.out.println("No se pudo eliminar el registro: " + estudiante);
                }

                break;
            }

            // Opción para salir del programa
            case 6: {
                // Mostrar mensaje de despedida
                System.out.println("Hasta pronto! ");
                salir = true; // Indicar que se debe salir del programa
                break;
            }

            // Opción no reconocida
            default: {
                // Mostrar mensaje de error
                System.out.println("Opción no reconocida");
            }
                break;
        }

        // Retornar el valor de la variable salir
        return salir;
    }
}
