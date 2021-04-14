package LibreriaAv;

import java.util.ArrayList;

public class ClaseListaArray {

	public static void main(String[] args) {
		//entre <> se pone el tipo de datos, en el caso de un entero por Integer
				//lista dinamicas se va incrementando y decrementado a medida que se necesite
				ArrayList<String> lista = new ArrayList<String>();
				
				lista.add("hola");//por defecto es ponertelo al final de la lista
				lista.add("adios");
				lista.add(2, "mundo");//te pone en la posicion de donde quieras poner el String
				lista.add("baño");
				lista.add("Claro");
				
				System.out.println(lista.size());//para devolver el tamaño de la lista en entero
				
				lista.remove(2);// borra el la posicion que le indicas en este caso es Baño
				
				for(int i=0; i< lista.size(); i++) {
					if(lista.get(i).equals("adios")) { //modificar el elemnto de la lista
						lista.set(i, "mundo");
					}
					System.out.println(lista.get(i));
				}

	}

}
