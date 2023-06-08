package class02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public static ArrayList<ItemVO> sample(){

		final String url = "https://zerotohero.co.kr/shop";

		Connection conn = Jsoup.connect(url);

		Document doc = null;
		try {
			doc = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elems = doc.select("h2 > a._fade_link");
		Elements elems2 = doc.select("div > p.pay.inline-blocked");

		Iterator<Element> itr = elems.iterator();
		Iterator<Element> itr2 = elems2.iterator();
		
		ArrayList<ItemVO> idatas = new ArrayList<ItemVO>();
		int PK = 1;
		
		while(itr.hasNext() && itr2.hasNext()) { 
			String name = itr.next().text();
			String price = itr2.next().text();
			
			price = price.replace(",", "");
			price = price.replace("원", "");
			
			idatas.add(new ItemVO(PK++, name, price));
		}
		return idatas;

	}

}
