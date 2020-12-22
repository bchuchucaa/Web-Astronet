package astronet.ec.modelo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import astronet.ec.vista.EmpleadoController;

/**
 * Servlet implementation class FiltServlet
 */
@WebServlet("/FiltServlet")
public class FiltServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String username = request.getParameter("correo");
		//String password = request.getParameter("contra");
		//usuario= new UsuarioDao();
		EmpleadoController emp=  new EmpleadoController();
		try {
			if (emp.login() != "") {
				request.getSession().setAttribute("user", emp.login());
				response.sendRedirect(request.getContextPath() + "/menu.xhtml");
			} else {
				request.setAttribute("error", "Unknown login, try again");
				doGet(request, response);
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}