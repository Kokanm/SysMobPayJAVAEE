package si.fri.prpo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDaoImpl udao = new UserDaoImpl();
		udao.odstraniVse();
		
		
		User up = new User();
		up.setId(1);
		up.setName("Jole");
		up.setLastname("Markoski");
		up.setCredit(29.31);
		up.setPhone("253-358");
		up.setEmail("jm@hmail.com");
		up.setBonusPoints(0);
		up.setMaxDaily(200);
		
		User up2 = new User();
		up2.setId(2);
		up2.setName("Tale");
		up2.setLastname("Mavroski");
		up2.setCredit(49.31);
		up2.setPhone("253-354");
		up2.setEmail("tm@hmail.com");
		up2.setBonusPoints(3);
		up2.setMaxDaily(300);
		
		
		
		System.out.println("---------- INSERT USER ONE ----------\n");
		udao.vstavi(up);		
		System.out.println("---------- INSERT USER TWO ----------\n");
		udao.vstavi(up2);		
		
		System.out.println("---------- SELECT USER ONE ----------\n");
		up = (User)udao.vrni(1);
		System.out.println(up.getName() + " " + up.getLastname()+ ", telefon: "
				+ up.getPhone()+", email: "+up.getEmail()+", credit: "+up.getCredit());
		System.out.println("---------- SELECT USER TWO ----------\n");
		up2 = (User)udao.vrni(2);
		System.out.println(up2.getName() + " " + up2.getLastname()+ ", telefon: "
				+ up2.getPhone()+", email: "+up2.getEmail()+", credit: "+up2.getCredit());
		
		System.out.println("\n---------- UPDATE USER ONE ----------\n");
		up.setName("Bojan");
		up.setPhone("253-358");
		up.setEmail("ss1000@adad.com");
		udao.posodobi(up);
		up = (User)udao.vrni(1);
		System.out.println(up.getName() + " " + up.getLastname()+ ", telefon: "
				+ up.getPhone()+", email: "+up.getEmail()+", credit: "+up.getCredit());
		
		System.out.println("---------- DELETE USER ONE ----------\n");
		udao.odstrani(1);

		System.out.println("---------- SELECT USER ONE ----------\n");
		udao.vrni(1);
		
		System.out.println("---------- ERROR SIMULATION ----------\n");
		UserDaoImpl test = new UserDaoImpl();
		
		User up3 = new User();
		up3.setId(3);
		up3.setName("Georgi");
		up3.setLastname("Todorov");
		up3.setCredit(47.31);
		up3.setPhone("111-354");
		up3.setEmail("gt@hmail.com");
		up3.setBonusPoints(3);
		up3.setMaxDaily(300);

		
		test.vstavi(up3);
		test.vstavi(up3);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<User> listOfUsers = IzpisUserov.getAllUsers();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>User list</title>");
		out.println("</head>");
		out.println("<body>");
		
		for (User u : listOfUsers) {
			out.println("<p>");
			out.println("<b>User "+u.getId()+":</b><br />");
			out.println(u.getName() + " " + u.getLastname()+ ", telefon: "
					+ u.getPhone()+", email: "+u.getEmail()+", credit: "+u.getCredit());
			out.println("</p>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
