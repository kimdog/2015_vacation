package network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class WebCrawling {

	public static void main(String[] args) {

		URL url = null;
		
		String urlString =
				"http://www.hanbit.co.kr/search/searchResult.html?keyword=%C6%F7%C5%E4%BC%A5";
		FileOutputStream fos = null; // 읽어오는 것이 byte배열이기 때문에 byte배열로 쓰는 것을 사용한다
		                             // 따라서 PrintWrite 사용하지 않는다
		try {
			url = new URL(urlString);
			fos = new FileOutputStream("C:/Nexon/result.txt");
			InputStream is = url.openStream();     // 주소를 찾아가서 스트림 연다
			
			//========================= byte배열을 이용해서 읽어주기
			byte[] buffer = new byte[512];
			int readCount = 0;
			
			while((readCount = is.read(buffer)) != -1 ) {
				fos.write(buffer, 0, readCount);  // buffer에 있는 것을 0 부터 readCount까지
			} System.out.println("파일 출력");
			
		} catch (Exception e) {
			System.out.println(e + " :WebCrawling");
		} finally {
			try {
				fos.close();				
			} catch ( Exception e2) {
				System.out.println(e2 + " :WebCrawling2");
			}
		}
		

	}

}
