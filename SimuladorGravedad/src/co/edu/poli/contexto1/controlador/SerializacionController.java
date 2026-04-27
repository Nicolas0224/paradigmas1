package co.edu.poli.contexto1.controlador;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto1.modelo.Usuario;

/**
 * Controlador de la ventana de Serialización / Deserialización.
 * Maneja el guardado y carga de usuarios desde un archivo binario.
 *
 * El archivo se guarda en la raíz del proyecto con el nombre "usuarios.bin"
 */
public class SerializacionController {

    @FXML private Button btnSerializar;
    @FXML private Button btnDeserializar;
    @FXML private Button btnVolver;

    // Label para mostrar mensajes de éxito o error al usuario
    @FXML private Label lblMensaje;

    // Ruta y nombre del archivo donde se guardan los usuarios
    // "" significa la carpeta raíz del proyecto en Eclipse
    private static final String PATH = "";
    private static final String NOMBRE_ARCHIVO = "usuarios.bin";

    // Instancia del CRUD compartida con el menú principal
    private ImplementacionOperacionCRUD crud = MenuPrincipalController.getCrud();

    /**
     * Guarda todos los usuarios del sistema en el archivo binario.
     * Usa el método serializar() de ImplementacionOperacionCRUD.
     * Se llama cuando el usuario hace clic en "Serializar (Guardar)".
     */
    @FXML
    private void serializar() {
        try {
            Usuario[] usuarios = crud.getListado();
            String resultado = crud.serializar(usuarios, PATH, NOMBRE_ARCHIVO);

            if (resultado.equals("File create!!")) {
                lblMensaje.setText("✅ Usuarios guardados correctamente en " + NOMBRE_ARCHIVO);
                lblMensaje.setStyle("-fx-text-fill: green;");
            } else {
                lblMensaje.setText("❌ Error al guardar: " + resultado);
                lblMensaje.setStyle("-fx-text-fill: red;");
            }

        } catch (Exception e) {
            lblMensaje.setText("❌ Error inesperado: " + e.getMessage());
            lblMensaje.setStyle("-fx-text-fill: red;");
        }
    }

    /**
     * Carga los usuarios desde el archivo binario al sistema.
     * Usa el método deserializar() de ImplementacionOperacionCRUD.
     * Reemplaza el arreglo actual con los datos del archivo.
     * Se llama cuando el usuario hace clic en "Deserializar (Cargar)".
     */
    @FXML
    private void deserializar() {
        try {
            Usuario[] cargados = crud.deserializar(PATH, NOMBRE_ARCHIVO);

            if (cargados != null) {
                // Actualizar el arreglo del CRUD con los datos cargados
                crud.setListado(cargados);

                // Contar cuántos usuarios se cargaron (excluyendo null)
                int total = 0;
                for (Usuario u : cargados) {
                    if (u != null) total++;
                }

                lblMensaje.setText("✅ " + total + " usuario(s) cargados correctamente desde " + NOMBRE_ARCHIVO);
                lblMensaje.setStyle("-fx-text-fill: green;");
            } else {
                lblMensaje.setText("❌ No se encontró el archivo " + NOMBRE_ARCHIVO + " o está vacío.");
                lblMensaje.setStyle("-fx-text-fill: red;");
            }

        } catch (Exception e) {
            lblMensaje.setText("❌ Error al cargar: " + e.getMessage());
            lblMensaje.setStyle("-fx-text-fill: red;");
        }
    }

    /**
     * Cierra esta ventana y vuelve al menú principal.
     * Se llama cuando el usuario hace clic en "Volver".
     */
    @FXML
    private void volverMenu() {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}