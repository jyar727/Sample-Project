package com.example.jasongwt.server;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static List<user> users = new LinkedList<user>();
	static{
		List<String> children = new LinkedList<String>();
		user user1 = new user("Dom David",21,children);
		children.add("Molly Long");
		user user2 = new user("Bill Bob",32,children);
		children.add("Joe Smoe");
		user user3 = new user ("jane doe",37,children);
	}
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try{
			 System.out.println("inside doGet");
			 JSONObject responseObj = new JSONObject();
			 List<JSONObject> userObjects = new LinkedList<JSONObject>();
			 for (user user : users) {
				 JSONObject userObj = new JSONObject();
				 	     
				 	userObj.put("name", user.getName());
				 	userObj.put("company", user.getAge());
				 	     
				 	    List<JSONObject> childrenObjects = new LinkedList<JSONObject>();
				 	    for (String child : user.getChildren()) {
				 	     JSONObject childObj = new JSONObject();
				 	    childObj.put("price", child);
				 	    childrenObjects.add(childObj);
				 	    }
				 	     
				 	    userObj.put("prices", childrenObjects);
				 	     
				 	    userObjects.add(userObj);				 	 
				  }
			 
			    responseObj.put("users", userObjects);
			    PrintWriter writer = resp.getWriter();
			    writer.write(responseObj.toString());
			    writer.flush();
		 }	 
		 catch (Exception e) {  
			 	   e.printStackTrace();
			 	   throw new ServletException(e);
		 }
	 }
}
