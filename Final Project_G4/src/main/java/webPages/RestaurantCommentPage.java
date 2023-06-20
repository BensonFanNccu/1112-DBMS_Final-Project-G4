package webPages;

import controllers.UserManager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantCommentPage")
public class RestaurantCommentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RestaurantCommentPage() {
	    super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("user", request.getQueryString());
		
		HttpSession session = request.getSession(true);
	    String val = (String)session.getAttribute("pass");
	    if(val == null){
	    	PrintWriter writer = response.getWriter();
	    	writer.println("<script>");
	    	writer.println("alert('請先登入！')");
	    	writer.println("window.location.replace(\"/Final_Project_G4/LoginPage\");");
	    	writer.println("</script>");
	    	return;
	    }
	    
	    request.getRequestDispatcher("restaurantCommand.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
