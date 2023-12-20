package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDaoClass;
import pojo.Movie;
import pojo.Review;

@WebServlet("/new_review")
public class NewReviewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method = 'POST' action = 'AddReview' >");
		out.println("<select name='movie' >\r\n");
		try(MovieDaoClass m = new MovieDaoClass())
		{
			List<Movie> ls = m.findAll();
			for(Movie mv :ls) {
				out.printf("<option value=%d>%s</option>\r\n", mv.getId(),mv.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
				
		out.println("</select> <br>");
		out.println("Rating : <input type = 'number' name = 'rating' > <br>");
		out.println("Review : <input type = 'textarea' name = 'review' > <br>");
		out.println("<input type = 'submit' value = 'Save' >");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
