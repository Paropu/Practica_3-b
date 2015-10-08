import java.util.Calendar;
import java.util.GregorianCalendar;

public class Vuelo {

	private String identificador; // Atributos.
	private String companhia;
	private String coste;
	private String horaSalida; // CAMBIAR
	private String horaLlegada; // CAMBIAR
	private String duracion;

	public Vuelo(String identificador, String companhia, String coste, String horaSalida, String horaLlegada, String duracion) { // Metodo
																																	// "constructor".
		this.identificador = identificador;
		this.companhia = companhia;
		this.coste = coste;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.duracion = duracion;
	}

	public String getIdentificador() { // Metodos "getter"
		return identificador;
	}

	public String getCompanhia() {
		return companhia;
	}

	public String getCoste() {
		return coste;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	@Override
	public String toString() { // Metodo toString() modificado para mostrar las propiedades del vuelo.
		String mensaje = identificador + " " + companhia + " " + coste + " " + horaSalida + " " + horaLlegada + " Duracion: " + duracion;
		return mensaje;
	}

	// CREAR METODO QUE CALCULE LA DURACION DEL VUELO
	public static String duracionVuelo(String hora1, String hora2) {

		// Separo en dos strings
		String TimeSalida[] = hora1.split(":");
		String TimeLlegada[] = hora2.split(":");

		// Creo dos calendarios con ambas horas
		Calendar Salida = new GregorianCalendar(0, 0, 0, Integer.parseInt(TimeSalida[0]), Integer.parseInt(TimeSalida[1]));
		Calendar Llegada = new GregorianCalendar(0, 0, 0, Integer.parseInt(TimeLlegada[0]), Integer.parseInt(TimeLlegada[1]));

		// Calculo tiempo entre fechas en milisegundos
		long diferencia = (Llegada.getTimeInMillis() - Salida.getTimeInMillis());
		float n_millisec = new Float(diferencia); // convierto en float

		float divisor = (float) 3.6E6;// (1000*3600) milisec a horas
		int hora = (int) Math.floor(n_millisec / divisor);
		n_millisec %= divisor; // Resto

		divisor = 60000; // millisec a minutos
		int min = (int) Math.floor(n_millisec / divisor);

		return Integer.toString(hora) + ":" + Integer.toString(min);
	}
}