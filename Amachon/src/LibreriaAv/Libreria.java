package LibreriaAv;

import java.util.ArrayList;
import java.util.Arrays;

public class Libreria {

	public static void main(String[] args) {
		
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		Libro quijote = new Libro(1,"El Quijote","Cervantes",3,20.00f);
		Libro principito = new Libro(2,"El principito","Anonimo",6,50.00f);
		
		
		lista.add(quijote);// añade dentro de la lista el objeto quijote
		lista.add(principito);//añade dentro de la lista el objeto principito
		lista.add(new Libro(3,"Don Salon","Panini",2,60.00f));//crear un objeto nuevo 
		
		lista.get(2).setISBN(222);// cambiar el valor del ISBN a 222 en vez de 3
		
		System.out.println(lista.size());
		lista.set(2, quijote);//machaca el valor y cambiar Don salon porq es la posicion 3
								//y lo cambia por el quijote
		for(int i =0; i < lista.size(); i++) {
			System.out.println(lista.get(i));//para mostrar la lista del array con los getters
		}
		
	}

}
