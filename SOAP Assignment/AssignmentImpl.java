package com.au.soapAssignment;
import java.util.ArrayList;

import javax.jws.WebService;

@WebService(endpointInterface="com.au.soapAssignment.Assignment")
public class AssignmentImpl implements Assignment{
	ArrayList<Player> players = new ArrayList<Player>();
	@Override
	public Player getPlayers(int id){
		for(Player p:players){
			if(p.id == id){
				return p;
			}
		}
		return null;
	}
	@Override
	public void add(int id,String name,String country){
		Player p = new Player(id,name,country);
		players.add(p);
	}
	@Override
	public void remove(Player player){
		players.remove(players.indexOf(player));
	}
}
