package co.edu.poli.contexto1.vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.Usuario;
import co.edu.poli.contexto1.modelo.UsuarioAnimal;
import co.edu.poli.contexto1.modelo.UsuarioPersona;
import co.edu.poli.contexto1.servicios.UsuarioVIP;
import co.edu.poli.contexto1.servicios.ImplementacionOperacionCRUD;

/*
import co.edu.poli.contexto1.modelo.Curso;
import co.edu.poli.contexto1.modelo.Enfermedad;
import co.edu.poli.contexto1.modelo.Equipo;
import co.edu.poli.contexto1.modelo.Instructor;
import co.edu.poli.contexto1.modelo.Simulador;
import co.edu.poli.contexto1.modelo.ConfiguracionSimulador;
import co.edu.poli.contexto1.modelo.Turno;
*/

/**
 * Clase principal del sistema de simulación. Contiene el método de entrada
 * {@link #main(String[])} desde donde se ejecuta el menú CRUD para la gestión
 * de usuarios.
 * <p>
 * También define métodos polimórficos de apoyo usados en las pruebas del
 * sistema.
 * </p>
 *
 * @author Nicolas_David_Atehortua_Duarte
 * @version 1.0
 * @since 2026-03-27
 */
public class Principal {

	/**
	 * Método principal de entrada al sistema. Ejecuta el menú interactivo CRUD para
	 * la gestión de usuarios.
	 *
	 * @param args Argumentos de línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {

		/*
		 * Tipo_de_usuario tipoHumano = new Tipo_de_usuario("TU001", "Humano", "N/A",
		 * "Mediano"); Tipo_de_usuario tipoAnimal = new Tipo_de_usuario("TU002",
		 * "Perro", "Labrador", "Pequeño");
		 * 
		 * UsuarioPersona usuarioPersona = new UsuarioPersona("UP001",
		 * "Nicolas Atehortua", "Masculino", 1991, "1.70", tipoHumano,
		 * "nikolasd29@gmail.com", "3246847152", 70.5, "Ingeniero", "Universitario",
		 * "1024985449", "O+");
		 * 
		 * Enfermedad enfermedad1 = new Enfermedad("Diabetes", "Leve", "6 meses",
		 * "E001"); Enfermedad enfermedad2 = new Enfermedad("Hipertension", "Media",
		 * "1 año", "E002"); usuarioPersona.setEnfermedades(new Enfermedad[] {
		 * enfermedad1, enfermedad2 });
		 * 
		 * UsuarioVIP usuarioVip = new UsuarioVIP("UPV002", "Luisa Gomez", "Femenino",
		 * 1998, "1.65", tipoHumano, "laurita2026@gmail.com", "3101234567", 55.2,
		 * "Medico", "Universitario", "2058741236", "A+", "Platino");
		 * 
		 * Enfermedad enfermedad3 = new Enfermedad("Asma", "Leve", "Permanente",
		 * "E003"); usuarioVip.setEnfermedades(new Enfermedad[] { enfermedad3 });
		 * 
		 * UsuarioAnimal usuarioAnimal = new UsuarioAnimal("UA001", "Rocky", "Macho",
		 * 2023, "0.40", tipoAnimal, "perro@hotmail.com", "3009876543", 34.3, true);
		 * 
		 * Enfermedad enfermedad4 = new Enfermedad("Displasia", "Leve", "Fisioterapia",
		 * "E004"); usuarioAnimal.setEnfermedades(new Enfermedad[] { enfermedad4 });
		 * 
		 * Simulador simulador1 = new Simulador("S001", 2, true, "SimulatorX", "Gamer");
		 * Simulador simulador2 = new Simulador("S002", 4, true, "SimulatorX",
		 * "Profesional");
		 * 
		 * Equipo equipo1 = new Equipo("EQ001", "Traje adaptativo", "5 años",
		 * "Espacial", "SpaceX", 50.5, "2x2x1"); Equipo equipo2 = new Equipo("EQ002",
		 * "Botas estabilizadoras", "3 años", "Espacial", "SpaceX", 30.2, "1x1x1");
		 * Equipo[] equipos = { equipo1, equipo2 };
		 * 
		 * Curso curso = new Curso("C001", "Básico", "Presencial", "10:00", equipos);
		 * 
		 * Instructor instructor = new Instructor("I001",
		 * "Astronauta. Neil Armstrong III", "Gravedad Zero");
		 * 
		 * // Atributo estatico System.out.println("\n********** ESTATICO **********");
		 * System.out.println("Fabricante antes: " + Simulador.fabricante);
		 * Simulador.fabricante = "Google"; System.out.println("Fabricante despues: " +
		 * Simulador.fabricante);
		 * 
		 * // Sobrecarga System.out.println("\n********** SOBRECARGA **********");
		 * System.out.println("Descuento 1:  " +
		 * usuarioPersona.calcularDescuento("2024-01-15"));
		 * System.out.println("Descuento 2: " +
		 * usuarioPersona.calcularDescuento("2024-01-15", "Full"));
		 * 
		 * // Sobreescritura
		 * System.out.println("\n********** SOBREESCIRTURA **********");
		 * System.out.println( "UsuarioPersona (Universitario +5% para nicolas): " +
		 * usuarioPersona.calcularDescuento("2024-01-15")); System.out
		 * .println("UsuarioVIP (minimo 30% + Platino de laura):  " +
		 * usuarioVip.calcularDescuento("2024-01-15"));
		 * System.out.println("UsuarioAnimal:  " +
		 * usuarioAnimal.calcularDescuento("2024-01-15"));
		 * 
		 * // Objetos Turno System.out.println("\n********** OBJETOS TURNO **********");
		 * Turno turnoPersona = new Turno("TU001", usuarioPersona, "16/02/2026",
		 * "10:00", "13:00", "3 horas", instructor, simulador1, curso); Turno turnoVip =
		 * new Turno("TU002", usuarioVip, "17/02/2026", "14:00", "17:00", "3 horas",
		 * instructor, simulador1, curso); Turno turnoAnimal = new Turno("TU003",
		 * usuarioAnimal, "18/02/2026", "09:00", "11:00", "2 horas", instructor,
		 * simulador2, curso);
		 * 
		 * System.out.println(turnoPersona); System.out.println(turnoVip);
		 * System.out.println(turnoAnimal);
		 * 
		 * // PUNTO 1 - Arreglo en la supersuperclase con 5 posiciones y 3 objetos de
		 * subclases System.out.
		 * println("\n********** PUNTO 1 - ARREGLO SUPERSUPERCLASE **********");
		 * Usuario[] usuarios = new Usuario[3]; usuarios[0] = usuarioPersona;
		 * usuarios[1] = usuarioVip; usuarios[2] = usuarioAnimal;
		 * 
		 * for (int i = 0; i < usuarios.length; i++) {
		 * System.out.println(usuarios[i].toString()); System.out.println("Descuento: "
		 * + usuarios[i].calcularDescuento("2026-03-16") + "%"); }
		 * 
		 * // PUNTO 2 - metodo polimórfico
		 * System.out.println("\n********** PUNTO 2 - POLIMORFISMO **********");
		 * imprimirDescuento(usuarioPersona); imprimirDescuento(usuarioVip);
		 * imprimirDescuento(usuarioAnimal);
		 * 
		 * Usuario generico = crearUsuarioGenerico(tipoHumano);
		 * System.out.println(generico.toString());
		 * 
		 * // PUNTO 3 - uso del atributo final, metodo final y clase final
		 * System.out.println("\n********** PUNTO 3 - FINAL **********");
		 * System.out.println("VERSION final de Simulador: " + Simulador.VERSION);
		 * System.out.println(simulador1.obtenerInfo());
		 * System.out.println("Nivel VIP inicial de Laura (final): " +
		 * usuarioVip.nivelVipInicial); ConfiguracionSimulador config = new
		 * ConfiguracionSimulador("Gravedad Zero", "Avanzado", 90);
		 * 
		 * // PRUEBA DE VALIDACIONES
		 * System.out.println("\n--- PRUEBA DE VALIDACIONES ---"); crud.crear(null);
		 * crud.crear(usuarioPersona); crud.crear(usuarioPersona); crud.consultar(null);
		 * crud.consultar(""); ImplementacionOperacionCRUD crudVacio = new
		 * ImplementacionOperacionCRUD(); crudVacio.consultar("UP001");
		 * crud.modificar(null, usuarioPersona); crud.modificar("UP001", null);
		 * crud.modificar("UP001", usuarioVip); crud.eliminar(null); crud.eliminar("");
		 * crudVacio.eliminar("UP001");
		 * 
		 * // CREAR System.out.println("\n--- CREAR ---"); crud.crear(usuarioPersona);
		 * crud.crear(usuarioVip); crud.crear(usuarioAnimal);
		 * 
		 * // CONSULTAR System.out.println("\n--- CONSULTAR ---");
		 * crud.consultar("UP001"); crud.consultar("UA001"); crud.consultar("999");
		 * 
		 * // MODIFICAR System.out.println("\n--- MODIFICAR ---"); UsuarioPersona
		 * usuarioModificado = new UsuarioPersona( "UP001", "Nicolas David Atehortua",
		 * "Masculino", 1998, "1.80", tipoHumano, "nicolasd.04221@gmail.com",
		 * "3115922234", 70.5, "Ingeniero", "Universitario", "1024985449", "B+");
		 * crud.modificar("UP001", usuarioModificado); crud.consultar("UP001");
		 * 
		 * // ELIMINAR System.out.println("\n--- ELIMINAR ---"); crud.eliminar("UA001");
		 * crud.consultar("UA001"); crud.eliminar("999");
		 * 
		 * System.out.println(crud.serializar(crud.getListado(), "", "file.bin"));
		 * 
		 * Usuario[] Lista2 = crud.deserializar("", "file.bin");
		 * crud.setListado(Lista2); crud.consultartodo(); for (int i = 0; i <
		 * Lista2.length; i++) { System.out.println(Lista2[i]); }
		 */

