import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class StudentForm extends HttpServlet {

	
	private Student student;
	ArrayList<Student> store;


	// Method to handle GET method request.
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		
		store = (ArrayList<Student>) this.getServletContext().getAttribute("store");
		
		if(store == null){
			store = new ArrayList<Student>();
			this.getServletContext().setAttribute("store", store);
		}
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String s = new String();
		StringBuilder subject = new StringBuilder(s);

		if(request.getParameter("maths")!= null){
			subject = subject.append(" Maths ");
		}
		if(request.getParameter("physics")!= null){
			subject = subject.append(" Physics ");
		}
		if(request.getParameter("chemistry")!= null){
			subject = subject.append(" Chemistry ");
		}

		
		student = new Student(name, address, age, subject.toString());
		
		store.add(student);
		
		System.out.println("Checking store");
		for(Student student : store){
			System.out.println(student.toString());
		}
		
		// Set response content type
		response.setContentType("text/html");
				

		PrintWriter out = response.getWriter();
		String title = "Student Servlet";
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " +
						"transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<p>"+ "Student added to a store" +"</p>"+
				"<a href=\"http://localhost:8080/FirstApp/StudentForm.html\">"+"Add Sudents"+"</a>"+
				"<br><br>"+
				"<a href=\"http://localhost:8080/FirstApp/StudentSearch.html\">"+"Search Sudents"+"</a>"+
				"</body></html>");
	}



	// Method to handle POST method request.
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		doGet(request, response);
	}
}
