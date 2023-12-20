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
import dao.ReviewDaoClass;
import pojo.Review;
@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(ReviewDaoClass rv = new ReviewDaoClass()) {
			List<Review> list = rv.findAll();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Reviews</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h5>Hello, User</h5> <br> <br>");
			out.println("<a href = ''>All Reviews</a>   <a href = ''>My Reveiws</a>     <a href = ''>Shared Reviews</a> ");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<th>Id</th>");
			out.println("<th>Movie</th>");
			out.println("<th>Rating</th>");
			out.println("<th>Review</th>");
			out.println("<th>Actions</th>");
			out.println("</thead>");
			out.println("<tbody>");
			for (Review r : list) {
				out.println("<tr>");
				out.printf("<td>%s</td>\r\n", r.getId());
				try(MovieDaoClass mv = new MovieDaoClass())
				{
					out.printf("<td>%s</td>\r\n", mv.findById(r.getMovie_id()).getTitle());
				}catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}
				out.printf("<td>%s</td>\r\n", r.getRating());
				out.printf("<td>%s</td>\r\n", r.getReview());
				out.printf("<td>action action</td>\r\n");
				out.println("</tr>");
			}
			out.println("<a href = 'new_review'>Add Review</a>    <a href = 'logout'>Sign-Out</a> ");
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
}
