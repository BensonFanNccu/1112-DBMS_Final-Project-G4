import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFavoritePage")
public class MyFavoritePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public MyFavoritePage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("user", request.getQueryString());
		
		DBConnector db = new DBConnector();
		ArrayList<String> favorite = db.getFavorite(request.getQueryString().split("=")[1]);
		
		if(favorite == null || favorite.isEmpty()) {
			request.setAttribute("Rest1", "無");
			request.setAttribute("Rest2", "無");
			request.setAttribute("Rest3", "無");
		}else {
			request.setAttribute("Rest1", favorite.get(0));
			if(favorite.size() == 1) {
				request.setAttribute("Rest2", "無");
				request.setAttribute("Rest3", "無");
			}else {				
				if(favorite.size() == 2) {
					request.setAttribute("Rest2", favorite.get(1));
					request.setAttribute("Rest3", "無");
				} else {
					request.setAttribute("Rest2", favorite.get(1));
					request.setAttribute("Rest3", favorite.get(2));
					
				}
			}
		}

		request.getRequestDispatcher("myFavorite.jsp").forward(request, response);
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
		
		
		boolean res = db.addFavorite(uid, rid);
		
		if(res) {
			out.println("<script>");
			out.println("alert('新增成功')");
			out.println("document.location.assign(\"/Final_Project_G4/RestaurantPage?$id=" + uid + "&RestID=" + rid + "\");");
			out.println("</script>");
			out.flush();
		}else {
			out.println("<script>");
			out.println("alert('新增失敗')");
			out.println("document.location.assign(\"/Final_Project_G4/RestaurantPage?$id=" + uid + "&RestID=" + rid + "\");");
			out.println("</script>");
			out.flush();
		}
	}
}