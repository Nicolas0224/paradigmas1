package co.edu.poli.contexto1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.Usuario;
import co.edu.poli.contexto1.modelo.UsuarioAnimal;
import co.edu.poli.contexto1.modelo.UsuarioPersona;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.contexto1.servicios.UsuarioVIP;

/**
 * Controlador de la ventana de Gestión de Usuario.
 * Maneja las operaciones de Crear, Buscar, Modificar y Eliminar usuarios.
 *
 * FLUJO DE USO:
 * - Crear: dejar ID vacío o ingresar un ID nuevo, llenar campos y presionar "Crear Usuario"
 * - Buscar: ingresar un ID existente y presionar "Buscar" — pre-llena todos los campos
 * - Modificar: después de buscar, editar campos y presionar "Guardar Cambios"
 * - Eliminar: después de buscar, presionar "Eliminar"
 */
public class GestionUsuarioController {

    // ===================== CAMPOS COMUNES =====================
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtId;
    @FXML private Button btnBuscar;
    @FXML private TextField txtNombre;
    @FXML private RadioButton rbMale;
    @FXML private RadioButton rbFemale;
    @FXML private TextField txtAnio;
    @FXML private TextField txtAltura;
    @FXML private TextField txtPeso;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtIdTipo;
    @FXML private TextField txtEspecie;
    @FXML private TextField txtRaza;
    @FXML private ComboBox<String> cmbTamano;

    // ===================== PANEL PERSONA / VIP =====================
    @FXML private javafx.scene.layout.GridPane panelPersona;
    @FXML private TextField txtOcupacion;
    @FXML private ComboBox<String> cmbNivelEducativo;
    @FXML private TextField txtCedula;
    @FXML private ComboBox<String> cmbGrupoSanguineo;

    // ===================== PANEL ANIMAL =====================
    @FXML private javafx.scene.layout.GridPane panelAnimal;
    @FXML private CheckBox chkVacunado;

    // ===================== PANEL VIP =====================
    @FXML private javafx.scene.layout.GridPane panelVIP;
    @FXML private ComboBox<String> cmbNivelVIP;

    // ===================== BOTONES =====================
    @FXML private Button btnCrear;
    @FXML private Button btnModificar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVolver;

    // ToggleGroup para los RadioButton de Sexo
    private ToggleGroup grupoSexo;

    // Instancia del CRUD compartida con el menú principal
    private ImplementacionOperacionCRUD crud = MenuPrincipalController.getCrud();

    /**
     * Se ejecuta automáticamente cuando se carga el FXML.
     * Inicializa los ComboBox, oculta los paneles y configura el ToggleGroup.
     */
    @FXML
    public void initialize() {

        // --- Cargar opciones de los ComboBox ---
        cmbTipo.getItems().addAll("UsuarioPersona", "UsuarioAnimal", "UsuarioVIP");
        cmbTamano.getItems().addAll("Pequeño", "Mediano", "Grande");
        cmbNivelEducativo.getItems().addAll("Técnico", "Tecnólogo", "Profesional");
        cmbGrupoSanguineo.getItems().addAll("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        cmbNivelVIP.getItems().addAll("Platino", "Oro", "Plata");

        // --- Configurar el ToggleGroup de Sexo ---
        // Esto hace que solo se pueda seleccionar un RadioButton a la vez
        grupoSexo = new ToggleGroup();
        rbMale.setToggleGroup(grupoSexo);
        rbFemale.setToggleGroup(grupoSexo);

        // --- Ocultar paneles específicos al inicio ---
        panelPersona.setVisible(false);
        panelPersona.setManaged(false); // setManaged(false) hace que no ocupe espacio cuando está oculto
        panelAnimal.setVisible(false);
        panelAnimal.setManaged(false);
        panelVIP.setVisible(false);
        panelVIP.setManaged(false);

        // --- Ocultar botones secundarios al inicio ---
        btnModificar.setVisible(false);
        btnModificar.setManaged(false);
        btnEliminar.setVisible(false);
        btnEliminar.setManaged(false);

        // --- Listener del ComboBox de tipo ---
        // Cuando el usuario cambia el tipo, se muestran/ocultan los paneles
        cmbTipo.setOnAction(e -> actualizarPaneles());
    }

    /**
     * Muestra u oculta los paneles específicos según el tipo de usuario seleccionado.
     * Se llama automáticamente cuando el usuario cambia el valor del cmbTipo.
     */
    private void actualizarPaneles() {
        String tipo = cmbTipo.getValue();
        if (tipo == null) return;

        // Ocultar todos primero
        panelPersona.setVisible(false);
        panelPersona.setManaged(false);
        panelAnimal.setVisible(false);
        panelAnimal.setManaged(false);
        panelVIP.setVisible(false);
        panelVIP.setManaged(false);

        // Mostrar el panel que corresponde
        switch (tipo) {
            case "UsuarioPersona":
                panelPersona.setVisible(true);
                panelPersona.setManaged(true);
                break;
            case "UsuarioAnimal":
                panelAnimal.setVisible(true);
                panelAnimal.setManaged(true);
                break;
            case "UsuarioVIP":
                panelPersona.setVisible(true);
                panelPersona.setManaged(true);
                panelVIP.setVisible(true);
                panelVIP.setManaged(true);
                break;
        }
    }

    /**
     * Busca un usuario por ID y pre-llena todos los campos del formulario.
     * También muestra los botones "Guardar Cambios" y "Eliminar".
     * Se llama cuando el usuario hace clic en "Buscar".
     */
    @FXML
    private void buscarUsuario() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            mostrarAlerta("Error", "Debe ingresar un ID para buscar.");
            return;
        }

