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
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bsearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
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
		request.setCharacterEncoding("UTF8");
		String keyword = request.getParameter("keyword"); // html에 name이 keyword인
		
		
		// 2. 로직처리
		//    서비스 객체를 생성( 객체를 만들려면 클래스가 있어야 해요 )
		BookService service = new BookService();
		ArrayList<BookEntity> list = service.keywordSearch(keyword);
		
		// 3. 결과처리 ( view처리 )
		// jsp를 이용해서 결과처리( jsp에게 결과를 전달해줘야 얘가 찍겠죠.. )
		RequestDispatcher rd = 
				request.getRequestDispatcher("view.jsp");
		request.setAttribute("result", list); // result란 이름으로 list를 request객체 위해 놓는다
											  // request를 가지고 한 서블렛이 다른 서블렛을 호출하도록
		rd.forward(request, response);        // request를 전달
		
	}

}
