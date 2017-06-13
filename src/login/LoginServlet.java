package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "�����¼��Ϣ", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 1.��ȡ������
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		/**
		 * 2.У������
		 */
		if(username.equals("zj")){
			/**
			 * ���û������浽cookie�У��ٴδ�login.jspʱ���Զ���ʾ�û���
			 */
			Cookie cookie = new Cookie("uname",username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			/**
			 * �ɹ�
			 * >������Ϣ��session
			 * >�ض���success.jsp
			 */
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/LoginExp/success.jsp");
		}else{
			/**
			 * ʧ��
			 * >���������Ϣ��request����
			 * >ת����login.jsp
			 */
			request.setAttribute("error", "�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
