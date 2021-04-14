package LibreriaAv;


 
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Biblioteca biblio = new Biblioteca();

		Scanner ent = new Scanner(System.in);
		boolean op4 = true;
		boolean op3 = true;
		boolean op2 = true;
		boolean op6 = true;
		boolean op5 = true;
		boolean op7 = true;
		
		
		do {
			
			System.out.println("MENU PRINCIPAL  \n" + "************************** \n" + "QUE DESEA HACER : \n"
					+ "1) Dar de alta un libro o socio \n" + "2) Ver listado de libro o socio \n"
					+ "3) Borrar un Libro o Socio \n" + "4) Buscar un Libro o Socio \n" +"5) Salir \n" 
					+ "**************************");
			int op = ent.nextInt();

			if (op > 0 && op == 1 || op == 2 || op == 3 || op == 4 || op == 5) {
				
				switch (op) {

				case 1:// dar de alta
					do {
						System.out.println("\n" + "Que opcion deseas escoger : \n"+"\n" + "1) Dar de alta un libro \n"
								+ "2) Dar de alta un socio \n" + "3) Volver al menu principal" + "\n");
						int pos = ent.nextInt();
						if (pos > 0 && pos == 1 || pos == 2 || pos == 3) {
							switch (pos) {

							case 1:
								biblio.AltaLibro();
								System.out.print(biblio.LibrosLista);
								break;
							case 2:
								biblio.AltaSocio();
								System.out.print(biblio.SociosLista);
								break;
							case 3:
								op2 = false;
								break;
							}
						} else {
							System.out.println("Introduce un valor entre el 1 al 3 \n");
						}
					} while (op2);
					System.out.println("Volvera al menu principal \n");
					break;
					
				case 2:// ver listado
					do {
						System.out.println("\n" + "Que opcion deseas coger : \n" + "1) Ver la lista de libro \n"
								+ "2) Ver la lista de socio \n" + "3) Volver al menu principal" + "\n");
						int pos = ent.nextInt();
						if (pos > 0 && pos == 1 || pos == 2 || pos == 3) {
							switch (pos) {

							case 1:
								for (int i = 0; i < biblio.LibrosLista.size(); i++) {
									System.out.println(biblio.LibrosLista.get(i));
								}
								break;
							case 2:
								for (int i = 0; i < biblio.SociosLista.size(); i++) {
									System.out.println(biblio.SociosLista.get(i));
								}
								break;
								
							case 3:
								op3 = false;
								break;
							}
						} else {
							System.out.println("Introduce un valor entre el 1 al 3\n");
						}
					} while (op3);
					System.out.println("Volvera al menu principal \n");
					break;
				case 3:// borrar algun dato
					
					do {
						System.out.println("MENU DE BORRAR DATOS " + "\n" + "Que opcion deseas escoger : \n"
								+ "1) Borrar un libro \n" + "2) Borrar un socio \n" + "3) Volver al menu principal" + "\n");
						int pos = ent.nextInt();
						if (pos > 0 && pos == 1 || pos == 2 || pos == 3) {
							switch (pos) {

							case 1:
								do {
									System.out.println("\n" + "Que opcion deseas coger : \n" + "1) Ver la lista de libro \n"
											+ "2) Borrar libro \n" + "3) Volver al menu principal" + "\n");
									int pos1 = ent.nextInt();
									if (pos1 == 1) {
										for (int i = 0; i < biblio.LibrosLista.size(); i++) {
											System.out.println(biblio.LibrosLista.get(i));
										}
									} else if (pos1 == 2) {
										biblio.BajaLibro();
										System.out.print("Se ha borrado correctamente \n" + biblio.LibrosLista +"/n");
									} else if (pos1 == 3) {
										op6 = false;
									}
								} while (op6);
								System.out.println("Volvera al menu de borrar datos \n");
								break;
								
							case 2:
								do {
									System.out.println("\n" + "Que opcion deseas coger : \n" + "1) Ver la lista de Socios \n"
											+ "2) Borrar Socio \n" + "3) Volver al menu principal" + "\n");
									int pos1 = ent.nextInt();
									if (pos1 == 1) {
										for (int i = 0; i < biblio.SociosLista.size(); i++) {
											System.out.println(biblio.SociosLista.get(i));
										}
									} else if (pos1 == 2) {
										biblio.BajaSocio();
										System.out.print("Se ha borrado correctamente /n" + biblio.SociosLista +"/n");
									} else if (pos1 == 3) {
										op7 = false;
									}
								} while (op7);
								break;
								
							case 3:
								op5 = false;
								break;
							}
						} else {
							System.out.println("Introduce un valor entre el 1 al 3 \n");
						}
					} while (op5);
					System.out.println("Volvera al menu principal \n");
				
			
					break;
				case 4://buscar libro o socio
					//ACABAR!!!!!!
					break;
				case 5:
					op4 = false;
					System.out.println("Muchas gracias por utilizar la aplicacion");
					break;
				}
			} else {
				System.out.println("Introduce un valor entre el 1 al 5");
			}
			
		} while (op4);
		
	}
}


	