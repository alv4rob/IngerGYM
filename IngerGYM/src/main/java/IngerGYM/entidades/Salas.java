package IngerGYM.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Salas {
	
	private int aforoMAX;
	private String nombre;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Salas(String a,int n) {
	this.nombre=a;
	this.aforoMAX=n;
	
	}

	
	public boolean compHora(int d, int h) {
		 Auxiliar aux=new Auxiliar();
		int reserva=d*7+h;
		return aux.estaLibre(reserva);	
	}
	
	
	public void cogerHora(int d, int h) {
		int reserva=d*7+h;
		Auxiliar aux=new Auxiliar();
		aux.reservar(reserva);
	}
	public void cogerHora() {
		
		Auxiliar aux=new Auxiliar();
		aux.reservar();
	}
	
	public int getAforoMAX() {
		return aforoMAX;
	}

	public void setAforoMAX(int aforoMAX) {
		this.aforoMAX = aforoMAX;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}