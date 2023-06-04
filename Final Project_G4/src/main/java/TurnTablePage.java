import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TurnTablePage")
public class TurnTablePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TurnTablePage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("user", request.getQueryString());
		
		RestSelector selector = new RestSelector();
		ArrayList<String> res = selector.random();
		for(int i = 0; i < res.size(); i++) {
			request.setAttribute("Rest" + Integer.toString(i+1), res.get(i));
		}
		request.getRequestDispatcher("turnTable.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}