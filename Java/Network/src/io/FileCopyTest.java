package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCopyTest {

	public static void main(String[] args) {
		
		// 생성 파일 디렉토리 설정
		String ipdir = "C:/Nexon/inputfile.txt";
		String opdir = "C:/Nexon/outputfile.txt";
				
		// 파일 생성
		File iff = new File(ipdir);
		File off = new File(opdir);
		
		// 파일 리더, 라이터 생성
		FileReader fr = null;
		FileWriter fw = null;
		
		// iff, off의 파일 존재 유무 확인후 생성
		if(!iff.exists()) {
			iff.mkdir();
			System.out.println("입력파일이 생성되었습니다.");
		} else {
			System.out.println("입력파일이 이미 존재 합니다.");			
		}		
		if(!off.exists()) {
			off.mkdir();
			System.out.println("출력파일이 생성되었습니다.");
		} else {
			System.out.println("출력파일이 이미 존재 합니다.");
		}
		
		
		try {
			// 각 리더와 라이터에 파일 연결
			fr = new FileReader(iff);
			fw = new FileWriter(off);
			
			// 파일이 전송될 배열
			char[] ch = new char[512];
						
			// 파일 리더에 더이상 파일이 없으면 -1 반환
			while((fr.read(ch)) != -1) {
				fw.write(ch);
			}
			
			System.out.println("복사 성공!");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 나중에 열은 스트림을 먼저 닫아준다.
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
				

	}

}
