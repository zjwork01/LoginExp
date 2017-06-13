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
@WebServlet(description = "处理登录信息", urlPatterns = { "/LoginServlet" })
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
		 * 1.获取表单数据
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		/**
		 * 2.校验数据
		 */
		if(username.equals("zj")){
			/**
			 * 将用户名保存到cookie中，再次打开login.jsp时，自动显示用户名
			 */
			Cookie cookie = new Cookie("uname",username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			/**
			 * 成功
			 * >保存信息到session
			 * >重定向到success.jsp
			 */
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("/LoginExp/success.jsp");
		}else{
			/**
			 * 失败
			 * >保存错误信息到request域中
			 * >转发到login.jsp
			 */
			request.setAttribute("error", "用户名或密码错误！");
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
