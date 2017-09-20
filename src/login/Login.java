package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banco.MySQLDatabase;
import dao.PessoaDAO;
import library.Cript;
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
		// Criação dos objeto que serão utilizados nessa função
		MySQLDatabase db = new MySQLDatabase("root", "", "EVENTO");
		PessoaDAO dao = new PessoaDAO(db);
		Cript hash = new Cript();
		HttpSession session;
		String location;
		
		// Pegando os paramentros do POST
		String senha = request.getParameter("user_password");
		String email = request.getParameter("user_email");
		
		
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setEmail(email);
			pessoa.setSenha(hash.make(senha));
			
			pessoa = dao.exist(pessoa);
			
			if (pessoa != null) {
				session = request.getSession(true);
				session.setAttribute("usuarioLogado", pessoa);
				location = "membro";
			} else {
				location = "Login";
			}

			// Redireciona para a página
			response.sendRedirect(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
