import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginPage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("login.jsp").forward(request, response);				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
//		DBConnector db = new DBConnector();
		boolean login = true;
		
		if(login) {
			request.getRequestDispatcher("/FunctionList").forward(request, response);
		}else {
			PrintWriter out = response.getWriter();						
			
			out.println("<script>");
			out.println("alert('帳號或密碼錯誤，請重新登入！')");
			out.println("window.history.back();");
			out.println("</script>");
			out.flush();
		}				
	}
}