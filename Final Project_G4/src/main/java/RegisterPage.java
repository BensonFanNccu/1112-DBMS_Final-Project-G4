import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RegisterPage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("register.jsp").forward(request, response);				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String account = request.getParameter("account");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("confirm_password");
		PrintWriter out = response.getWriter();
		
//		DBConnector db = new DBConnector();
//		String res = db.register(account, email, password, repassword);
		String res = "註冊成功";
		
		if(res.equals("註冊成功")) {
			out.println("<script>");
			out.println("alert('註冊成功')");
			out.println("window.history.go(-2);");
			out.println("</script>");
			out.flush();
		}else {
			out.println("<script>");
			out.println("alert('" + res + "')");
			out.println("window.history.back();");
			out.println("</script>");
			out.flush();
		}
	}
}