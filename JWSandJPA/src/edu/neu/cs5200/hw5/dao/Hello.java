package edu.neu.cs5200.hw5.dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {
	@GET
	@Path("/")
	public String sayHello()
	{
		return "Hello!";
	}
}