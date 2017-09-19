package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco.MySQLDatabase;
import model.Pessoa;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns= {"/Login","/"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senha = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		
		System.out.println("Conectando no banco de dados...................");
		MySQLDatabase db = new MySQLDatabase("root", "", "EVENTO");
		db.connect();
		
		Pessoa user = new Pessoa();
		user.setEmail(email);
		user.setSenha(senha);
		
	}

}
