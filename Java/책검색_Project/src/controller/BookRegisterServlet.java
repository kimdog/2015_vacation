package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BookService;
import entity.BookEntity;

/**
 * Servlet implementation class BookRegisterServlet
 */
@WebServlet("/bregister")
public class BookRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRegisterServlet() {
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
				// 1. 사용자 입력을 받아요!
				//request.setCharacterEncoding("UTF8");

				String title = request.getParameter("title"); 
				String isbn = request.getParameter("isbn"); 
				String price = request.getParameter("price"); 
				String author = request.getParameter("author"); 
				String imgurl = request.getParameter("imgurl"); 
				
				// 2. 로직처리
				//    서비스 객체를 생성( 객체를 만들려면 클래스가 있어야 해요 )
				BookService service = new BookService();
				ArrayList<BookEntity> registeredBook = 
						service.bookRegister(title, isbn, price, author, imgurl);
				
				// 3. 결과처리 ( view처리 )
				// jsp를 이용해서 결과처리( jsp에게 결과를 전달해줘야 얘가 찍겠죠.. )
				RequestDispatcher rd = 
						request.getRequestDispatcher("view.jsp");
				request.setAttribute("result", registeredBook); // result란 이름으로 list를 request객체 위해 놓는다
													  // request를 가지고 한 서블렛이 다른 서블렛을 호출하도록
				rd.forward(request, response);        // request를 전달
				
	}

}
