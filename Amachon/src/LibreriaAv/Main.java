package LibreriaAv;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Biblioteca biblio = new Biblioteca();
		

		Libro li = new Libro();
		Scanner ent = new Scanner(System.in);
		int op;
		boolean op1 = true;
		boolean sub1 = true;
		
		

		System.out.println(
				"Hola, para empezar la aplicacion de la libreria, por favor introduzca los socios y los libros dando"
				+ "a cualquier boton");
		String enter = ent.next();

		System.out.println("LIBROS");
		biblio.IntroducirLibro();
		System.out.println("SOCIOS");
		biblio.IntroducirSocio();
		System.out.println("RESERVAS");
		biblio.IntroducirReservas();
		System.out.println("\n" + "\n");
		
		try {
	
			do {

				System.out.println("################################# \n" + "1 - Alquilar Libro \n"
						+ "2 - Devolver Libro \n" + "3 - Ver todas las reservas\n"
						+ "4 - Ver el estado de una reserva\n" + "5 - Salir \n" + "################################");
				op = ent.nextInt();
				
				if (op > 0 && op <= 5 && op != 0) {
					switch (op) {
					case 1:

						do {

							System.out.println("********************************\n" + "1 - Disponibilidad libros \n"
									+ "2 - Alquilar libro\n" + "3 - Salir\n" + "*********************************");
							int sub = ent.nextInt();
							if (sub > 0 && sub < 4 && sub != 0) {
								switch (sub) {
								case 1:
									for (int i = 0; i < biblio.LibrosLista.size(); i++) {

										System.out.println(biblio.LibrosLista.get(i));
									}
									break;
								case 2:
									biblio.AlquilerDeLibro();
									break;
								case 3:
									sub1 = false;
									System.out.println("Muchas gracias por utilizar la libreria");
									break;
								}

							} else {
								System.out.println("Introduce un numero entre el 1 al 3");
							}

						} while (sub1);
						break;
					case 2:
						biblio.DevolverLibro();

						break;
					case 3:

						if (biblio.Reservas.size() == 0) {
							System.out.println("No hay ninguna reserva");
						} else {
							for (int i = 0; i < biblio.Reservas.size(); i++) {
								System.out.println(biblio.Reservas.get(i));
							}
						}
						break;
					case 4:
						biblio.ReservaLibros();

						break;
					case 5:
						op1 = false;
						System.out.println("Muchas gracias por utilizar la aplicacion");
						break;

					}
				} else {
					System.out.println("Introduce un valor entre el 1 al 5");
				}

			} while (op1);
		} catch (InputMismatchException ex) {
			System.out.println("Error, introduzca un valor numerico entre el 1 y el 5, vuelva empezar la aplicacion");
			
		}
		biblio.CopiaSeguridadSocio();
	}


	
	
}
