package webPages;

import controllers.UserManager;

import java.util.Random;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VerificationPage")
public class VerificationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VerificationPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
	 	HttpSession hsession = request.getSession(true);
	 	UserManager manager = new UserManager();
	 	
	    String val = (String)hsession.getAttribute("email");
	    String code = String.format("%06d", new Random().nextInt(1000000));
	    System.out.print(code);
	    manager.sendVerification(val, code);
	    
		request.getRequestDispatcher("verification.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
}