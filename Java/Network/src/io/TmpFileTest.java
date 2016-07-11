package io;

import java.io.File;
import java.io.IOException;

public class TmpFileTest {

	public static void main(String[] args) {

		//File class는 폴더와 파일의 구분이 없다
		File folder = new File("C:/Nexon/");
		
		// 폴더가 없을경우 exception 발생하기 때문에 try/catch문으로 작성
		try {
			File f = File.createTempFile("moon_", ".dat", folder);
			System.out.println("10초 정도 sleep");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f.deleteOnExit();
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
