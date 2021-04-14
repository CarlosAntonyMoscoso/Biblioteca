package LibreriaAv;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class IntroducirLibrosPorFicheros {

	public static void main(String[] args) {

		ArrayList<Libro> lista = new ArrayList<Libro>();
		Libro lib;
		String array[];
		int cont = 100;

		try {
			FileReader fr = new FileReader("C:\\Users\\CARLITOS\\Desktop\\fichero\\Libro1.csv");// pasar un archivo csv
			BufferedReader br = new BufferedReader(fr);//aqui se almanacena

			String linea = br.readLine();//aqui lo lee

			while (linea != null) {//aqui lee todo el archivo

				array = linea.split(";");//aqui almacenamos en un array los datos del archivo csv y separmaos con el split ;
				
				lista.add(lib = new Libro(cont,array[0],array[1], Integer.parseInt(array[2]),Float.parseFloat(array[3])));
				//en la linea 25 estamos añadiendo el libro a la arrayList
				linea = br.readLine();
				cont++;
				
				
				
			}
			for (int i = 0; i < lista.size(); i++) {//este bucle para que se vea la lista
				System.out.println(lista.get(i));
			}
		} catch (IOException e) {
			System.out.println("fichero no encontrado");
		}

	}

}
