package co.edu.poli.contexto1.modelo.vista;

import co.edu.poli.contexto1.modelo.Curso;
import co.edu.poli.contexto1.modelo.Enfermedad;
import co.edu.poli.contexto1.modelo.Equipo;
import co.edu.poli.contexto1.modelo.Instructor;
import co.edu.poli.contexto1.modelo.Simulador;
import co.edu.poli.contexto1.modelo.ConfiguracionSimulador;
import co.edu.poli.contexto1.modelo.Tipo_de_usuario;
import co.edu.poli.contexto1.modelo.Turno;
import co.edu.poli.contexto1.modelo.Usuario;
import co.edu.poli.contexto1.modelo.UsuarioAnimal;
import co.edu.poli.contexto1.modelo.UsuarioPersona;
import co.edu.poli.contexto1.servicios.UsuarioVIP;

public class Principal {

	// PUNTO 2 - método polimórfico que recibe un parámetro de tipo supersuperclase
	public static void imprimirDescuento(Usuario usuario) {
		System.out
				.println("Descuento de " + usuario.getNombre() + ": " + usuario.calcularDescuento("2026-03-16") + "%");
	}

	// PUNTO 2 - método polimórfico que retorna un tipo supersuperclase
	public static Usuario crearUsuarioGenerico(Tipo_de_usuario tipo) {
		return new UsuarioPersona("102424524", "Aejandra Rueda", "Femenino", 20, "1.70", tipo, "alejita524@gmail.com",
				"3246847152", "Estudiante", "Universitario", "00000000", "O+");
	}

