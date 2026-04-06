package co.edu.poli.contexto1.servicios;
 
import co.edu.poli.contexto1.modelo.Usuario;
 
/**
 * Interfaz que define las operaciones de serialización y deserialización
 * de arreglos de usuarios hacia y desde archivos.
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public interface OperacionArchivo {
 
    /**
     * Serializa un arreglo de usuarios y lo guarda en un archivo en la ruta especificada.
     *
     * @param usuarios Arreglo de usuarios a serializar.
     * @param path     Ruta del directorio donde se guardará el archivo.
     * @param name     Nombre del archivo destino.
     * @return Mensaje indicando el resultado de la operación de serialización.
     */
    public String serializar(Usuario[] usuarios, String path, String name);
 
    /**
     * Deserializa un arreglo de usuarios desde un archivo en la ruta especificada.
     *
     * @param path Ruta del directorio donde se encuentra el archivo.
     * @param name Nombre del archivo a deserializar.
     * @return Arreglo de usuarios obtenido desde el archivo.
     */
    public Usuario[] deserializar(String path, String name);
 
}
 