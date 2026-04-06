package co.edu.poli.contexto1.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.poli.contexto1.modelo.Usuario;

public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo{

	private Usuario[] listado;
	private int cantidad;
	
	public ImplementacionOperacionCRUD() {
		listado= new Usuario[2];
		cantidad = 0;
	}
	
	
	public void setListado(Usuario[] listado) {
		this.listado = listado;
	}


	public Usuario[] getListado() {
		return listado;
	}


	@Override
	public String crear(Usuario nuevo) {

	// Validacion 1 — el objeto no puede ser vacio o null
    if(nuevo == null) {
        System.out.println("El usuario no puede ser vacio");
        return"";
    }

    // Validacion 2 — el id no puede estar vacio
    if(nuevo.getId() == null || nuevo.getId().isEmpty()) {
        System.out.println("El usuario debe tener un id");
        return"";
    }

    // Validacion 3 — el nombre no puede estar vacio
    if(nuevo.getNombre() == null || nuevo.getNombre().isEmpty()) {
        System.out.println("El usuario debe tener un nombre");
        return"";
    }

    // Validacion 4 — verificar que no exista ya un usuario con el mismo id
    for(int i = 0; i < listado.length; i++) {
        if(listado[i] != null && listado[i].getId().equals(nuevo.getId())) {
            System.out.println("Ya existe un usuario con el id" + nuevo.getId());
            return"";
        }
    }

    // Buscar el primer espacio y se lo inserta
    for(int i = 0; i < listado.length; i++) {
        if(listado[i] == null) {
            listado[i] = nuevo;
            cantidad++;
            System.out.println("Usuario creado correctamente en la posicion" + i);
            return"";
        }
    }

    // Si llega aqui el arreglo esta lleno se duplica
    System.out.println("Arreglo lleno, duplicando tamaño...");
    Usuario[] arregloAmpliado = new Usuario[listado.length * 2];
    for(int i = 0; i < listado.length; i++) {
        arregloAmpliado[i] = listado[i];
    }
    listado = arregloAmpliado;

    for(int i = 0; i < listado.length; i++) {
        if(listado[i] == null) {
            listado[i] = nuevo;
            cantidad++;
            System.out.println("Usuario creado correctamente en la posicion" + i);
            return "";
        }
    }
    System.out.println("Error inesperado al crear el usuario");
    return "";
}
	
	
	@Override
	public Usuario consultar(String id) {
		// Validacion 1 — el objeto no puede ser vacio o null
	    if(id == null) {
	        System.out.println("El usuario no puede ser vacio");
	        return null;
	    }
	    
	    // Validacion 2 — el id no puede estar vacio
	    if(id.isEmpty()) {
	        System.out.println("El id no puede estar vacio");
	        return null;
	    }
	    
	    // Validacion 3 — el arreglo no puede estar vacio
	    if(cantidad == 0) {
	        System.out.println("No hay usuarios registrados en el arreglo");
	        return null;
	    }
		
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
	public String modificar(String id, Usuario usuarioNuevo) {
		
		// Validacion 1 — el objeto no puede ser vacio o null
	    if(id == null) {
	    	System.out.println("El usuario no puede ser vacio");
	        return "";
	    }
		
	    // Validacion 2 — el id no puede estar vacio
	    if(id.isEmpty()) {
	    	System.out.println("El id no puede estar vacio");
	        return"";
	    }
	    
	    // Validacion 3 — el arreglo no puede estar vacio
	    if(cantidad == 0) {
	    	System.out.println("No hay usuarios registrados en el arreglo");
	        return"";
	    }
	    
	    // Validacion 3 — el usuario nuevo no puede ser vacio o null
	    if(usuarioNuevo == null) {
	    	System.out.println("El usuario nuevo no puede ser vacio");
	        return"";
	    }
	    
	    // Validacion 3 — el id del usuario nuevo
	    if(!usuarioNuevo.getId().equals(id)) {
	    	System.out.println("El suario nuevo debe ser igual al id que se busca");
	        return"";
	    }
		
		for(int i=0; i<listado.length; i++) {
			if(listado[i] !=null && listado[i].getId().equals(id)) {
				listado[i]= usuarioNuevo;
				System.out.println("Usuario modificafo ");
				return"";
				
			}
		}
		System.out.println("Usuario NO encontrado");
		return("");
	}

	@Override
	public String eliminar(String id) {
		
		// Validacion 1 — el objeto no puede ser vacio o null
	    if(id == null) {
	    	System.out.println("El usuario no puede ser vacio");
	        return"";
	    }
		
	    // Validacion 2 — el id no puede estar vacio
	    if(id.isEmpty()) {
	    	System.out.println("El id no puede estar vacio");
	        return"";
	    }
	    
	    // Validacion 3 — el arreglo no puede estar vacio
	    if(cantidad == 0) {
	    	System.out.println("No hay usuarios registrados en el arreglo");
	        return"";
	    }

		for(int i=0; i<listado.length; i++) {
			if(listado[i] !=null && listado[i].getId().equals(id)) {
		listado[i]=null;
		System.out.println("Usuario borrado");
		return"";	
			}
		}
		System.out.println("Usuario NO encontrado");
		return("");
	}


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


	@Override
	public Usuario[] consultartodo() {
		// TODO Auto-generated method stub
		return listado;
	}
}
