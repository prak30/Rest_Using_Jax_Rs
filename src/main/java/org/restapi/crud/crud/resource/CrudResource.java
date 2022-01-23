package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.crud.crud.model.CrudModel;
import org.restapi.crud.crud.service.CrudService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class CrudResource {

	CrudService service = new CrudService();

	@POST
	@Path("/insertion")
	@Consumes(MediaType.APPLICATION_JSON)
	public CrudModel addUser(CrudModel user) {
		return service.insertUser(user);
	}
	
	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CrudModel> getUser() throws SQLException {
		return service.getUser();
	}
	
	@GET
	@Path("/retrievebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CrudModel> getUser(@PathParam("id") int id) throws SQLException {
		return service.getUserById(id);
	}
	
	@PUT
	@Path("/updateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public CrudModel updateUser(CrudModel user) {
		return service.updateUser(user);
	}
	
	@DELETE
	@Path("/deleteuserbyid/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		return service.deleteUser(id);
	}
	
	@GET
	@Path("/helloworld")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloWorld() throws SQLException {
		return "hello world";
	}

}
