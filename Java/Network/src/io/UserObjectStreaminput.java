package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UserObjectStreaminput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		
		try {
			fis =
					new FileInputStream("C:/Nexon/dbsavefile.txt"); //파일에 대하여
			ois = 
					new ObjectInputStream(fis); // fis에 대하여 object stream
			HashMap<Integer,String> map =
					(HashMap<Integer,String>)ois.readObject(); // 최상위 object 형태를 casting 시켜주어야 한다.
	
			int size = map.size();
			for(int i=0; i<size; i++)
			{
				System.out.println(map.get(i+1));
			}
			
			
		} catch ( Exception e ) {
			System.out.println(e);
		} finally {
			// 사실 안전하게 하기 위하여 fos, oos를 닫기 전에 닫을 수 있는지를 검사하여야 한다
			try {
				ois.close();
				fis.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		
		System.out.println("프로그램 종료");		


	}

}
