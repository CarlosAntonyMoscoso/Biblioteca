package LibreriaAv;


public class Socio {

	private int id;
	private String nombre;
	private int Telefono;
	private String email;
	private int librosReserva;
	

	Socio() {
		int id = 0;
		String nombre = "";
		int Telefono = 0;
		String email = "";
		int librosReserva = 0;
		
	}

	Socio(int id, String nombre, int Telefono, String email, int librosReserva) {
		this.id = id;
		this.nombre = nombre;
		this.Telefono = Telefono;
		this.email = email;
		this.librosReserva = librosReserva;
		
	}
	public Socio(String[] nuevoS) {
		this.id = Integer.parseInt(nuevoS[0]);
		this.nombre = nuevoS[1];
		this.Telefono = Integer.parseInt(nuevoS[2]);
		this.email = nuevoS[3];
		this.librosReserva = Integer.parseInt(nuevoS[5]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public int getLibrosReserva() {
		return librosReserva;
	}

	public void setLibrosReserva(int librosReserva) {
		this.librosReserva = librosReserva;
	}
	public String toFichero() {
		
		return getId() + ";" +  getNombre() + ";" + getTelefono() + ";"+ getEmail() + ";"+ getLibrosReserva() + ";";
	}
	@Override
	public String toString() {
		return "Informacion del Socio: \n" + " -Numero de ID : " + getId() + "\n" + " -Nombre socio : "
				+ getNombre() + "\n" + " -Telefono contacto : " + getTelefono() + "\n" + " -Correo electronico: "
				+ getEmail() + "\n" + " -Libros Reservados: "  + getLibrosReserva() +"\n" + 
				"*******************" + "\n" ;
	}

}
