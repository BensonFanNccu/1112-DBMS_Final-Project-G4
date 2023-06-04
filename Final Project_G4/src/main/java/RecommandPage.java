import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecommandPage")
public class RecommandPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RecommandPage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String[] attribute = request.getQueryString().split("&");
		request.setAttribute("user", attribute[0]);
		
		if(attribute[1] == "RestID=none") {
			for(int i = 1; i <= 3; i++) {
				request.setAttribute("Rest" + Integer.toString(i), "無搜尋結果");
				request.setAttribute("RestID" + Integer.toString(i), "none");
			}
		}else {
			RestSearcher searcher = new RestSearcher();
			String[] attrRest = attribute[1].split(",");
			
			request.setAttribute("Rest1", searcher.getNameById(attrRest[0].substring(attrRest[0].length() - 1)));
			request.setAttribute("RestID1", attrRest[0].substring(attrRest[0].length() - 1));
			
			if(attrRest.length < 3) {
				if(attrRest.length == 1) {
					for(int i = 2; i <= 3; i++) {
						request.setAttribute("Rest" + Integer.toString(i), "無搜尋結果");
						request.setAttribute("RestID" + Integer.toString(i), "none");
					}
				}else {
					request.setAttribute("Rest2", searcher.getNameById(attrRest[1].substring(attrRest[1].length() - 1)));
					request.setAttribute("RestID2", attrRest[1].substring(attrRest[1].length() - 1));
					
					request.setAttribute("Rest3", "無搜尋結果");
					request.setAttribute("RestID3", "none");
				}

			}else {
				for(int i = 1; i < attrRest.length; i++) {
					request.setAttribute("Rest" + Integer.toString(i+1), searcher.getNameById(attrRest[i].substring(attrRest[i].length() - 1)));
					request.setAttribute("RestID" + Integer.toString(i+1), attrRest[i].substring(attrRest[i].length() - 1));
				}
			}
		}
		request.getRequestDispatcher("recommand.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}