package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLineTest {

	public static void main(String[] args) {
		
		System.out.println("입력하세요");
		System.out.print("==>");
		
		//input stream(System.in)
		InputStreamReader isr =
				new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = null;
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("입력받은 값은 : " + input);

	}

}
