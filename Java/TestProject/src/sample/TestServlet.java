package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/add.do")                                // url mapping 부분. 쉽게 바꿀수있다
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자로부터 데이터를 입력받는다
		String num1 = request.getParameter("num1");  // num1 key 값 받기
		String num2 = request.getParameter("num2");  // num2 key 값 받기
		
		// 2. 로직처리(DB처리 포함한)
		int n1 = new Integer(num1);                  // int 변경
		int n2 = new Integer(num2);
		int result = n1+n2;
		
		// 3. 사용자에게 응답을 돌려준다
		// 3-1. 헤더설정
		//      결과로 만든 내용이 당췌 무슨 내용인지, 문자셋은 뭔지..알려줘야한다
		response.setContentType("text/html; charset=utf8");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>계산결과</title></head>");
		pw.println("<head><title>계산결과</title></head>");
		pw.println("<h1>계산 결과는 : " + result + "</h1>");
		pw.flush();
		pw.close();  // throws 에서 이미 try catch 날린다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
