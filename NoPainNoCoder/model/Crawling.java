package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	public static ArrayList<String> crawringName(String inUrl, String firstP, int maxCnt) {

		// 1. 웹 페이지 주소 저장
		String url = inUrl;
		ArrayList<String> list = new ArrayList<String>();
		
		// a) 스트림(연결통로) 만들기
		Connection conn = Jsoup.connect(url);

		// b) get()를 통해 해당 페이지의 코드를 받아오기
		Document doc = null;

		try {
			doc = conn.get();
		} catch (IOException e) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		// 3. 페이지 코드 분석 <- 이건 크롬에서 F12를 통해 하는게 유리함 (1차 가공)
		Elements elemsTitle = doc.select(firstP); // 타이틀 저장


		// 4. 긁어와서 1차가공한 정보를 각각 분류
		// a) 각각 분류
		Iterator<Element> itrTitle = elemsTitle.iterator();

		// b) 가공
		for (int i = 0; i < maxCnt; i++) {
			// 가공준비
			String strTitle;

			// 예외 처리 - 입력할 값이 더이상 없을 경우
			try {
				strTitle = itrTitle.next().toString();
			} catch (Exception e) {
				break; // 종료
			}

			// 가공
			// 1차 가공용 범위지정 (앞에 지우기)
			int indexTitle = strTitle.indexOf(">");

			// 1차 가공
			strTitle = strTitle.substring(indexTitle + 1);

			// 2차 가공용 범위 지정 (뒤에 지우기)
			indexTitle = strTitle.indexOf("<");

			// 2차 가공
			strTitle = strTitle.substring(0, indexTitle);

			// 완성된 정보 출력
			strTitle = strTitle.replace("'","`");
			
			list.add(strTitle);

		} // while
		return list;
		
	}
}
