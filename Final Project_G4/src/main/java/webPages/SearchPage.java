package webPages;

import controllers.RestSearcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchPage")
public class SearchPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("user", request.getQueryString());
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		RestSearcher searcher = new RestSearcher();
		
		String name = request.getParameter("name");
		String Rname = searcher.searchByText(name);
		String RestID = "";
		
		if(Rname != null) {
			RestID = searcher.getIdByName(Rname);
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("window.location.replace(\"/Final_Project_G4/RestaurantPage?" + request.getQueryString() + "&RestID=" + RestID +"\");");
			out.println("</script>");
			out.flush();
			
		}else {
			System.out.print("N");
		}
	}
}