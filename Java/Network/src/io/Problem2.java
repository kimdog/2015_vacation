package io;

import java.awt.Event;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dir = "C:/Nexon/savefile.txt";
		
		
		File savefile = new File(dir);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
				
		String inputline;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fw = new FileWriter(savefile);
			bw = new BufferedWriter(fw);
			
			System.out.println("입력하고 Enter, 끝낼 때는 exit 입력");			
			
			
			while (true){
				
				// 엔터로 들어온 입력 저장
				isr = new InputStreamReader(System.in);
				br = new BufferedReader(isr);
				inputline = br.readLine();
				
				// 들어온 입력이 exit면 정지
				if(inputline.equals("exit")) {
					break;
				}
				
				// 출력
				bw.write(inputline);
				bw.newLine();
				System.out.println("한 줄 입력 성공");
				
			}
		
			System.out.println("프로그램 종료");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				bw.close();
				fw.close();
				br.close();
				isr.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
