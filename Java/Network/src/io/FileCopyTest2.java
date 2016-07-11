package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest2 {

	public static void main(String[] args) {
		
		// 생성 파일 디렉토리 설정
		String ipdir = "C:/Nexon/inputfile.txt";
		String opdir = "C:/Nexon/outputfile.txt";
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
				
		// 파일 입출력 객체
		try {
			fr = new FileReader(ipdir);
			fw = new FileWriter(opdir);
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			// Char가 아닌 String으로 전달해준다.
			String line;
			
			// readline은 더이상 읽을것이 없으면 null 반환
			while((line=br.readLine()) != null) {
				bw.write(line);
				bw.newLine(); // 한 줄씩 읽기 때문에 line까지 쓰고 나서 엔터효과를 넣어준다.
			}
			
			System.out.println("성공");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
				fw.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
