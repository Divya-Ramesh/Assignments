package com.au.soapAssignment;
import javax.xml.ws.Endpoint;

public class AssignmentPublisher {
	public static void main(String[] args) {
		  Endpoint.publish("http://localhost:8080/WS/Assignment",new AssignmentImpl());
		 }
}
