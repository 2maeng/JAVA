package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {

		// 2. 파일 읽어오기
		try {
			FileInputStream fis = new FileInputStream("C:\\maeng\\resource\\test02.txt"); // 방법1 -> 보통 이 방법

			int data;
			try {
				while((data = fis.read()) != -1) {
					// 읽어온 데이터가 -1이면 "다읽었다."는 의미
					System.out.println((int)data);
				}
				System.out.println();
				if(((char)data % 10) % 2 == 0) {
					System.out.println("입력되어있는 정수는 짝수 입니댜.");
				} else {
					System.out.println("입력되어있는 정수는 홀수 입니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("fis객체로 파일 읽어오기 작업 완료!");
		}

	}

}
