package network;

import java.net.URL;

public class URLInfo {

	public static void main(String[] args) {

		URL url = null;
		String tmp = "http://www.naver.com:80/hello.html";
		
			
		try {
			url = new URL(tmp);
			
		} catch (Exception e) {
			System.out.println(e + " :URLInfo");
		}
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		
		
	}

}
