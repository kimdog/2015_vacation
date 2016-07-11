package jdbcPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class JdbcLibrary {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			
			fos = new FileOutputStream("C:/Nexon/dbsavefile.txt");
			oos = new ObjectOutputStream(fos);
			
			HashMap<Integer, String> map =
					new HashMap<>();
			
			
			//===============DataBase에서 결과 가져옴================================
			Class.forName("org.gjt.mm.mysql.Driver");
			
			String id = "java";
			String pw = "java";
			String url = "jdbc:mysql://localhost:3306/library";
			Connection con = 
					DriverManager.getConnection(url,id,pw); // import부분은 java껄로
			
			String sql = "select * from books";
			PreparedStatement pstmt =
					con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(); // rs에 결과값 저장
			
			System.out.println("DataBase 불러오기 완료");
			
			//=============가져온 결과값 Hash map에 전송===============================
			
			int num = 0;
			while(rs.next()) {
				
				System.out.println(rs.getString("bprice"));

				map.put(num+1, rs.getString("bprice"));
				num++;
			}
			
			System.out.println("Hash map에 전송 완료");
			
			//==============Hash map을 파일에 기록===================================
			oos.writeObject(map);
			oos.reset();
			
			rs.close();
			pstmt.close();
			con.close();
			
			System.out.println("파일에 기록 성공");
			
		} catch ( Exception e ) {
			System.out.println(e);
		} finally {
			
			try {
				oos.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
