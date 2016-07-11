package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UserObjectStream {

	public static void main(String[] args) {

		// generic <key값, value값>
		HashMap<Integer, String> map =
				new HashMap<>();
		// auto boxing에 의한 객체 변환이 이루어진다. 객체 1 -> (integer) 1
		map.put(1, "원래 첫번째줄");
		map.put(2, "원래 두번째줄");
		map.put(3, "원래 마지막줄");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		
		try {
			fos =
					new FileOutputStream("C:/Nexon/object.txt"); //파일에 대하여
			oos = 
					new ObjectOutputStream(fos); // fos에 대하여 object stream
			
			oos.writeObject(map);
			oos.reset(); // 호출해야 제대로 writing 된다.
			
		} catch ( Exception e ) {
			System.out.println(e);
		} finally {
			// 사실 안전하게 하기 위하여 fos, oos를 닫기 전에 닫을 수 있는지를 검사하여야 한다
			try {
				fos.close();
				oos.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		
		System.out.println("프로그램 종료");		

	}

}
