package webPages;

import controllers.UserManager;
import controllers.RestSearcher;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFavorPage")
public class DeleteFavoritePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeleteFavoritePage() {
	    super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("user", request.getQueryString());

		
		UserManager manager = new UserManager();
		ArrayList<String> favorite = manager.getFavorite(request.getQueryString().split("=")[1]);
		
		if(favorite == null || favorite.isEmpty()) {
			PrintWriter writer = response.getWriter();
	    	writer.println("<script>");
	    	writer.println("alert('您沒有將任何餐廳加入我的最愛，所以無法刪除您的最愛！')");
	    	writer.println("window.location.replace(\"/Final_Project_G4/MyFavoritePage?$id=" + request.getQueryString().split("=")[1] + "\");");
	    	writer.println("</script>");
	    	return;
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
		request.getRequestDispatcher("deleteFavorite.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String uid = request.getQueryString().split("=")[1];
		String rid = "";
		String res = "none";
		RestSearcher searcher = new RestSearcher();
		UserManager manager = new UserManager();
		ArrayList<String> favorite = manager.getFavorite(uid);

		
		if(favorite.size() < 2 && (request.getParameter("delete2") != null || request.getParameter("delete3") != null)) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('您的刪除包含無效的勾選!')");
			out.println("document.location.assign(\"/Final_Project_G4/MyFavoritePage?$id=" + uid + "\");");
			out.println("</script>");
			out.flush();
			return;
		}
		if(favorite.size() < 3 && request.getParameter("delete3") != null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('您的刪除包含無效的勾選!')");
			out.println("document.location.assign(\"/Final_Project_G4/MyFavoritePage?$id=" + uid + "\");");
			out.println("</script>");
			out.flush();
			return;
		}
		
		if(request.getParameter("delete1") != null) {
			rid = searcher.getNameById(favorite.get(0));
			res = manager.deleteCollect(uid, rid);
		}
		if (request.getParameter("delete2") != null) {
			rid = searcher.getNameById(favorite.get(1));
			res = manager.deleteCollect(uid, rid);
		}
		if (request.getParameter("delete3") != null) {
			rid = searcher.getNameById(favorite.get(2));
			res = manager.deleteCollect(uid, rid);
		}
		
		PrintWriter out = response.getWriter();
		if(res.equals("刪除成功")) {
			out.println("<script>");
			out.println("alert('" + res + "!')");
			out.println("document.location.assign(\"/Final_Project_G4/MyFavoritePage?$id=" + uid + "\");");
			out.println("</script>");
			out.flush();
		} else if(res.equals("none")){
			out.println("<script>");
			out.println("alert('您的最愛沒有任何更動。')");
			out.println("document.location.assign(\"/Final_Project_G4/MyFavoritePage?$id=" + uid + "\");");
			out.println("</script>");
			out.flush();
		} else {
			out.println("<script>");
			out.println("alert('" + res + "。')");
			out.println("document.location.assign(\"/Final_Project_G4/DeleteFavorPage?$id=" + uid + "\");");
			out.println("</script>");
			out.flush();
		}
	}
}