        try {
            Usuario encontrado = crud.consultar(id);
            if (encontrado == null) {
                mostrarAlerta("No encontrado", "No existe un usuario con el ID: " + id);
                return;
            }

            // Pre-llenar campos comunes
            txtNombre.setText(encontrado.getNombre());
            txtAnio.setText(String.valueOf(encontrado.getAnioNacimiento()));
            txtAltura.setText(encontrado.getAltura());
            txtPeso.setText(String.valueOf(encontrado.getPeso()));
            txtCorreo.setText(encontrado.getCorreo());
            txtTelefono.setText(encontrado.getTelefono());

            if (encontrado.getSexo().equals("Male") || encontrado.getSexo().equals("Masculino")) {
                rbMale.setSelected(true);
            } else {
                rbFemale.setSelected(true);
            }

            if (encontrado.getTipoDeUsuario() != null) {
                txtIdTipo.setText(encontrado.getTipoDeUsuario().getId());
                txtEspecie.setText(encontrado.getTipoDeUsuario().getEspecie());
                txtRaza.setText(encontrado.getTipoDeUsuario().getRaza());
                cmbTamano.setValue(encontrado.getTipoDeUsuario().getTamaño());
            }

            if (encontrado instanceof UsuarioVIP) {
                cmbTipo.setValue("UsuarioVIP");
                actualizarPaneles();
                UsuarioVIP vip = (UsuarioVIP) encontrado;
                txtOcupacion.setText(vip.getOcupacion());
                cmbNivelEducativo.setValue(vip.getNivelEducativo());
                txtCedula.setText(vip.getNumeroCedula());
                cmbGrupoSanguineo.setValue(vip.getGrupoSanguineo());
                cmbNivelVIP.setValue(vip.getNivelVip());
            } else if (encontrado instanceof UsuarioPersona) {
                cmbTipo.setValue("UsuarioPersona");
                actualizarPaneles();
                UsuarioPersona persona = (UsuarioPersona) encontrado;
                txtOcupacion.setText(persona.getOcupacion());
                cmbNivelEducativo.setValue(persona.getNivelEducativo());
                txtCedula.setText(persona.getNumeroCedula());
                cmbGrupoSanguineo.setValue(persona.getGrupoSanguineo());
            } else if (encontrado instanceof UsuarioAnimal) {
                cmbTipo.setValue("UsuarioAnimal");
                actualizarPaneles();
                UsuarioAnimal animal = (UsuarioAnimal) encontrado;
                chkVacunado.setSelected(animal.isVacunado());
            }
    
            
         // Mostrar botones de Modificar y Eliminar
            btnModificar.setVisible(true);
            btnModificar.setManaged(true);
            btnEliminar.setVisible(true);
            btnEliminar.setManaged(true);

            // Ocultar botón Crear
            btnCrear.setVisible(false);
            btnCrear.setManaged(false);
            mostrarAlerta("Encontrado", "Usuario encontrado correctamente.");

        } catch (Exception e) {
            mostrarAlerta("Error", e.getMessage());
        }
    }
    /**
     * Crea un nuevo usuario con los datos del formulario y lo agrega al sistema.
     * Se llama cuando el usuario hace clic en "Crear Usuario".
     */
    @FXML
    private void crearUsuario() {
        try {
            Usuario nuevo = construirUsuario();
            if (nuevo == null) return;

            crud.crear(nuevo);
            mostrarAlerta("Éxito", "Usuario creado correctamente.");
            limpiarCampos();

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al crear el usuario: " + e.getMessage());
        }
    }

    /**
     * Modifica el usuario encontrado previamente con los nuevos datos del formulario.
     * Se llama cuando el usuario hace clic en "Guardar Cambios".
     */
    @FXML
    private void modificarUsuario() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            mostrarAlerta("Error", "Debe buscar un usuario primero.");
            return;
        }

        try {
            Usuario modificado = construirUsuario();
            if (modificado == null) return;
            System.out.println("ID a modificar: " + id + " | ID del objeto: " + modificado.getId());
            String resultado = crud.modificar(id, modificado);
            mostrarAlerta("Éxito", "Usuario modificado correctamente.");
            limpiarCampos();

        } catch (Exception e) {
            mostrarAlerta("Error", e.getMessage());
            e.printStackTrace();
        }	
    }

    /**
     * Elimina el usuario encontrado previamente del sistema.
     * Se llama cuando el usuario hace clic en "Eliminar".
     */
    @FXML
    private void eliminarUsuario() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            mostrarAlerta("Error", "Debe buscar un usuario primero.");
            return;
        }

        try {
            String resultado = crud.eliminar(id);
            mostrarAlerta("Éxito", resultado);
            limpiarCampos();
            btnModificar.setVisible(false);
            btnModificar.setManaged(false);
            btnEliminar.setVisible(false);
            btnEliminar.setManaged(false);
        } catch (Exception e) {
            mostrarAlerta("Error", e.getMessage());
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

    /**
     * Construye un objeto Usuario con los datos actuales del formulario.
     * Detecta el tipo seleccionado en cmbTipo y crea la subclase correspondiente.
     *
     * @return El objeto Usuario construido, o null si faltan datos obligatorios.
     */
    private Usuario construirUsuario() {
        // Validar campos obligatorios
        if (txtId.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()) {
            mostrarAlerta("Error", "ID y Nombre son obligatorios.");
            return null;
        }

        if (cmbTipo.getValue() == null) {
            mostrarAlerta("Error", "Debe seleccionar un tipo de usuario.");
            return null;
        }

        // Leer campos comunes
        String id        = txtId.getText().trim();
        String nombre    = txtNombre.getText().trim();
        String sexo      = rbMale.isSelected() ? "Male" : "Female";
        int anio         = Integer.parseInt(txtAnio.getText().trim());
        String altura    = txtAltura.getText().trim();
        double peso      = Double.parseDouble(txtPeso.getText().trim());
        String correo    = txtCorreo.getText().trim();
        String telefono  = txtTelefono.getText().trim();

        // Construir el Tipo_de_usuario
        Tipo_de_usuario tipo = new Tipo_de_usuario(
            txtIdTipo.getText().trim(),
            txtEspecie.getText().trim(),
            txtRaza.getText().trim(),
            cmbTamano.getValue() != null ? cmbTamano.getValue() : ""
        );

        // Construir la subclase correcta según el tipo seleccionado
        switch (cmbTipo.getValue()) {
            case "UsuarioPersona":
                return new UsuarioPersona(id, nombre, sexo, anio, altura, tipo, correo, telefono, peso,
                    txtOcupacion.getText().trim(),
                    cmbNivelEducativo.getValue() != null ? cmbNivelEducativo.getValue() : "",
                    txtCedula.getText().trim(),
                    cmbGrupoSanguineo.getValue() != null ? cmbGrupoSanguineo.getValue() : "");

            case "UsuarioAnimal":
                return new UsuarioAnimal(id, nombre, sexo, anio, altura, tipo, correo, telefono, peso,
                    chkVacunado.isSelected());

            case "UsuarioVIP":
                return new UsuarioVIP(id, nombre, sexo, anio, altura, tipo, correo, telefono, peso,
                    txtOcupacion.getText().trim(),
                    cmbNivelEducativo.getValue() != null ? cmbNivelEducativo.getValue() : "",
                    txtCedula.getText().trim(),
                    cmbGrupoSanguineo.getValue() != null ? cmbGrupoSanguineo.getValue() : "",
                    cmbNivelVIP.getValue() != null ? cmbNivelVIP.getValue() : "Plata");

            default:
                mostrarAlerta("Error", "Tipo de usuario no reconocido.");
                return null;
        }
    }

    /**
     * Limpia todos los campos del formulario a su estado inicial.
     */
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtAnio.clear();
        txtAltura.clear();
        txtPeso.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtIdTipo.clear();
        txtEspecie.clear();
        txtRaza.clear();
        txtOcupacion.clear();
        txtCedula.clear();
        cmbTipo.setValue(null);
        cmbTamano.setValue(null);
        cmbNivelEducativo.setValue(null);
        cmbGrupoSanguineo.setValue(null);
        cmbNivelVIP.setValue(null);
        rbMale.setSelected(false);
        rbFemale.setSelected(false);
        chkVacunado.setSelected(false);

        // Volver a mostrar Crear y ocultar Modificar/Eliminar
        btnCrear.setVisible(true);
        btnCrear.setManaged(true);
        btnModificar.setVisible(false);
        btnModificar.setManaged(false);
        btnEliminar.setVisible(false);
        btnEliminar.setManaged(false);

        // Ocultar paneles específicos
        actualizarPaneles();
    }
    /**
     * Muestra una ventana de alerta con un título y mensaje.
     *
     * @param titulo  Título de la alerta.
     * @param mensaje Mensaje a mostrar en la alerta.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}