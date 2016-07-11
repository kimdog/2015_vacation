package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBTemplate;
import entity.BookEntity;

public class BookDao {
	
	public ArrayList<BookEntity> selectAll(String keyword) {
		/*
		 * connection은 주로 유료든 무료든 커넥션풀 을 이용하여 많이함
		 *  
		try {
			Class.forName("~~");
			Connection con = DriverManager.getConnection(url); // 
			
		} catch( Exception e ) {
			
		}
		*/
		
		
		ArrayList<BookEntity> list = new ArrayList<BookEntity>();
		
		Connection con = null;
		try {
			// DBCP와 제공된 Template을 이용해서 Connection을 쉽게 얻어와요
			con = DBTemplate.getConnection();
			String query = 
					"select * from books where btitle like ?"; // 제목 유사한 것
			PreparedStatement sptmt =
					con.prepareStatement(query);
			sptmt.setString(1, "%" + keyword + "%");           // 1-첫번째 물음표에
															   // string을 setting한다
			ResultSet rs = sptmt.executeQuery();
			while(rs.next()) {
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBprice(rs.getString("bprice"));
				entity.setBauthor(rs.getString("bauthor"));
				entity.setBimgurl(rs.getString("bimgurl"));
				list.add(entity);
			}
			
			
		} catch( Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public ArrayList<BookEntity> regBook(String title, String isbn, String price, 
			String author, String imgurl) {

		//view를 사용하기 위해 list형태로 전달
		ArrayList<BookEntity> list = new ArrayList<BookEntity>();
		
				
		//전달받은 책 정보로 책 하나 생성
		BookEntity registerBook = new BookEntity();
		registerBook.setBtitle(title);
		registerBook.setBisbn(isbn);
		registerBook.setBprice(price);
		registerBook.setBauthor(author);
		registerBook.setBimgurl(imgurl);
		
		//커넥션 생성
		Connection con = null;
		
		try {
			//DBTemplate과 연결
			con = DBTemplate.getConnection();
			String query = 
					"insert into books(btitle, bisbn, bprice, bauthor, bimgrul)"
					+ "values(?,?,?,?,?); flush privileges"; // 등록 쿼리
			PreparedStatement sptmt =
					con.prepareStatement(query);
			sptmt.setString(1, "'" + title + "'");             // 넣어줄 값
			sptmt.setString(2, "'" + isbn + "'");			   // x번째 물음표
			sptmt.setString(3, "'" + price + "'");
			sptmt.setString(4, "'" + author + "'");
			sptmt.setString(5, "'" + imgurl + "'");
			ResultSet rs = sptmt.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e + "BookDao");
		}
		
		list.add(registerBook);
		
		return list;
	}

}
