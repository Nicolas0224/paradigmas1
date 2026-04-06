package co.edu.poli.contexto1.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.poli.contexto1.modelo.Usuario;

/**
 * Implementación de las interfaces {@link OperacionCRUD} y {@link OperacionArchivo}
 * para la gestión de usuarios en el sistema de simulación.
 * <p>
 * Administra un arreglo dinámico de objetos {@link Usuario} que se duplica
 * automáticamente cuando se agota el espacio disponible. Además, soporta
 * la persistencia de datos mediante serialización y deserialización de archivos binarios.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 * @see OperacionCRUD
 * @see OperacionArchivo
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

	/** Arreglo que almacena los usuarios registrados en el sistema. */
	private Usuario[] listado;

	/** Cantidad de usuarios actualmente registrados en el arreglo. */
	private int cantidad;

	/**
	 * Constructor de la clase ImplementacionOperacionCRUD.
	 * Inicializa el arreglo con capacidad para 2 usuarios y la cantidad en 0.
	 */
	public ImplementacionOperacionCRUD() {
		listado = new Usuario[2];
		cantidad = 0;
	}

	/**
	 * Establece el arreglo de usuarios del sistema.
	 *
	 * @param listado El nuevo arreglo de usuarios.
	 */
	public void setListado(Usuario[] listado) {
		this.listado = listado;
	}

	/**
	 * Obtiene el arreglo de usuarios del sistema.
	 *
	 * @return El arreglo de objetos {@link Usuario} registrados.
	 */
	public Usuario[] getListado() {
		return listado;
	}

	/**
	 * Crea y registra un nuevo usuario en el sistema.
	 * <p>
	 * Realiza las siguientes validaciones antes de insertar:
	 * <ul>
	 *   <li>El usuario no puede ser {@code null}.</li>
	 *   <li>El id del usuario no puede ser {@code null} ni vacío.</li>
	 *   <li>El nombre del usuario no puede ser {@code null} ni vacío.</li>
	 *   <li>No puede existir otro usuario con el mismo id.</li>
	 * </ul>
	 * Si el arreglo está lleno, su tamaño se duplica automáticamente antes de insertar.
	 * </p>
	 *
	 * @param nuevo El objeto {@link Usuario} a registrar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se imprimen por consola.
	 */
	@Override
	public String crear(Usuario nuevo) {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (nuevo == null) {
			System.out.println("El usuario no puede ser vacio");
			return "";
		}

		// Validacion 2 — el id no puede estar vacio
		if (nuevo.getId() == null || nuevo.getId().isEmpty()) {
			System.out.println("El usuario debe tener un id");
			return "";
		}

		// Validacion 3 — el nombre no puede estar vacio
		if (nuevo.getNombre() == null || nuevo.getNombre().isEmpty()) {
			System.out.println("El usuario debe tener un nombre");
			return "";
		}

		// Validacion 4 — verificar que no exista ya un usuario con el mismo id
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(nuevo.getId())) {
				System.out.println("Ya existe un usuario con el id" + nuevo.getId());
				return "";
			}
		}

		// Buscar el primer espacio y se lo inserta
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] == null) {
				listado[i] = nuevo;
				cantidad++;
				System.out.println("Usuario creado correctamente en la posicion" + i);
				return "";
			}
		}

		// Si llega aqui el arreglo esta lleno se duplica
		System.out.println("Arreglo lleno, duplicando tamaño...");
		Usuario[] arregloAmpliado = new Usuario[listado.length * 2];
		for (int i = 0; i < listado.length; i++) {
			arregloAmpliado[i] = listado[i];
		}
		listado = arregloAmpliado;

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] == null) {
				listado[i] = nuevo;
				cantidad++;
				System.out.println("Usuario creado correctamente en la posicion" + i);
				return "";
			}
		}
		System.out.println("Error inesperado al crear el usuario");
		return "";
	}

	/**
	 * Consulta y retorna un usuario registrado según su identificador.
	 * <p>
	 * Realiza las siguientes validaciones antes de buscar:
	 * <ul>
	 *   <li>El id no puede ser {@code null}.</li>
	 *   <li>El id no puede estar vacío.</li>
	 *   <li>El arreglo no puede estar vacío (cantidad igual a 0).</li>
	 * </ul>
	 * </p>
	 *
	 * @param id Identificador único del usuario a buscar.
	 * @return El {@link Usuario} encontrado, o {@code null} si no existe o falla alguna validación.
	 */
	@Override
	public Usuario consultar(String id) {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null) {
			System.out.println("El usuario no puede ser vacio");
			return null;
		}

		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty()) {
			System.out.println("El id no puede estar vacio");
			return null;
		}

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0) {
			System.out.println("No hay usuarios registrados en el arreglo");
			return null;
		}

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(id)) {
				System.out.println("Usuario encontrado " + listado[i]);
				return listado[i];
			}
		}
		System.out.println("Usuario NO encontrado ");
		return null;
	}

	/**
	 * Modifica los datos de un usuario existente identificado por su id.
	 * <p>
	 * Realiza las siguientes validaciones antes de modificar:
	 * <ul>
	 *   <li>El id de búsqueda no puede ser {@code null} ni vacío.</li>
	 *   <li>El arreglo no puede estar vacío.</li>
	 *   <li>El usuario nuevo no puede ser {@code null}.</li>
	 *   <li>El id del usuario nuevo debe coincidir con el id de búsqueda.</li>
	 * </ul>
	 * </p>
	 *
	 * @param id           Identificador único del usuario a modificar.
	 * @param usuarioNuevo Objeto {@link Usuario} con los nuevos datos a reemplazar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se imprimen por consola.
	 */
	@Override
	public String modificar(String id, Usuario usuarioNuevo) {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null) {
			System.out.println("El usuario no puede ser vacio");
			return "";
		}

		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty()) {
			System.out.println("El id no puede estar vacio");
			return "";
		}

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0) {
			System.out.println("No hay usuarios registrados en el arreglo");
			return "";
		}

		// Validacion 3 — el usuario nuevo no puede ser vacio o null
		if (usuarioNuevo == null) {
			System.out.println("El usuario nuevo no puede ser vacio");
			return "";
		}

		// Validacion 3 — el id del usuario nuevo
		if (!usuarioNuevo.getId().equals(id)) {
			System.out.println("El suario nuevo debe ser igual al id que se busca");
			return "";
		}

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(id)) {
				listado[i] = usuarioNuevo;
				System.out.println("Usuario modificafo ");
				return "";
			}
		}
		System.out.println("Usuario NO encontrado");
		return ("");
	}

	/**
	 * Elimina el usuario con el identificador especificado del sistema.
	 * <p>
	 * Realiza las siguientes validaciones antes de eliminar:
	 * <ul>
	 *   <li>El id no puede ser {@code null} ni vacío.</li>
	 *   <li>El arreglo no puede estar vacío.</li>
	 * </ul>
	 * La eliminación establece la posición del usuario en {@code null} dentro del arreglo.
	 * </p>
	 *
	 * @param id Identificador único del usuario a eliminar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se imprimen por consola.
	 */
	@Override
	public String eliminar(String id) {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null) {
			System.out.println("El usuario no puede ser vacio");
			return "";
		}

		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty()) {
			System.out.println("El id no puede estar vacio");
			return "";
		}

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0) {
			System.out.println("No hay usuarios registrados en el arreglo");
			return "";
		}

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(id)) {
				listado[i] = null;
				System.out.println("Usuario borrado");
				return "";
			}
		}
		System.out.println("Usuario NO encontrado");
		return ("");
	}

	/**
	 * Serializa un arreglo de usuarios y lo guarda en un archivo binario en la ruta especificada.
	 *
	 * @param usuarios Arreglo de usuarios a serializar.
	 * @param path     Ruta del directorio donde se guardará el archivo.
	 * @param name     Nombre del archivo destino.
	 * @return "File create!!" si la operación fue exitosa, o un mensaje de error en caso contrario.
	 */
	@Override
	public String serializar(Usuario[] usuarios, String path, String name) {
		try {
			FileOutputStream fos = new FileOutputStream(path + name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarios);
			oos.close();
			fos.close();
			return "File create!!";
		} catch (IOException ioe) {
			return "Error file " + ioe.getMessage();
		}
	}

	/**
	 * Deserializa un arreglo de usuarios desde un archivo binario en la ruta especificada.
	 *
	 * @param path Ruta del directorio donde se encuentra el archivo.
	 * @param name Nombre del archivo a deserializar.
	 * @return Arreglo de objetos {@link Usuario} recuperados desde el archivo,
	 *         o {@code null} si ocurre un error durante la lectura.
	 */
	@Override
	public Usuario[] deserializar(String path, String name) {
		Usuario[] a = null;
		try {
			FileInputStream fis = new FileInputStream(path + name);
			ObjectInputStream ois = new ObjectInputStream(fis);
			a = (Usuario[]) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (ClassNotFoundException c) {
			System.err.println(c.getMessage());
		}
		return a;
	}

	/**
	 * Retorna el arreglo completo de usuarios registrados en el sistema,
	 * incluyendo las posiciones con valor {@code null}.
	 *
	 * @return Arreglo de todos los objetos {@link Usuario} del sistema.
	 */
	@Override
	public Usuario[] consultartodo() {
		// TODO Auto-generated method stub
		return listado;
	}
}

