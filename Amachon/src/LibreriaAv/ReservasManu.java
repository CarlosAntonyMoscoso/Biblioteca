package LibreriaAv;

import java.time.LocalDate;

public class ReservasManu {

	private Libro lib;
	private Socio soc;
	private LocalDate fecha;
	
	ReservasManu(){
		lib = null;
		soc = null;
		fecha = null;
	}
	
	ReservasManu(Libro lib, Socio soc, LocalDate fecha){
		
		this.lib = lib;
		this.soc = soc;
		this.fecha = fecha;
	}

	public Libro getLib() {
		return lib;
	}

	public void setLib(Libro lib) {
		this.lib = lib;
	}

	public Socio getSoc() {
		return soc;
	}

	public void setSoc(Socio soc) {
		this.soc = soc;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
