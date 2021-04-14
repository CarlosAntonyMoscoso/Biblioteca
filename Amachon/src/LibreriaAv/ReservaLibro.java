package LibreriaAv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaLibro {
	
	Biblioteca biblio;
	
	private int NumeroReserva;
	private int NumeroSocio;
	private int NumeroIsbn;
	private LocalDate fecha;// hacer las fechas!
	

	ReservaLibro() {
		int NumeroReserva = 0;
		int NumeroSocio = 0;
		int NumeroIsbn = 0;
		LocalDate fecha ;
		

	}
	public ReservaLibro(String[] nuevoS) {
		
		this.NumeroReserva = Integer.parseInt(nuevoS[0]);
		this.NumeroSocio = Integer.parseInt(nuevoS[1]);
		this.NumeroIsbn = Integer.parseInt(nuevoS[2]);
		this.fecha = LocalDate.parse(nuevoS[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
	}

	ReservaLibro(int NumeroSocio, int NumeroIsbn, int NumeroReserva, String fecha) {
		this.NumeroReserva = NumeroReserva;
		this.NumeroSocio = NumeroSocio;
		this.NumeroIsbn = NumeroIsbn;
		this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}
	
	
	public int getNumeroReserva() {
		return NumeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		NumeroReserva = numeroReserva;
	}

	public int getNumeroSocio() {
		return NumeroSocio;
	}

	public void setNumeroSocio(int numeroSocio) {
		NumeroSocio = numeroSocio;
	}

	public int getNumeroIsbn() {
		return NumeroIsbn;
	}

	public void setNumeroIsbn(int numeroIsbn) {
		NumeroIsbn = numeroIsbn;
	}

	

	public LocalDate getFecha() {
		
		return fecha;
	}
	public String getFecha(boolean v) {
		
		return getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
		public String toString() { 
			return "***RESERVA " + getNumeroReserva() + "**** \n" + "- Numero de socio: " + getNumeroSocio() +
					"\n" + "- ISBN libro: " + getNumeroIsbn() + "\n" + "- Fecha de alquiler libro: "
					+ getFecha(true) +"\n"  + "******************* \n";
		
			
		}

}