	public static void main(String[] args) {

		Tipo_de_usuario tipoHumano = new Tipo_de_usuario("TU001", "Humano", "N/A", "Mediano");
		Tipo_de_usuario tipoAnimal = new Tipo_de_usuario("TU002", "Animal", "Canina", "Pequeño");

		UsuarioPersona usuarioPersona = new UsuarioPersona("1024985449", "Nicolas Atehortua", "Masculino", 35, "1.70",
				tipoHumano, "nikolasd29@gmail.com", "3246847152", "Ingeniero", "Universitario", "1024985449", "O+");

		Enfermedad enfermedad1 = new Enfermedad("Diabetes", "Leve", "6 meses", "E001");
		Enfermedad enfermedad2 = new Enfermedad("Hipertension", "Media", "1 año", "E002");
		usuarioPersona.setEnfermedades(new Enfermedad[] { enfermedad1, enfermedad2 });

		UsuarioVIP usuarioVip = new UsuarioVIP("51604325", "Laura Gomez", "Femenino", 28, "1.65", tipoHumano,
				"laurita2026@gmail.com", "3101234567", "Medico", "Universitario", "2058741236", "A+", "Platino");

		Enfermedad enfermedad3 = new Enfermedad("Asma", "Leve", "Permanente", "E003");
		usuarioVip.setEnfermedades(new Enfermedad[] { enfermedad3 });

		UsuarioAnimal usuarioAnimal = new UsuarioAnimal("A001", "Rocky", "Macho", 3, "0.40", tipoAnimal,
				"perro@hotmail.com", "3009876543", "Perro", "Labrador", "Pequeño", true);

		Enfermedad enfermedad4 = new Enfermedad("Displasia", "Leve", "Fisioterapia", "E004");
		usuarioAnimal.setEnfermedades(new Enfermedad[] { enfermedad4 });

		Simulador simulador1 = new Simulador("S001", 2, true, "SimulatorX", "Gamer");
		Simulador simulador2 = new Simulador("S002", 4, true, "SimulatorX", "Profesional");

		Equipo equipo1 = new Equipo("EQ001", "Traje adaptativo", "5 años", "Espacial", "SpaceX", 50.5, "2x2x1");
		Equipo equipo2 = new Equipo("EQ002", "Botas estabilizadoras", "3 años", "Espacial", "SpaceX", 30.2, "1x1x1");
		Equipo[] equipos = { equipo1, equipo2 };

		Curso curso = new Curso("C001", "Básico", "Presencial", "10:00", equipos);

		Instructor instructor = new Instructor("I001", "Astronauta. Neil Armstrong III", "Gravedad Zero");

		// Atributo estatico
		System.out.println("\n********** ESTATICO **********");
		System.out.println("Fabricanet antes: " + Simulador.fabricante);
		Simulador.fabricante = "Google";
		System.out.println("Fabricante despues: " + Simulador.fabricante);

		// Sobrecarga
		System.out.println("\n********** SOBRECARGA **********");
		System.out.println("Descuento 1:  " + usuarioPersona.calcularDescuento("2024-01-15"));
		System.out.println("Descuento 2: " + usuarioPersona.calcularDescuento("2024-01-15", "Full"));

		// Sobreescritura
		System.out.println("\n********** SOBREESCIRTURA **********");
		System.out.println(
				"UsuarioPersona (Universitario +5% para nicolas): " + usuarioPersona.calcularDescuento("2024-01-15"));
		System.out
				.println("UsuarioVIP (minimo 30% + Platino de laura):  " + usuarioVip.calcularDescuento("2024-01-15"));
		System.out.println("UsuarioAnimal:  " + usuarioAnimal.calcularDescuento("2024-01-15"));

		// Objetos Turno
		System.out.println("\n********** OBJETOS TURNO **********");
		Turno turnoPersona = new Turno("TU001", usuarioPersona, "16/02/2026", "10:00", "13:00", "3 horas", instructor,
				simulador1, curso);
		Turno turnoVip = new Turno("TU002", usuarioVip, "17/02/2026", "14:00", "17:00", "3 horas", instructor,
				simulador1, curso);
		Turno turnoAnimal = new Turno("TU003", usuarioAnimal, "18/02/2026", "09:00", "11:00", "2 horas", instructor,
				simulador2, curso);

		System.out.println(turnoPersona);
		System.out.println(turnoVip);
		System.out.println(turnoAnimal);

		// PUNTO 1 - arreglo en la supersuperclase con 5 posiciones y 3 objetos de
		// subclases
		System.out.println("\n********** PUNTO 1 - ARREGLO SUPERSUPERCLASE **********");
		Usuario[] usuarios = new Usuario[3];
		usuarios[0] = usuarioPersona;
		usuarios[1] = usuarioVip;
		usuarios[2] = usuarioAnimal;

		for (int i = 0; i < usuarios.length; i++) {
			{
				// sobreescritura: cada subclase ejecuta su propio toString y calcularDescuento
				System.out.println(usuarios[i].toString());
				System.out.println("Descuento: " + usuarios[i].calcularDescuento("2026-03-16") + "%");
			}
		}

		// PUNTO 2 - metodo polimórfico
		System.out.println("\n********** PUNTO 2 - POLIMORFISMO **********");
		imprimirDescuento(usuarioPersona);
		imprimirDescuento(usuarioVip);
		imprimirDescuento(usuarioAnimal);

		Usuario generico = crearUsuarioGenerico(tipoHumano);
		System.out.println(generico.toString());

		// PUNTO 3 - uso del atributo final, metodo final y clase final

		System.out.println("\n********** PUNTO 3 - FINAL **********");

		// atributo final de Simulador (no se puede cambiar)
		System.out.println("VERSION final de Simulador: " + Simulador.VERSION);

		// metodo final de Simulador (no se puede sobreescribir)

		System.out.println(simulador1.obtenerInfo());
		// atributo final de UsuarioVIP (no se puede cambiar)

		System.out.println("Nivel VIP inicial de Laura (final): " + usuarioVip.nivelVipInicial);

		// clase final ConfiguracionSimulador (no se puede heredar)
		ConfiguracionSimulador config = new ConfiguracionSimulador("Gravedad Zero", "Avanzado", 90);
		System.out.println(config.toString());
	}
}