package LibreriaAv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	public ArrayList<Libro> LibrosLista;// metemos la clase Libro en la lista
	public ArrayList<Socio> SociosLista;// metemos la clase Socio en la lista
	public ArrayList<ReservaLibro> Reservas;

	public Biblioteca() {
		LibrosLista = new ArrayList<Libro>();
		SociosLista = new ArrayList<Socio>();
		Reservas = new ArrayList<ReservaLibro>();
	}

	public void AltaLibro() {
		Libro LibroNuevo = new Libro();// dar de alta un nuevo objeto
		Scanner ent = new Scanner(System.in);

		/// para dar de alta un libro y control de errores para q no se repita el mismo
		/// ISBN
		if (LibrosLista.size() > 0) {
			// int posUltimoLibro = Libros.size()-1;
			// Libro UltimoLibro = Libros.get(posUltimoLibro);
			// int ultimoISBN = UltimoLibro.getISBN();
			// int nuevoISBN = ultimoISBN + 1;
			LibroNuevo.setISBN(LibrosLista.get(LibrosLista.size() - 1).getISBN() + 1);
		} else {
			LibroNuevo.setISBN(100);
		}

		System.out.println("Introduce nombre del libro");
		LibroNuevo.setTitulo(ent.nextLine());
		System.out.println("Introduce nombre del autor");
		LibroNuevo.setAutor(ent.nextLine());
		System.out.println("Introduce numero del ejemplares");
		LibroNuevo.setEjemplares(ent.nextInt());
		System.out.println("Introduce precio del libro");
		LibroNuevo.setPrecio(ent.nextFloat());

		LibrosLista.add(LibroNuevo);

	}

	public void AltaSocio() {
		Scanner ent = new Scanner(System.in);
		Socio SocioAlta = new Socio();

		if (SociosLista.size() > 0) {

			int ultimoSocio = SociosLista.size() - 1;
			SociosLista.get(ultimoSocio).getId();
			SocioAlta.setId(SociosLista.get(ultimoSocio).getId() + 1);

		} else {
			SocioAlta.setId(1);
		}
		System.out.println("INTRODUCE EL NOMBRE SOCIO");
		SocioAlta.setNombre(ent.nextLine());
		System.out.println("INTRODUCE EL TELEFONO SOCIO");
		SocioAlta.setTelefono(ent.nextInt());
		System.out.println("INTRODUCE SU CORREO");
		SocioAlta.setEmail(ent.next());
		SocioAlta.setLibrosReserva(0);
		SociosLista.add(SocioAlta);
	}

	public void BajaLibro() {
		Scanner ent = new Scanner(System.in);

		System.out.println("Para borrar un libro, introduce el ISBN");
		int ISBN = ent.nextInt();
		for (Libro a : LibrosLista) {

			if (ISBN == a.getISBN()) {

				LibrosLista.remove(a);
			}

		}
	}

	public void BajaSocio() {
		Scanner ent = new Scanner(System.in);

		System.out.println("Para borrar un socio, introduce el ID");
		int IDSocio = ent.nextInt();
		for (Socio b : SociosLista) {

			if (IDSocio == b.getId()) {

				SociosLista.remove(b);
			}

		}
	}

	// public void BuscaLibro() {
	// ACABAR!!!

