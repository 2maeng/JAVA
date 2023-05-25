package class05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {

		final String path = "C:\\maeng\\resource\\";
		final String fileName = "달이.jpg";
		final String fileCopy = "test - 복사본.jpg";

		try {
			FileInputStream fis = new FileInputStream(path + fileName);
			FileOutputStream fos = new FileOutputStream(path + fileCopy);

			int data;
			byte[] buff = new byte[1000];
			while((data = fis.read(buff)) != -1) {
				System.out.println("확인");
				fos.write(buff, 0, data);
			}
			
			fos.flush();
			fos.close(); // 꼭 달아주기
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("사진 실습 완료");
		}

	}

}
