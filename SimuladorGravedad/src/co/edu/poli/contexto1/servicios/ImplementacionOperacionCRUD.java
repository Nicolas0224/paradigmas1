package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.modelo.Usuario;
public class ImplementacionOperacionCRUD implements OperacionCRUD{

	private Usuario[] listado;
	private int cantidad;
	
	public ImplementacionOperacionCRUD() {
		listado= new Usuario[2];
		cantidad = 0;
	}
	
	
	@Override
    public void crear(Usuario nuevo) {  
        for (int i = 0; i < listado.length; i++) {
            if (listado[i] == null) {
                listado[i] = nuevo;
                cantidad++;
                System.out.println("Usuario creado en la posicion " + i);
                return;
            }
        }

       
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
                System.out.println("Usuario creado en la posicion " + i);
                return;
            }
        }
    }
	
	
	@Override
	public Usuario consultar(String id) {
		for(int i=0; i<listado.length; i++) {
			if(listado[i] !=null && listado[i].getId().equals(id)) {
				 System.out.println("Usuario encontrado " + listado[i]);
				 return listado[i];
			}
		}
		System.out.println("Usuario NO encontrado ");
	    return null;
	}
	


	@Override
	public void modificar(String id, Usuario usuarioNuevo) {
		for(int i=0; i<listado.length; i++) {
			if(listado[i] !=null && listado[i].getId().equals(id)) {
				listado[i]= usuarioNuevo;
				System.out.println("Usuario modificafo ");
				return;
				
			}
		}
		System.out.println("Usuario NO encontrado ");
	}

	@Override
	public void eliminar(String id) {

		for(int i=0; i<listado.length; i++) {
			if(listado[i] !=null && listado[i].getId().equals(id)) {
		listado[i]=null;
		System.out.println("Usuario borrado ");
		return;	
			}
		}
		System.out.println("Usuario NO encontrado ");
	}
}
