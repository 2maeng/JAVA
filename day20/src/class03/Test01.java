package class03;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {
	public static void main(String[] args) {

		final String url = "https://www.ytn.co.kr/_ln/0115_202305310918465518";

		Connection conn = Jsoup.connect(url);

		Document doc = null;
		try {
			doc = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elems = doc.select("span.blind");
		Iterator<Element> itr = elems.iterator();
		while(itr.hasNext()) { // itr 코드 딱 이코드 정해져 있음
			String str = itr.next().toString();

			int index = str.indexOf(">");
			str = str.substring(index + 1);
			index = str.indexOf("<");
			str = str.substring(0, index);
			if(str.equals("YTN")) {
				System.out.println(str);
				break;
			}
		}

		Elements elems2 = doc.select("span.til");
		Iterator<Element> itr2 = elems2.iterator();
		String str2 = itr2.next().toString();
		int index2 = str2.indexOf(">");
		str2 = str2.substring(index2 + 1);
		index2 = str2.indexOf("<");
		str2 = str2.substring(0, index2);
		System.out.println(str2);



	}
}
