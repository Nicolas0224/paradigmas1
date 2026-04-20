package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Implementación de las interfaces {@link OperacionCRUD} y
 * {@link OperacionArchivo} para la gestión de usuarios en el sistema de
 * simulación.
 * <p>
 * Administra un arreglo dinámico de objetos {@link Usuario} que se duplica
 * automáticamente cuando se agota el espacio disponible. Además, soporta la
 * persistencia de datos mediante serialización y deserialización de archivos
 * binarios.
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
	 * Constructor de la clase ImplementacionOperacionCRUD. Inicializa el arreglo
	 * con capacidad para 2 usuarios y la cantidad en 0.
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
		this.cantidad = 0;
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null) {
				this.cantidad++;
			}
		}
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
	 * <li>El usuario no puede ser {@code null}.</li>
	 * <li>El id del usuario no puede ser {@code null} ni vacío.</li>
	 * <li>El nombre del usuario no puede ser {@code null} ni vacío.</li>
	 * <li>No puede existir otro usuario con el mismo id.</li>
	 * </ul>
	 * Si el arreglo está lleno, su tamaño se duplica automáticamente antes de
	 * insertar.
	 * </p>
	 *
	 * @param nuevo El objeto {@link Usuario} a registrar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se
	 *         imprimen por consola.
	 */
	@Override
	public String crear(Usuario nuevo) throws Exception {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (nuevo == null)
			throw new Exception("El usuario no puede ser vacio");

		// Validacion 2 — el id no puede estar vacio
		if (nuevo.getId() == null || nuevo.getId().isEmpty())
			throw new Exception("El usuario debe tener un id");

		// Validacion 3 — el nombre no puede estar vacio
		if (nuevo.getNombre() == null || nuevo.getNombre().isEmpty())
			throw new Exception("El usuario debe tener un nombre");

		// Validacion 4 — verificar que no exista ya un usuario con el mismo id
		for (int i = 0; i < listado.length; i++)
			if (listado[i] != null && listado[i].getId().equals(nuevo.getId()))
				throw new Exception("Ya existe un usuario con el id " + nuevo.getId());

		// Buscar el primer espacio y se lo inserta
		for (int i = 0; i < listado.length; i++) {
			if (listado[i] == null) {
				listado[i] = nuevo;
				cantidad++;
				return "Usuario creado correctamente en la posicion " + i;
			}
		}

		// Si llega aqui el arreglo esta lleno se duplica
		System.out.println("Arreglo lleno, duplicando tamaño...");

		Usuario[] arregloAmpliado = new Usuario[listado.length * 2];
		for (int i = 0; i < listado.length; i++)
			arregloAmpliado[i] = listado[i];

		listado = arregloAmpliado;

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] == null) {
				listado[i] = nuevo;
				cantidad++;

				return "Arreglo ampliado. Usuario creado en la posicion" + i;
			}
		}
		throw new Exception("Error inesperado al crear el usuario");
	}

	/**
	 * Consulta y retorna un usuario registrado según su identificador.
	 * <p>
	 * Realiza las siguientes validaciones antes de buscar:
	 * <ul>
	 * <li>El id no puede ser {@code null}.</li>
	 * <li>El id no puede estar vacío.</li>
	 * <li>El arreglo no puede estar vacío (cantidad igual a 0).</li>
	 * </ul>
	 * </p>
	 *
	 * @param id Identificador único del usuario a buscar.
	 * @return El {@link Usuario} encontrado, o {@code null} si no existe o falla
	 *         alguna validación.
	 */
	@Override
	public Usuario consultar(String id) throws Exception {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null)
			throw new Exception("El usuario no puede estar vacio");

		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty())
			throw new Exception("El id no puede estar vacio");

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0)
			throw new Exception("No hay usuarios registrados en el arreglo");

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(id)) {
				System.out.println("Usuario encontrado " + listado[i]);
				return listado[i];
			}
		}
		throw new Exception("Usuario NO encontrado ");
	}

	/**
	 * Modifica los datos de un usuario existente identificado por su id.
	 * <p>
	 * Realiza las siguientes validaciones antes de modificar:
	 * <ul>
	 * <li>El id de búsqueda no puede ser {@code null} ni vacío.</li>
	 * <li>El arreglo no puede estar vacío.</li>
	 * <li>El usuario nuevo no puede ser {@code null}.</li>
	 * <li>El id del usuario nuevo debe coincidir con el id de búsqueda.</li>
	 * </ul>
	 * </p>
	 *
	 * @param id           Identificador único del usuario a modificar.
	 * @param usuarioNuevo Objeto {@link Usuario} con los nuevos datos a reemplazar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se
	 *         imprimen por consola.
	 */
	@Override
	public String modificar(String id, Usuario usuarioNuevo) throws Exception {

		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null)
			throw new Exception("El usuario no puede ser vacio");

		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty()) {
			throw new Exception("El id no puede estar vacio");

		}

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0) {
			throw new Exception("No hay usuarios registrados en el arreglo");

		}

		// Validacion 3 — el usuario nuevo no puede ser vacio o null
		if (usuarioNuevo == null) {
			throw new Exception("El usuario nuevo no puede ser vacio");
		}

		// Validacion 3 — el id del usuario nuevo
		if (!usuarioNuevo.getId().equals(id)) {
			throw new Exception("El usuario nuevo debe ser igual al id que se busca");
		}

		for (int i = 0; i < listado.length; i++) {
			if (listado[i] != null && listado[i].getId().equals(id)) {
				listado[i] = usuarioNuevo;
				System.out.println("Usuario modificafo ");
				return "";
			}
		}
		throw new Exception("Usuario NO encontrado");

	}

	/**
	 * Elimina el usuario con el identificador especificado del sistema.
	 * <p>
	 * Realiza las siguientes validaciones antes de eliminar:
	 * <ul>
	 * <li>El id no puede ser {@code null} ni vacío.</li>
	 * <li>El arreglo no puede estar vacío.</li>
	 * </ul>
	 * La eliminación establece la posición del usuario en {@code null} dentro del
	 * arreglo.
	 * </p>
	 *
	 * @param id Identificador único del usuario a eliminar.
	 * @return Cadena vacía en todos los casos; los mensajes de resultado se
	 *         imprimen por consola.
	 */
	@Override

	public String eliminar(String id) throws Exception {
		// Validacion 1 — el objeto no puede ser vacio o null
		if (id == null) 
			throw new Exception("El usuario no puede ser vacio");
	
		// Validacion 2 — el id no puede estar vacio
		if (id.isEmpty()) 
			throw new Exception("El id no puede estar vacio");

		// Validacion 3 — el arreglo no puede estar vacio
		if (cantidad == 0) 
			throw new Exception("No hay usuarios registrados en el arreglo");

		 for (int i = 0; i < listado.length; i++) {
	            if (listado[i] != null && listado[i].getId().equals(id)) {
	                listado[i] = null;
	                cantidad--;
	                return "Usuario eliminado correctamente";
	            }
	        }
	        throw new Exception("Usuario NO encontrado con id: " + id);
	    }

	/**
	 * Serializa un arreglo de usuarios y lo guarda en un archivo binario en la ruta
	 * especificada.
	 *
	 * @param usuarios Arreglo de usuarios a serializar.
	 * @param path     Ruta del directorio donde se guardará el archivo.
	 * @param name     Nombre del archivo destino.
	 * @return "File create!!" si la operación fue exitosa, o un mensaje de error en
	 *         caso contrario.
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
	 * Deserializa un arreglo de usuarios desde un archivo binario en la ruta
	 * especificada.
	 *
	 * @param path Ruta del directorio donde se encuentra el archivo.
	 * @param name Nombre del archivo a deserializar.
	 * @return Arreglo de objetos {@link Usuario} recuperados desde el archivo, o
	 *         {@code null} si ocurre un error durante la lectura.
	 */
	@Override
	 public Usuario[] deserializar(String path, String name) throws IOException, ClassNotFoundException {
	        FileInputStream fis = new FileInputStream(path + name);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        Usuario[] a = (Usuario[]) ois.readObject();
	        ois.close();
	        fis.close();
	        return a;
	    }
	/**
	 * Retorna el arreglo completo de usuarios registrados en el sistema, incluyendo
	 * las posiciones con valor {@code null}.
	 *
	 * @return Arreglo de todos los objetos {@link Usuario} del sistema.
	 */
	@Override
	public Usuario[] consultartodo() {
		// TODO Auto-generated method stub
		return listado;
	}
}
