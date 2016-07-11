package io;

import java.io.File;

public class FileDelete {

	public static void main(String[] args) {

		File f = new File("C:/Nexon/fordele.txt");
		
		if(f.exists()) {
			boolean result = f.delete();
			if (result) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		} else {
			System.out.println("파일이 없다");
		}
		

	}

}
