package class03;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
		
		// 1. 웹 페이지 코드를 JAVA로 가져오기
		final String url = "https://media.naver.com/press/009/ranking?type=popular";
		final String url2 = "https://media.naver.com/press/009/ranking?type=comment&date=20230531";
		// a) 해당 url의 페이지 코드를 받아오기 위해, 연결통로(스트림)을 open 해야함
		//		== connect() 해야함
		
		Connection conn = Jsoup.connect(url);
		Connection conn2 = Jsoup.connect(url2);
		// Jsoup => JAVA에서 기본제공 X
		
		// 2. 페이지 스크랩핑 완료
		Document doc = null;
		Document doc2 = null;
		try {
			doc = conn.get();
			doc2 = conn2.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// b) connect()가 정상적으로 수행 되었다면, get()을 통하여
		//		해당 페이지의 코드를 받아옴
		
		// 3. 페이지 코드를 분석
		// a) DOM 문서를 분석
		//		<></> 태그(요소, element) 단위로 분석
		//		속성(property)을 가질 수 있으며,
		//		분석할때에 가장 대표적으로 활용되는 속성이
		//		id(유일한 요소), class(여러개의 공통점을 가진 요소들)
		Elements elemManySee = doc.select("strong.list_title");
		Elements rank = doc.select("em.list_ranking_num");
		// 태그명#id
		// 태그명.class명
		// 상위태그 > 하위태그명
		// => 파싱
		
		// 4. 분석하여 추출 완료한 데이터를 console 화면에 출력
		// Iterator 이터레이터 -> java.util
		// : 거대한 컬렉션(elemManySee)에 있는 데이터를 작은 단위의 컬렉션으로 나눠 저장할 수 있도록 해주는 컬렉션
		Iterator<Element> itr = elemManySee.iterator();
		Iterator<Element> rn = rank.iterator();
		// itr은 hashNext(), next()
		//	다음 요소가 있어?, 그럼 다음거 보여줘(== 내거, <제네릭>에 해당하는 자료형)
		System.out.println("[많이 본 뉴스]");
		while(itr.hasNext()) { // itr 코드는 이 코드로 정해져 있음
			String str = itr.next().toString();
			String r = rn.next().toString();
			
			// 5. 데이터를 가공
			int index = str.indexOf(">"); // 자를 위치
			int index2 = r.indexOf(">");
			str = str.substring(index + 1); // 앞 자름
			r = r.substring(index2 + 1);
			index = str.indexOf("<"); // 뒤 자를 위치
			index2 = r.indexOf("<");
			str = str.substring(0, index);
			r = r.substring(0, index2);
			System.out.println(r + ". " +str); // 순위와 제목을 출력
		}
		
		Elements elemManyComment = doc2.select("strong.list_title"); // 제목 요소
		Elements comment = doc2.select("em.list_ranking_num"); // 랭킹 수
		Elements cntComm = doc2.select("span.list_comment"); // 댓글 수
		
		Iterator<Element> itr2 = elemManyComment.iterator();
		Iterator<Element> comm = comment.iterator();
		Iterator<Element> cnt = cntComm.iterator();
		
		System.out.println("\n[댓글 많은 뉴스]");
		while(itr2.hasNext()) {
			String str2 = itr2.next().toString();
			String c = comm.next().toString();
			String cC = cnt.next().toString();
			
			int index = str2.indexOf(">");
			int index2 = c.indexOf(">");
			int index3 = cC.indexOf("n>");
			str2 = str2.substring(index + 1);
			c = c.substring(index2 + 1);
			cC = cC.substring(index3 + 2);
			index = str2.indexOf("<");
			index2 = c.indexOf("<");
			index3 = cC.indexOf("</span");
			str2 = str2.substring(0, index);
			c = c.substring(0, index2);
			cC = cC.substring(0, index3);
			System.out.println(c + ". " + str2 + " [ 댓글수:" + cC + "]"); // 랭킹수 제목 댓글수 출력
		}
		
	}
}