		// MENU CRUD
		ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n========== MENU CRUD ==========");
			System.out.println("1. Crear usuario");
			System.out.println("2. Consultar usuario por ID");
			System.out.println("3. Consultar todos los usuarios");
			System.out.println("4. Modificar usuario");
			System.out.println("5. Eliminar usuario");
			System.out.println("6. Serializar (guardar en archivo)");
			System.out.println("7. Deserializar (cargar desde archivo)");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opcion: ");
			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un numero valido");
				scanner.nextLine();
				continue;
			}
			switch (opcion) {

			case 1:
				System.out.println("\n--- CREAR USUARIO ---");
				System.out.println("Tipo de usuario:");
				System.out.println("  1. UsuarioPersona");
				System.out.println("  2. UsuarioAnimal");
				System.out.println("  3. UsuarioVIP");
				System.out.print("Seleccione tipo: ");
				int tipo;
				while (true) {
				    try {
				        tipo = scanner.nextInt();
				        scanner.nextLine();
				        break;
				    } catch (InputMismatchException e) {
				        System.out.println("Ingrese un numero valido para el tipo");
				        scanner.nextLine();
				        System.out.print("Seleccione tipo: ");
				    }
				}

				System.out.print("ID: ");
				String id = scanner.nextLine();
				System.out.print("Nombre: ");
				String nombre = scanner.nextLine();
				System.out.print("Sexo: ");
				String sexo = scanner.nextLine();
				System.out.print("Año de nacimiento: ");
				int anio;
				while (true) {
				    try {
				        anio = scanner.nextInt();
				        scanner.nextLine();
				        break;
				    } catch (InputMismatchException e) {
				        System.out.println("Ingrese un numero valido para el año");
				        scanner.nextLine();
				        System.out.print("Año de nacimiento: ");
				    }
				}
				System.out.print("Altura: ");
				String altura = scanner.nextLine();
				System.out.print("Peso: ");
				double peso;
				while (true) {
				    try {
				        peso = scanner.nextDouble();
				        scanner.nextLine();
				        break;
				    } catch (InputMismatchException e) {
				        System.out.println("Ingrese un numero valido para el peso");
				        scanner.nextLine();
				        System.out.print("Peso: ");
				    }
				}
				System.out.print("Correo: ");
				String correo = scanner.nextLine();
				System.out.print("Telefono: ");
				String telefono = scanner.nextLine();

				System.out.print("ID Tipo de usuario: ");
				String tipoId = scanner.nextLine();
				System.out.print("Especie: ");
				String especie = scanner.nextLine();
				System.out.print("Raza: ");
				String raza = scanner.nextLine();
				System.out.print("Tamaño: ");
				String tamanio = scanner.nextLine();
				Tipo_de_usuario tipoUsuario = new Tipo_de_usuario(tipoId, especie, raza, tamanio);

				try {

					if (tipo == 1) {
						System.out.print("Ocupacion: ");
						String ocupacion = scanner.nextLine();
						System.out.print("Nivel educativo: ");
						String nivelEdu = scanner.nextLine();
						System.out.print("Numero de cedula: ");
						String cedula = scanner.nextLine();
						System.out.print("Grupo sanguineo: ");
						String sangre = scanner.nextLine();
						UsuarioPersona persona = new UsuarioPersona(id, nombre, sexo, anio, altura, tipoUsuario, correo,
								telefono, peso, ocupacion, nivelEdu, cedula, sangre);
						crud.crear(persona);

					} else if (tipo == 2) {
						System.out.print("¿Esta vacunado? (true/false): ");
						boolean vacunado;

						while (true) {
						    try {
						        vacunado = scanner.nextBoolean();
						        scanner.nextLine(); 
						        break;
						    } catch (InputMismatchException e) {
						        System.out.println("Ingrese solo true o false.");
						        scanner.nextLine();
						        System.out.print("¿Esta vacunado? (true/false): ");
						    }
						}
						UsuarioAnimal animal = new UsuarioAnimal(id, nombre, sexo, anio, altura, tipoUsuario, correo,
								telefono, peso, vacunado);
						System.out.println(crud.crear(animal));

					} else if (tipo == 3) {
						System.out.print("Ocupacion: ");
						String ocupacion = scanner.nextLine();
						System.out.print("Nivel educativo: ");
						String nivelEdu = scanner.nextLine();
						System.out.print("Numero de cedula: ");
						String cedula = scanner.nextLine();
						System.out.print("Grupo sanguineo: ");
						String sangre = scanner.nextLine();
						System.out.print("Nivel VIP (Platino/Oro/Plata): ");
						String nivelVip = scanner.nextLine();
						UsuarioVIP vip = new UsuarioVIP(id, nombre, sexo, anio, altura, tipoUsuario, correo, telefono,
								peso, ocupacion, nivelEdu, cedula, sangre, nivelVip);
						System.out.println(crud.crear(vip));

					} else {
						System.out.println("Tipo de usuario no valido");
					}
				} catch (Exception e) {
					System.out.println("Error al crear usuario: " + e.getMessage());
				}
				break;

			case 2:
				System.out.println("\n--- CONSULTAR USUARIO ---");
				System.out.print("Ingrese el ID del usuario: ");
				String idConsultar = scanner.nextLine();

				try {
					Usuario encontrado = crud.consultar(idConsultar);
					System.out.print("Usuario encontrado" + encontrado);
				} catch (Exception e) {
					System.out.println("Error al consultar: " + e.getMessage());
				}
				break;

			case 3:
				System.out.println("\n--- TODOS LOS USUARIOS ---");
				Usuario[] todos = crud.consultartodo();
				int contador = 0;

				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null) {
						System.out.println(todos[i]);
						contador++;
					}
				}

				if (contador == 0) {
					System.out.println("No hay usuarios registrados");
				}
				break;

			case 4:
				System.out.println("\n--- MODIFICAR USUARIO ---");
				System.out.print("Ingrese el ID del usuario a modificar: ");
				String idModificar = scanner.nextLine();

				System.out.println("Tipo de usuario:");
				System.out.println("  1. UsuarioPersona");
				System.out.println("  2. UsuarioAnimal");
				System.out.println("  3. UsuarioVIP");
				System.out.print("Seleccione tipo: ");
				int tipoMod;
				try {
					tipoMod = scanner.nextInt();
					scanner.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("Ingrese un numero valido para el tipo");
					scanner.nextLine();
					break;
				}

				System.out.print("Nombre: ");
				String nombreMod = scanner.nextLine();
				System.out.print("Sexo: ");
				String sexoMod = scanner.nextLine();
				System.out.print("Año de nacimiento: ");
				int anioMod;
				while (true) {
				    try {
				        anioMod = scanner.nextInt();
				        scanner.nextLine();
				        break;
				    } catch (InputMismatchException e) {
				        System.out.println("Ingrese un numero valido para el año");
				        scanner.nextLine();
				        System.out.print("Año de nacimiento: ");
				    }
				}
				System.out.print("Altura: ");
				String alturaMod = scanner.nextLine();
				System.out.print("Peso: ");
				double pesoMod;
				while (true) {
				    try {
				        pesoMod = scanner.nextDouble();
				        scanner.nextLine();
				        break;
				    } catch (InputMismatchException e) {
				        System.out.println("Ingrese un numero valido para peso");
				        scanner.nextLine();
				        System.out.print("Peso: ");
				    }
				}
				System.out.print("Correo: ");
				String correoMod = scanner.nextLine();
				System.out.print("Telefono: ");
				String telefonoMod = scanner.nextLine();

				System.out.print("ID Tipo de usuario: ");
				String tipoIdMod = scanner.nextLine();
				System.out.print("Especie: ");
				String especieMod = scanner.nextLine();
				System.out.print("Raza: ");
				String razaMod = scanner.nextLine();
				System.out.print("Tamaño: ");
				String tamanioMod = scanner.nextLine();
				Tipo_de_usuario tipoUsuarioMod = new Tipo_de_usuario(tipoIdMod, especieMod, razaMod, tamanioMod);

				try {

					if (tipoMod == 1) {
						System.out.print("Ocupacion: ");
						String ocupacionMod = scanner.nextLine();
						System.out.print("Nivel educativo: ");
						String nivelEduMod = scanner.nextLine();
						System.out.print("Numero de cedula: ");
						String cedulaMod = scanner.nextLine();
						System.out.print("Grupo sanguineo: ");
						String sangreMod = scanner.nextLine();
						UsuarioPersona personaMod = new UsuarioPersona(idModificar, nombreMod, sexoMod, anioMod,
								alturaMod, tipoUsuarioMod, correoMod, telefonoMod, pesoMod, ocupacionMod, nivelEduMod,
								cedulaMod, sangreMod);
						crud.modificar(idModificar, personaMod);

					} else if (tipoMod == 2) {
						System.out.print("¿Esta vacunado? (true/false): ");
						boolean vacunadoMod = scanner.nextBoolean();
						scanner.nextLine();
						UsuarioAnimal animalMod = new UsuarioAnimal(idModificar, nombreMod, sexoMod, anioMod, alturaMod,
								tipoUsuarioMod, correoMod, telefonoMod, pesoMod, vacunadoMod);
						crud.modificar(idModificar, animalMod);

					} else if (tipoMod == 3) {
						System.out.print("Ocupacion: ");
						String ocupacionMod = scanner.nextLine();
						System.out.print("Nivel educativo: ");
						String nivelEduMod = scanner.nextLine();
						System.out.print("Numero de cedula: ");
						String cedulaMod = scanner.nextLine();
						System.out.print("Grupo sanguineo: ");
						String sangreMod = scanner.nextLine();
						System.out.print("Nivel VIP (Platino/Oro/Plata): ");
						String nivelVipMod = scanner.nextLine();
						UsuarioVIP vipMod = new UsuarioVIP(idModificar, nombreMod, sexoMod, anioMod, alturaMod,
								tipoUsuarioMod, correoMod, telefonoMod, pesoMod, ocupacionMod, nivelEduMod, cedulaMod,
								sangreMod, nivelVipMod);
						crud.modificar(idModificar, vipMod);

					} else {
						System.out.println("Tipo de usuario no valido");
					}
				} catch (Exception e) {
					System.out.println("Error al modificar usuario: " + e.getMessage());
				}
				break;

			case 5:
				System.out.println("\n--- ELIMINAR USUARIO ---");
				System.out.print("Ingrese el ID del usuario a eliminar: ");
				String idEliminar = scanner.nextLine();
				 try {
	                    System.out.println(crud.eliminar(idEliminar));
	                } catch (Exception e) {
	                    System.out.println("Error al eliminar: " + e.getMessage());
	                }
	                break;

			case 6:
				System.out.println("\n--- SERIALIZAR ---");
				System.out.print("Nombre del archivo (ej: file.bin): ");
				String archivoSer = scanner.nextLine();
				System.out.println(crud.serializar(crud.getListado(), "", archivoSer));
				break;

			case 7:
				System.out.println("\n--- DESERIALIZAR ---");
				System.out.print("Nombre del archivo (ej: file.bin): ");
				String archivoDes = scanner.nextLine();
				
				try {
                    Usuario[] cargados = crud.deserializar("", archivoDes);
                    crud.setListado(cargados);
                    System.out.println("Datos cargados correctamente");
                } catch (Exception e) {
                    System.out.println("Error al cargar archivo: " + e.getMessage());
                }
                break;


			case 0:
				System.out.println("Fin");
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
		}

		scanner.close();
	}

	/**
	 * Método polimórfico que recibe un usuario de cualquier subclase e imprime por
	 * consola el porcentaje de descuento calculado para ese usuario.
	 *
	 * @param usuario Objeto de tipo {@link Usuario} (o cualquier subclase) a
	 *                evaluar.
	 */
	// PUNTO 2 - método polimórfico que recibe un parámetro de tipo supersuperclase
	public static void imprimirDescuento(Usuario usuario) {
		System.out
				.println("Descuento de " + usuario.getNombre() + ": " + usuario.calcularDescuento("2026-03-16") + "%");
	}

	/**
	 * Método polimórfico que crea y retorna un usuario genérico de tipo persona. El
	 * objeto retornado es de tipo {@link Usuario} (supersuperclase).
	 *
	 * @param tipo Tipo de usuario a asignar al usuario genérico creado.
	 * @return Un nuevo objeto {@link UsuarioPersona} con datos predefinidos.
	 */
	// PUNTO 2 - método polimórfico que retorna un tipo supersuperclase
	public static Usuario crearUsuarioGenerico(Tipo_de_usuario tipo) {
		return new UsuarioPersona("UPG003", "Alejandra Rueda", "Femenino", 2006, "1.62", tipo, "alejita524@gmail.com",
				"3246847182", 60.1, "Estudiante", "Universitario", "1025524524", "O+");
	}
}