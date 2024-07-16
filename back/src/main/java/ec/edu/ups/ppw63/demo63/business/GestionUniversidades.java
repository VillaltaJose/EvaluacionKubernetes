package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.UniversidadDAO;
import ec.edu.ups.ppw63.demo63.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidades {

	@Inject
	private UniversidadDAO daoUniversidad;
	
	public void actualizarUniversidad(Universidad universidad) throws Exception {
		Universidad cli = daoUniversidad.read(universidad.getCodigo());
		if (cli != null){
			daoUniversidad.update(universidad);
		}else {
			throw new Exception("Universidad no existe");
		}
	}
	
	public void guardarUniversidades(Universidad universidad) {
		System.out.println("Codigo: " + universidad.getCodigo());
		Universidad cli = daoUniversidad.read(universidad.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + universidad);
			daoUniversidad.update(universidad);
		}else {
			daoUniversidad.insert(universidad);
		}
	}
	
	public void borrarUniversidad(int codigo) {
		daoUniversidad.remove(codigo);
	}
	
	public List<Universidad> getUniversidades(){
		return daoUniversidad.getAll();
	}
}
