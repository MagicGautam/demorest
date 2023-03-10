package com.gautam.demorest;

import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource 
{
	
	AlienRepository repo= new AlienRepository();
	@GET  //THIS (GETALIEN()) WILL BE CALLED WHENEVER WE GET A GET REQUEST
	@Produces(MediaType.APPLICATION_XML)  //SPECIFYING THE TYPE OF DATA RETURNING HERE IN OUR CASE XML.
	public List<Alien> getAliens()
	{
		System.out.println("getAliens Called.....");
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")  //curly braces means this is a placeholder for an object.
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id)  //if your path request has any "ID" variable requested, using PathPram the id will be replaced by a inputted id.
	{
		return repo.getAlien(id);
	}
	
	
	//get is for fetching resource. POST is for creating resource. Put is for updating resource, Delete is for deleting a resource.
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})  //specifying the input type from the client.
	public Alien createAlien(Alien a1)
	{
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})  //specifying the input type from the client.
	public Alien updateAlien(Alien a1)
	{
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0)
		{
			repo.create(a1);
		}
		else 
		{
		repo.update(a1);
		}
		return a1;
	}
	@DELETE
	@Path("alien/{id}") 
	public Alien killAlien(@PathParam("id") int id)
	{
		Alien a= repo.getAlien(id);
		if(a.getId()!=0)
		{
		repo.delete(id);
		}
		return a;
	}
}
