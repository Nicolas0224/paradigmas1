package co.edu.poli.contexto1.controlador;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import co.edu.poli.contexto1.modelo.Usuario;
import co.edu.poli.contexto1.modelo.UsuarioAnimal;
import co.edu.poli.contexto1.modelo.UsuarioPersona;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto1.servicios.UsuarioVIP;

/**
 * Controlador de la ventana Consultar Todos los Usuarios.
 * Carga todos los usuarios del sistema en una TableView.
 * Los campos que no aplican a un tipo de usuario muestran "N/A".
 */
public class ConsultarTodosController {

    // ===================== TABLEVIEW Y COLUMNAS =====================
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, String> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colTipo;
    @FXML private TableColumn<Usuario, String> colCorreo;
    @FXML private TableColumn<Usuario, String> colTelefono;
    @FXML private TableColumn<Usuario, String> colOcupacion;
    @FXML private TableColumn<Usuario, String> colCedula;
    @FXML private TableColumn<Usuario, String> colGrupoSanguineo;
    @FXML private TableColumn<Usuario, String> colEspecie;
    @FXML private TableColumn<Usuario, String> colRaza;
    @FXML private TableColumn<Usuario, String> colVacunado;
    @FXML private TableColumn<Usuario, String> colNivelVIP;

    @FXML private Button btnVolver;

    // Instancia del CRUD compartida con el menú principal
    private ImplementacionOperacionCRUD crud = MenuPrincipalController.getCrud();

    /**
     * Se ejecuta automáticamente cuando se carga el FXML.
     * Configura cada columna indicando qué dato mostrar,
     * y carga todos los usuarios en la tabla.
     */
    @FXML
    public void initialize() {
        configurarColumnas();
        cargarUsuarios();
    }

    /**
     * Configura cada columna de la TableView con su cellValueFactory.
     * Cada columna sabe qué dato extraer del Usuario y muestra "N/A"
     * si el campo no aplica al tipo de usuario.
     */
    private void configurarColumnas() {

        // Columnas comunes — aplican a todos los tipos
        colId.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getId()));

        colNombre.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getNombre()));

        colTipo.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioVIP)     return new SimpleStringProperty("UsuarioVIP");
            if (data.getValue() instanceof UsuarioPersona) return new SimpleStringProperty("UsuarioPersona");
            if (data.getValue() instanceof UsuarioAnimal)  return new SimpleStringProperty("UsuarioAnimal");
            return new SimpleStringProperty("Desconocido");
        });

        colCorreo.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getCorreo()));

        colTelefono.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getTelefono()));

        colEspecie.setCellValueFactory(data -> {
            if (data.getValue().getTipoDeUsuario() != null) {
                return new SimpleStringProperty(data.getValue().getTipoDeUsuario().getEspecie());
            }
            return new SimpleStringProperty("N/A");
        });

        colRaza.setCellValueFactory(data -> {
            if (data.getValue().getTipoDeUsuario() != null) {
                return new SimpleStringProperty(data.getValue().getTipoDeUsuario().getRaza());
            }
            return new SimpleStringProperty("N/A");
        });

        // Columnas de Persona y VIP — N/A para Animal
        colOcupacion.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioPersona) {
                return new SimpleStringProperty(((UsuarioPersona) data.getValue()).getOcupacion());
            }
            return new SimpleStringProperty("N/A");
        });

        colCedula.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioPersona) {
                return new SimpleStringProperty(((UsuarioPersona) data.getValue()).getNumeroCedula());
            }
            return new SimpleStringProperty("N/A");
        });

        colGrupoSanguineo.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioPersona) {
                return new SimpleStringProperty(((UsuarioPersona) data.getValue()).getGrupoSanguineo());
            }
            return new SimpleStringProperty("N/A");
        });

        // Columna exclusiva de Animal — N/A para Persona y VIP
        colVacunado.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioAnimal) {
                boolean vac = ((UsuarioAnimal) data.getValue()).isVacunado();
                return new SimpleStringProperty(vac ? "Sí" : "No");
            }
            return new SimpleStringProperty("N/A");
        });

        // Columna exclusiva de VIP — N/A para Persona y Animal
        colNivelVIP.setCellValueFactory(data -> {
            if (data.getValue() instanceof UsuarioVIP) {
                return new SimpleStringProperty(((UsuarioVIP) data.getValue()).getNivelVip());
            }
            return new SimpleStringProperty("N/A");
        });
    }

    /**
     * Carga todos los usuarios del sistema en la TableView.
     * Ignora las posiciones null del arreglo.
     */
    private void cargarUsuarios() {
        ObservableList<Usuario> lista = FXCollections.observableArrayList();
        Usuario[] todos = crud.consultartodo();

        for (Usuario u : todos) {
            if (u != null) {
                lista.add(u);
            }
        }

        tablaUsuarios.setItems(lista);

        if (lista.isEmpty()) {
            tablaUsuarios.setPlaceholder(new Label("No hay usuarios registrados en el sistema."));
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