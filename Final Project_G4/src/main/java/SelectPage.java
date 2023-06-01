import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectPage")
public class SelectPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> type = new ArrayList<String>();
	private ArrayList<String> budget = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private ArrayList<String> distance = new ArrayList<String>();

	public SelectPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("user", "?" + request.getQueryString());
		request.getRequestDispatcher("selectRestaurant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Selector s = new Selector();
		s.fetch(request);
		s.suggest();
		
	}
}