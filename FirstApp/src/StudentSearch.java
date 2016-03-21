import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSearch extends HttpServlet {
	
	String message;
	String name;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		name = request.getParameter("name");
		System.out.println("Searched name: "+ name);
		
		response.setContentType("text/html");
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		String title = "Using GET Method to Read Form Store";
		
		response.getWriter().println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<a href=\"http://localhost:8080/FirstApp/StudentForm.html\">"+"Add Sudents"+"</a>"+
				"<br><br>"+
				"<a href=\"http://localhost:8080/FirstApp/StudentSearch.html\">"+"Search Sudents"+"</a>"+
				"</body></html>");
		
		ArrayList<Student> store = (ArrayList<Student>) this.getServletContext().getAttribute("store");
		if(store == null){
			message = "no students in store";
			System.out.println(message);
			response.getWriter().append(
					"<p>"+ message +"</p>"		
			);
			
		}else{
			System.out.println("Store size: " + store.size());
			
			int count = 0;
			for(Student s: store){
				
				if(s.getName().equals(name)){
					count++;
					System.out.println(s.toString());
					response.getWriter().append(
							"<ul>\n" +
							"  <li><b>Name</b>: "
							+ name + "\n" +
							"  <li><b>Address</b>: "
							+ s.getAddress() + "\n" +
							"  <li><b>Age</b>: "
							+ s.getAge() + "\n" +
							"  <li><b>Subject</b>: "
							+ s.getSubject() + "\n" +
							"</ul>\n");
				}
				
			}
			
			if(count==0){
				message = "no students found by the name " + name;
				System.out.println(message);
				response.getWriter().append(
						"<p>"+ message +"</p>"		
				);
			}
		}
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
