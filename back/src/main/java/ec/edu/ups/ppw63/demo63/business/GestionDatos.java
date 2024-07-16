package ec.edu.ups.ppw63.demo63.business;

import ec.edu.ups.ppw63.demo63.dao.ClienteDAO;
import ec.edu.ups.ppw63.demo63.dao.UniversidadDAO;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import ec.edu.ups.ppw63.demo63.model.Universidad;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup      //Hace que no espere a que un cliente lo llame sino que se ejecutara ni bien se lanza la aplicacion
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private UniversidadDAO daoUniversidad;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0107193708");
		cliente.setDireccion("Racar");
		cliente.setNombre("Daniel Collaguazo");
		
		daoCliente.insert(cliente);
		
		Universidad universidad = new Universidad();
		universidad.setCodigo(1);
		universidad.setNombre("UPS Cuenca");
		universidad.setPais("Ecuador");
		daoUniversidad.insert(universidad);
	}
}
