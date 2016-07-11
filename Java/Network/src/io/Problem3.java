package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String dir = "C:/Nexon/savefile.txt";

		File savefile = new File(dir);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		String inputline;
		int inputnumber;
				
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fw = new FileWriter(savefile);
			bw = new BufferedWriter(fw);
			
			System.out.println("2~10 사이의 숫자 입력");			
				
			Boolean notFinish = true;
		
			while (notFinish) {

				// 엔터로 들어온 입력 저장
				isr = new InputStreamReader(System.in);
				br = new BufferedReader(isr);
				inputline = br.readLine();
				
				try {
					inputnumber = new Integer(inputline); // String을 integer 변환하는 타이밍이 예외처리 
				} catch (Exception e) {
					System.out.println("숫자를 입력해야 합니다");
					continue;
				}
				
				if(2<=inputnumber && inputnumber<=10) {
					// 출력
					while(inputnumber>0) {
						for(int i=inputnumber; i>0; i--) {
							bw.write("*");
						}
						bw.newLine();
						inputnumber--;
					}
					
					notFinish = false;
				}
				
			    else{
					System.out.println("2부터 10사이의 숫자를 입력해야 합니다");
			    }
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
