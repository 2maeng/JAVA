package class05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) {

		// "유지보수 용이"
		final String path_START = "C:\\maeng\\resource\\";
		final String path_FILE01 = "test01";
		final String path_FILE02 = "test02";
		final String path_END = ".txt";


		// 선생님 풀이
		try {
			FileInputStream fis=new FileInputStream(path_START+path_FILE01+path_END);

			int data;
			String num="";
			while( (data=fis.read()) != -1 ) {
				num+=(char)data;
			}
			System.out.println(num);
			data=Integer.parseInt(num);
			System.out.println(data);
			if(data%2==0) {
				System.out.println("짝수");
			}
			else {
				System.out.println("홀수");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("fis객체로 파일 읽어오기 작업 완료!");
		}





		try {
			FileOutputStream fos=new FileOutputStream(path_START+path_FILE02+path_END);

			for(int i=97;i<=122;i++) {
				fos.write(i);
			}

			// ★★★★★
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("fos객체로 파일 작성하기 작업 완료!");
		}

	}

}
