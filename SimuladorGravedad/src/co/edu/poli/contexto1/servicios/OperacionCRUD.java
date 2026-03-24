package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Usuario;

public interface OperacionCRUD {
  
	void crear(Usuario usuario);
    Usuario consultar(String id);
    void modificar(String id, Usuario usuarioNuevo);
    void eliminar(String id);
    
}