//	}

	public void IntroducirLibro() {

		Libro lib;
		String array[];
		int cont = 100;

		try {
			FileReader fr = new FileReader("C:\\Users\\CARLOS\\Desktop\\fichero\\Libro1.txt");// pasar un archivo csv
			BufferedReader br = new BufferedReader(fr);// aqui se almanacena

			String linea = br.readLine();// aqui lo lee

			while (linea != null) {// aqui lee todo el archivo

				array = linea.split(";");// aqui almacenamos en un array los datos del archivo csv y separmaos con el
											// split ;

				LibrosLista.add(lib = new Libro(cont, array[0], array[1], Integer.parseInt(array[2]),
						Float.parseFloat(array[3])));
				// en la linea 25 estamos añadiendo el libro a la arrayList
				linea = br.readLine();
				cont++;

			}
			for (int i = 0; i < LibrosLista.size(); i++) {// este bucle para que se vea la lista
				System.out.println(LibrosLista.get(i));
			}
		} catch (IOException e) {
			System.out.println("fichero no encontrado");
		}

	}

	public void IntroducirSocio() {

		Socio soc;
		String array[];
		int cont = 1;

		try {
			FileReader fr = new FileReader("C:\\Users\\CARLOS\\Desktop\\fichero\\Socio1.txt");// pasar un archivo csv
			BufferedReader br = new BufferedReader(fr);// aqui se almanacena

			String linea = br.readLine();// aqui lo lee

			while (linea != null) {// aqui lee todo el archivo

				array = linea.split(";");// aqui almacenamos en un array los datos del archivo csv y separmaos con el
											// split ;

				SociosLista.add(soc = new Socio(cont, array[0], Integer.parseInt(array[1]), array[2],
						Integer.parseInt(array[3])));
				// en la linea 25 estamos añadiendo el libro a la arrayList
				linea = br.readLine();
				cont++;

			}
			for (int i = 0; i < SociosLista.size(); i++) {// este bucle para que se vea la lista
				System.out.println(SociosLista.get(i));
			}
		} catch (IOException e) {
			System.out.println("fichero no encontrado");
		}
	}

	
	public void IntroducirReservas() {
		// fecha ya esta, ahora igualarlo y almacenarlo en Libro y Socio
		ReservaLibro r;

		String array[];

		try {
			FileReader fr = new FileReader("C:\\Users\\CARLOS\\Desktop\\fichero\\Reservas1.txt");
			BufferedReader br = new BufferedReader(fr);

			String linea;

			while (br.ready()) {
				linea = br.readLine();
				array = linea.split(";");
				r = new ReservaLibro(array);
				Reservas.add(r);

				for (int e = 0; e < Reservas.size(); e++) {

					for (int s1 = 0; s1 < SociosLista.size(); s1++) {

						if (Reservas.get(e).getNumeroSocio() == SociosLista.get(s1).getId()) {

							SociosLista.get(s1).setLibrosReserva(+1);
						}
					}

					for (int s2 = 0; s2 < LibrosLista.size(); s2++) {
						if (Reservas.get(e).getNumeroIsbn() == LibrosLista.get(s2).getISBN()) {
							LibrosLista.get(s2).setEjemplares(LibrosLista.get(s2).getEjemplares() - 1);
						}
					}
				}

			}
			for (int i = 0; i < Reservas.size(); i++) {// este bucle para que se vea la lista

				System.out.println(Reservas.get(i));
			}

		} catch (IOException e) {
			System.out.println("Fichero no encontrado");
		}

	}

	public void AlquilerDeLibro() {// falta Try and Catch y tambien la fecha y los dias reservas

		ReservaLibro lista = new ReservaLibro();

		Scanner ent = new Scanner(System.in);
		boolean flag = true;
		boolean flag2 = true;

		int day, month = 04, year = 2021;

		if (Reservas.size() > 0) {
			lista.setNumeroReserva(Reservas.get(Reservas.size() - 1).getNumeroReserva() + 1);
		} else {
			lista.setNumeroReserva(1);
		}
//////////////////////////////////////////////////LIBRO/////////////////////////////////////////

		do {

			System.out.println("INTRODUZCA EL ISBN DEL LIBRO QUE DESEA ALQUILAR EL SOCIO");
			int op2 = ent.nextInt();

			for (Libro l : LibrosLista) {

				if (op2 == l.getISBN()) {

					if (l.getEjemplares() > 0) {

						l.setEjemplares(l.getEjemplares() - 1);

						lista.setNumeroIsbn(op2);

						System.out.println(l);
						flag = false;

					} else if (l.getEjemplares() == 0) {
						System.out.println("Fijese en los ejemplares, no hay stock, elija otra opcion");
					}
				}
			}

		} while (flag);

//////////////////////////////////////////////////SOCIO/////////////////////////////////////////
		do {
			System.out.println("INTRODUZCA EL ID SOCIO");
			int op = ent.nextInt();
			if (op > 0 && op <= 5 && op != 0) {
				for (Socio a : SociosLista) {

					if (a.getId() == op) {
						a.setLibrosReserva(a.getLibrosReserva() + 1);
						lista.setNumeroSocio(op);
						System.out.println(a);

						flag2 = false;
					}

				}
			} else {
				System.out.println("Introduzca un numero de socio de la lista por favor");
				for (int i = 0; i < SociosLista.size(); i++) {
					System.out.println(SociosLista.get(i));

				}
			}

		} while (flag2);

		day = (int) (Math.random() * 10) + 1;

		lista.setFecha(LocalDate.of(year, month, day));

		Reservas.add(lista);

	}

	public void DevolverLibro() {

		LocalDate FechaDevolucion = LocalDate.now();

		Scanner ent = new Scanner(System.in);
		float totalDias = 0.00f;
		boolean flag = true;
		boolean flag2 = true;
		boolean flag3 = true;

		if (Reservas.size() == 0) {
			System.out.println("Error no hay ninguna reserva echa ");
		} else {
			do {

				System.out.println("Introduzca el numero socio : ");
				int op = ent.nextInt();
				System.out.println("Acontinuacion se le mostrara las reservas echa por el cliente");
				if (op < SociosLista.size() && op != 0) {

					for (Socio a : SociosLista) {

						if (a.getId() == op) {
							if (a.getLibrosReserva() == 0) {
								System.out.println("Error tiene 0 libros reservados");
							} else {
								for (int i = 0; i < Reservas.size(); i++) {
									if (Reservas.get(i).getNumeroSocio() == op) {
										System.out.println(Reservas.get(i));

									}

								}
								System.out.println(a);
								a.setLibrosReserva(a.getLibrosReserva() - 1);
								flag = false;
							}
						}

					}

				} else {
					System.out.println("Introduce por favor un numero de socio valido");
					for(int i = 0; i < SociosLista.size(); i ++) {
						System.out.println(SociosLista.get(i).getId());
					}
				}

			} while (flag);

			/////////////////////////////////// LIBRO//////////////////////////////////

			int op3;

			do {
				System.out.println("Que reserva desea devolver:");
				op3 = ent.nextInt();
				for (int k = 0; k < Reservas.size(); k++)
					if (op3 != Reservas.get(k).getNumeroReserva()) {
						System.out.println("Introduce un numero de reserva valido");
					} else {
						do {
							for (Libro l : LibrosLista) {

								if (Reservas.get(op3 - 1).getNumeroIsbn() == l.getISBN()) {// try and catch para q no
																							// rompa por la
																							// poscicion arraylista de
																							// Reservas

									l.setEjemplares(l.getEjemplares() + 1);
									System.out.println(l);
									for (ReservaLibro lista1 : Reservas) {
										if (Reservas.get(op3 - 1).getFecha() == lista1.getFecha()) {
											Period period = Period.between(lista1.getFecha(), FechaDevolucion);

											totalDias = (float) (period.getDays() * l.getPrecio());
											System.out.println(
													"Se le mostrara el importe total abonar por los dias de alquiler: \n"
															+ "Dias: " + period.getDays() + "\n" + "Importe total: "
															+ totalDias + "€");

										}
									}
									flag2 = false;
								}

							}
						} while (flag2);
						flag3 = false;
					}
			} while (flag3);

			Reservas.remove(op3 - 1);

			for (ReservaLibro r : Reservas) {
				if (r.getNumeroReserva() > op3 - 1) {
					r.setNumeroReserva(r.getNumeroReserva() - 1);
				}
			}
		}
	}

	public void ReservaLibros() {// queda pulirle
		Scanner ent = new Scanner(System.in);
		System.out.println("Tienes un total de reservas de: " + Reservas.size());
		for (int o = 0; 0 < Reservas.size(); o++) {
			System.out.println(Reservas.get(o));
			System.out.println("Elige la reserva que quieres visualizar");

			int op = ent.nextInt();

			for (int e = 0; e < Reservas.size(); e++) {
				if ( (op-1)== Reservas.get(e).getNumeroReserva()) {

					if (Reservas.size() == 0) {
						System.out.println("No hay ninguna reserva");
					} else {
						System.out.println("El orden va en funcion del numero de socio");
						for (Socio a : SociosLista) {
							for (int i = 0; i < Reservas.size(); i++) {
								if (Reservas.get(i).getNumeroSocio() == a.getId()) {
									System.out.println("\n ////////////////////////////// \n" + Reservas.get(i));
									System.out.println(a);
									for (Libro l : LibrosLista) {
										if (Reservas.get(i).getNumeroIsbn() == l.getISBN()) {
											System.out.println(l + "////////////////////////////// \n");
										}

									}
								}
							}

						}
					}
				}
			}
		}
	}
	public void CopiaSeguridadSocio() throws IOException {

		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\Users\\CARLOS\\Desktop\\fichero\\Socio1.txt", false));

			bw.newLine();

			// aqui hacer un for each dependiendo de Reservas/Socio/Libro
			for (Socio s : SociosLista) {
				bw.write(s.toFichero());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("fichero no encontrado");
		}

	}
	

}