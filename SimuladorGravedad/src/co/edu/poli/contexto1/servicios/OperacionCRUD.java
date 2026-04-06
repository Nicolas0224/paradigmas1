package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Usuario;

public interface OperacionCRUD {
  
	String crear(Usuario usuario);
    Usuario consultar(String id);
    Usuario[] consultartodo ();
    String modificar(String id, Usuario usuarioNuevo);
    String eliminar(String id);
    
}