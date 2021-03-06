package IngerGYM.servicios;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Opinion;
import IngerGYM.entidades.ContadorAforo;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;


@Service
public class ServicioClientes {

	ContadorAforo Nado;
	ContadorAforo Zumb;
	ContadorAforo Gym;
	ContadorAforo Aq;
	
	@Autowired
	private RepositorioClientes repositorioClientes;

	@Autowired
	private RepositorioSalas repositorioS;
	@Autowired
	private RepositorioClases repositorioCl;
	
	@PostConstruct
	public void init() {
		
		
		//String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo
		Cliente paco=new Cliente("paco","paco@gmail.com",54,"434343","abcd",true);
		//repositorioClientes.save(paco);
		Salas piscina=new Salas("Piscina",2);
		//repositorioS.save(piscina);
		
		Salas gimnasio=new Salas("Gym",40);
		//repositorioS.save(gimnasio);
		
		Salas comun=new Salas("Zumba",50);
		//repositorioS.save(comun);
		
		//public Clases (Salas sala,String prof,String tipo,int dia, int hora)
		Clases AquaGym=new Clases(piscina,"Maria","AquaGYM",3,7);
		//repositorioCl.save(AquaGym);
		Clases NadoLibre=new Clases(piscina,"Juan","NadoLibre",5,2);
		//repositorioCl.save(NadoLibre);
		Clases Zumba=new Clases(comun,"Aitor","Zumba",1,8);
		//repositorioCl.save(Zumba);
		Clases gym=new Clases(gimnasio,"-","gym");
		//repositorioCl.save(gym);
		 Nado=new ContadorAforo(NadoLibre);
		 Zumb=new ContadorAforo(Zumba);
		 Gym=new ContadorAforo(gym);
		 Aq=new ContadorAforo(AquaGym);
	}

	public boolean reservarPiscina(int d,int h) {
		if(Nado.hayHueco(d,h)==true) {
			Nado.cogeAforo(d,h);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean reservarAqua(int d,int h) {
		if(Aq.hayHueco(d,h)==true) {
			Aq.cogeAforo(d,h);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean reservarZumba(int d,int h) {
		if(Zumb.hayHueco(d,h)==true) {
			Zumb.cogeAforo(d,h);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean reservarGimnasio(int d,int h) {
		if(Gym.hayHueco(d,h)==true) {
			Gym.cogeAforo(d,h);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Collection<Cliente> getUsuarios() {
		return repositorioClientes.findAll();
	}
		
	
	public void guardarCliente(Cliente cliente2) {
		repositorioClientes.save(cliente2);
	}
	
	public Cliente getCliente(int numero) {
		List <Cliente> listaClientes=repositorioClientes.findAll();
		
		return listaClientes.get(numero);
	}

	public int existeCliente(String usuario,String email) {
		
		List <Cliente> listaClientes=repositorioClientes.findAll();
		boolean encontrado=false;
		int pos=0;
		for(Cliente cliente : listaClientes) {
			
			if(cliente.getUsuario().equals(usuario) || cliente.getEmail().equals(email)  ) {
				encontrado = true;
				break;
			}
			pos++;
		}
		if(encontrado==true) {
			return pos;
		}else {
			return -1;
		}
	}

	public int getPlazasZumba() {
		int d=1;
		int h=8;
		
		return Zumb.getAforo(d, h);
	} 
	
	public int getPlazasAquagym() {
		int d=3;
		int h=7;
		
		return Aq.getAforo(d, h);
	} 
}