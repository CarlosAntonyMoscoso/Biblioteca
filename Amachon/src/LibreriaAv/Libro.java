package LibreriaAv;

public class Libro {
	
	
	
	private int ISBN;
	private String titulo;
	private String autor;
	private int ejemplares;
	private float precio;

	public Libro() {

		int IBSN = 0;
		String titulo = "";
		String autor = "";
		int ejemplares = 0;
		float precio = 0.0f;
	}
	public Libro(String[] nuevoS) {
		this.ISBN = Integer.parseInt(nuevoS[0]);
		this.titulo = nuevoS[1];
		this.autor = nuevoS[2];
		this.ejemplares = Integer.parseInt(nuevoS[3]);
		this.precio = Float.parseFloat(nuevoS[4]);
	}

	public Libro(int ISBN, String titulo, String autor, int ejemplares, float precio) {

		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.precio = precio;
	}
	
	

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Informacion de los libros: \n" + " -Numero de ISBN : " + getISBN() + "\n" + " -Titulo : " + getTitulo()
				+ "\n" + " -Autor : " + getAutor() + "\n" + " -Ejemplares: " + getEjemplares() + "\n"+ " -Precio por dia : "
				+ getPrecio() + "\n" + "*******************" + "\n";
	}

}