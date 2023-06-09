package webPages;

import controllers.DBConnector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentPage")
public class CommentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CommentPage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String[] attr = request.getQueryString().split("&");
		
		request.setAttribute("user", attr[0]);
		request.setAttribute("RestID", attr[1]);
		request.getRequestDispatcher("comment.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		DBConnector db = new DBConnector();
		PrintWriter out = response.getWriter();
		String[] attr = request.getQueryString().split("&");
		String uid = attr[0].split("=")[1];
		String rid = attr[1].split("=")[1];
		String com = request.getParameter("myTextbox");
		
		String[] rateValues = request.getParameterValues("rate");
	    int star = 0;
	    if (rateValues != null) {
	        for (String value : rateValues) {
	            if (value != null && value.equals("on")) {
	            	star++;
	            }
	        }
	    }
		
		
		boolean res = db.writeReview(uid, rid, com, String.valueOf(star));
		
		if(res) {
			out.println("<script>");
			out.println("alert('評論成功')");
			out.println("document.location.assign(\"/Final_Project_G4/RestaurantPage?$id=" + uid + "&RestID=" + rid + "\");");
			out.println("</script>");
			out.flush();
		}else {
			out.println("<script>");
			out.println("alert('評論失敗')");
			out.println("document.location.assign(\"/Final_Project_G4/RestaurantPage?$id=" + uid + "&RestID=" + rid + "\");");
			out.println("</script>");
			out.flush();
		}
	}
}
