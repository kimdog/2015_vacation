package Service;

import java.util.ArrayList;

import dao.BookDao;
import entity.BookEntity;

public class BookService {
	
	public ArrayList<BookEntity> keywordSearch(String keyword){
		// keyword를 입력받아서 작업을 하는 method
		// BookEntity의 ArrayList를 결과로 받아온다 
		
		// 우리문제에서는 로직처리 없어요
		// DB 처리가 있어요
		
		BookDao dao = new BookDao();
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		
		return list;
	}
	
	public ArrayList<BookEntity> bookRegister(String title, String isbn, String price, 
			String author, String imgurl){
		
		BookDao dao = new BookDao();
		
		ArrayList<BookEntity> list = dao.regBook(title, isbn, price, author, imgurl);
		
		return list;
	}
	

}
