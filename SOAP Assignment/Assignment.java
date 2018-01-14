package com.au.soapAssignment;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Assignment {
	@WebMethod
	public Player getPlayers(int id);
	@WebMethod
	public void add(int id,String name,String country);
	@WebMethod
	public void remove(Player player);
}
