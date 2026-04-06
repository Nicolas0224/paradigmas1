package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Usuario;

/**
 * Interfaz que define las operaciones básicas de un CRUD
 * (Crear, Consultar, Modificar y Eliminar) sobre objetos de tipo {@link Usuario}.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public interface OperacionCRUD {

    /**
     * Crea y registra un nuevo usuario en el sistema.
     *
     * @param usuario El objeto {@link Usuario} a registrar.
     * @return Mensaje indicando el resultado de la operación.
     */
    String crear(Usuario usuario);

    /**
     * Consulta y retorna un usuario registrado según su identificador.
     *
     * @param id Identificador único del usuario a buscar.
     * @return El {@link Usuario} encontrado, o {@code null} si no existe.
     */
    Usuario consultar(String id);

    /**
     * Retorna el arreglo completo de usuarios registrados en el sistema.
     *
     * @return Arreglo de todos los objetos {@link Usuario} registrados.
     */
    Usuario[] consultartodo();

    /**
     * Modifica los datos de un usuario existente identificado por su id.
     *
     * @param id           Identificador único del usuario a modificar.
     * @param usuarioNuevo Objeto {@link Usuario} con los nuevos datos.
     * @return Mensaje indicando el resultado de la operación.
     */
    String modificar(String id, Usuario usuarioNuevo);

    /**
     * Elimina el usuario con el identificador especificado del sistema.
     *
     * @param id Identificador único del usuario a eliminar.
     * @return Mensaje indicando el resultado de la operación.
     */
    String eliminar(String id);
}
