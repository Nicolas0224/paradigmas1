package co.edu.poli.contexto1.controlador;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;
 
/**
 * Controlador del menú principal.
 * Maneja la navegación entre las distintas ventanas del sistema.
 * Cada botón abre una nueva ventana (Stage) con su propio FXML.
 */
public class MenuPrincipalController {
 
    // Instancia compartida del CRUD — se pasa a cada ventana que se abre
    // para que todas trabajen sobre el mismo arreglo de usuarios
    private static ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
 
    /**
     * Retorna la instancia compartida del CRUD.
     * Los demás controladores llaman este método para obtener la misma instancia.
     */
    public static ImplementacionOperacionCRUD getCrud() {
        return crud;
    }
 
    /**
     * Abre la ventana de Gestión de Usuario (Crear, Buscar, Modificar, Eliminar).
     * Se llama cuando el usuario hace clic en "Gestión Usuario".
     */
    @FXML
    private void abrirGestion() {
        abrirVentana("GestionUsuario.fxml", "Gestión de Usuario");
    }
 
    /**
     * Abre la ventana de Consultar Todos los usuarios.
     * Se llama cuando el usuario hace clic en "Consultar Todos".
     */
    @FXML
    private void abrirConsultarTodos() {
        abrirVentana("ConsultarTodos.fxml", "Consultar Todos los Usuarios");
    }
 
    /**
     * Abre la ventana de Serialización.
     * Se llama cuando el usuario hace clic en "Serializar".
     */
    @FXML
    private void abrirSerializar() {
        abrirVentana("Serializacion.fxml", "Serialización");
    }
 
 
    /**
     * Cierra la aplicación completa.
     * Se llama cuando el usuario hace clic en "Salir".
     */
    @FXML
    private void salir() {
        System.exit(0);
    }
 
    /**
     * Método auxiliar que abre una nueva ventana dado un archivo FXML y un título.
     * La ventana se abre en modo APPLICATION_MODAL (bloquea el menú mientras está abierta).
     *
     * @param fxml   Nombre del archivo FXML a cargar.
     * @param titulo Título que aparece en la barra de la ventana.
     */
    private void abrirVentana(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            // APPLICATION_MODAL hace que el menú quede bloqueado mientras la ventana está abierta
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error al abrir la ventana " + fxml + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}