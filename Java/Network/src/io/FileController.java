package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileController {

	static void reverseLine(String inputFileName, String outputFileName) {
		

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis =
					new FileInputStream(inputFileName); //파일에 대하여
			ois = 
					new ObjectInputStream(fis); // fis에 대하여 object stream
			
			HashMap<Integer,String> map =
					(HashMap<Integer,String>)ois.readObject();
			HashMap<Integer,String> reversemap =
					new HashMap<Integer,String>();
			
			int mapSize = map.size();
			
			for(int i = 0; i < mapSize; i++)
			{
				reversemap.put(i+1, map.get(mapSize - i));
			}
			
			//=====================================================
			for(int i = 0; i < mapSize; i++) 
				System.out.println(map.get(i+1));
				
			System.out.println("불러오기 끝");
			
			//=====================================================  여기까지 불러오기
			
			fos =
					new FileOutputStream(outputFileName); //파일에 대하여
			oos = 
					new ObjectOutputStream(fos); // fos에 대하여 object stream
			

			oos.writeObject(reversemap);
			oos.reset(); 
			
			int reversemapSize = reversemap.size();
			for(int i = 0; i < reversemapSize; i++)
				System.out.println(reversemap.get(i+1));
			
			System.out.println("reverse 전송 성공");
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			try {
				ois.close();
				fis.close();
				oos.close();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("프로그램 종료");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseLine("C:/Nexon/dbsavefile.txt","C:/Nexon/outputfile.txt");
	}

}
