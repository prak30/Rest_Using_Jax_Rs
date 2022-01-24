package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restapi.crud.crud.model.CrudModel;
import org.restapi.crud.crud.service.CrudService;



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
