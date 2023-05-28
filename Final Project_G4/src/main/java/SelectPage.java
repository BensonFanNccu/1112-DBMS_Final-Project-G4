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
		doGet(request, response);
		
		if(request.getParameter("below100") != null) {
			budget.add("100元以下");
		}
		
		if(request.getParameter("100-150") != null) {
			budget.add("100-150元");
		}
		
		if(request.getParameter("150-200") != null) {
			budget.add("150-200元");
		}
		
		if(request.getParameter("200-250") != null) {
			budget.add("200-250元");
		}
		
		if(request.getParameter("250up") != null) {
			budget.add("250元以上");
		}
		
		if(request.getParameter("below 30min") != null) {
			time.add("30分以下");
		}
		
		if(request.getParameter("30min-1hr") != null) {
			time.add("30分-1小時");
		}
		
		if(request.getParameter("1hr up") != null) {
			time.add("1小時以上");
		}
		
		if(request.getParameter("type1") != null) {
			type.add("中式");
		}
		
		if(request.getParameter("type2") != null) {
			type.add("韓式");
			type.add("日式");
			type.add("美式");
			type.add("義式");
		}
		
		if(request.getParameter("type3") != null) {
			type.add("輕食");
			type.add("速食");
		}
		
		if(request.getParameter("dist1") != null) {
			distance.add("麥側");
		}
		
		if(request.getParameter("dist2") != null) {
			distance.add("正門");
		}
		
		if(request.getParameter("dist3") != null) {
			distance.add("東側門");
		}
		
	}
}