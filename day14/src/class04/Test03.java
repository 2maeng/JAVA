package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) {
		
		// 1. 파일 생성하기
				File file = new File("C:\\maeng\\resource\\test03.txt");
				// 해당 파일이 존재하지 않으면, 새로 생성해줌!
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					System.out.println("파일객체 생성 완료!");
				}

				// 2. 파일 읽어오기
				try {
					FileInputStream fis = new FileInputStream("C:\\maeng\\resource\\test03.txt"); // 방법1 -> 보통 이 방법
					//		FileInputStream fis = new FileInputStream(file); // 방법2

					int data;
					try {
						while((data = fis.read()) != -1) {
							// 읽어온 데이터가 -1이면 "다읽었다."는 의미
						}
						System.out.println();
						System.out.println("아무 내용도 작성되어있지 않습니다.");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					System.out.println("fis객체로 파일 읽어오기 작업 완료!\n");
				}

				// 3. 파일 작성하기
				try {
					FileOutputStream fos = new FileOutputStream("C:\\maeng\\resource\\test03.txt", true);

					char ch = 97;
					while(true) {
						
						fos.write(ch++);
						if(ch < 122) {
							break;
						}
					}
					
					fos.flush();
					fos.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				} finally {
					System.out.println("\nfos 객체로 파일 작성하기 작업 완료");
				}
		
	}
	
}
