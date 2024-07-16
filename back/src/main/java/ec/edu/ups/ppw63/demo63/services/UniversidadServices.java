package ec.edu.ups.ppw63.demo63.services;

import java.util.List;

import ec.edu.ups.ppw63.demo63.business.GestionUniversidades;
import ec.edu.ups.ppw63.demo63.model.Universidad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("universidades")
public class UniversidadServices {
	
	@Inject
	private GestionUniversidades gUniversidades;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Universidad universidad) {
		try{
			gUniversidades.guardarUniversidades(universidad);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(universidad).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidad universidad) {
		try{
			gUniversidades.actualizarUniversidad(universidad);
			return Response.ok(universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try{
			gUniversidades.borrarUniversidad(codigo);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(universidad).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getUniversidades(){
		List<Universidad> universidads = gUniversidades.getUniversidades();
		if(universidads.size()>0)
			return Response.ok(universidads).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran universidads");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
