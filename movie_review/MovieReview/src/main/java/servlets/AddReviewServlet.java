package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDaoClass;
import pojo.Review;
import pojo.User;
@WebServlet("/AddReview")
public class AddReviewServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = 1;
		int movie_id = Integer.parseInt(req.getParameter("movie"));
		String review = req.getParameter("review");
		int rating = Integer.parseInt(req.getParameter("rating"));
		HttpSession s = req.getSession();
		User u = (User) s.getAttribute("user");
		int user_id = u.getId();
		
		Review r = new Review(id,movie_id,review,rating,user_id,new Date(1000));
		try(ReviewDaoClass r1 = new ReviewDaoClass())
		{
			r1.save(r);
			resp.sendRedirect("review");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
