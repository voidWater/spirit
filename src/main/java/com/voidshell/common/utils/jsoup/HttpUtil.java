package com.voidshell.common.utils.jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpUtil {
	private static final String[] SELECTORS= {"a[href].next"};
	private static final String URL = "http://0640.xyz";
	
	public static void main(String arg[]) {
		
        String url = "http://0640.xyz/qpuc_820649.html";
		
		try {
			Document document = Jsoup.connect(url).get();
			Elements image = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
			int count = 0 ;
			for (Element element : image) {
				
				System.out.println("src : " + element.attr("src"));
				System.out.println("height : " + element.attr("height"));
				System.out.println("width : " + element.attr("width"));
				System.out.println("alt : " + element.attr("alt"));
				count++;
				
			}
			System.out.println("总张数  ：" + count +" 张 ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void comm(String url,String selector) {
		System.out.println("---->");
		Map<String,String> lins = getHrefToMapBySelect(url,selector);
		if(lins.size()!=0) {
			for(String s: lins.values()) {
				comm(URL+s,selector);
			}
		}
	}
	
	/**
	 * 伪装头
	 * @return
	 */
	public static Map<String, String> packHeader() {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "http://info.bet007.com");
        header.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
        header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        header.put("Accept-Language", "zh-cn,zh;q=0.5");
        header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
        header.put("Connection", "keep-alive");
        return header;
     }
	
	/**
	 * 用选择器获取链接
	 * @param url
	 * @param selector
	 * @return
	 */
	private static Map getHrefToMapBySelect(String url, String selector) {
		try {
			Document document = Jsoup.connect(url).headers(packHeader()).get();
			Elements links = document.select(selector);
			Map<String,String> result = new HashMap<String,String>();
			for (Element element : links) {
				System.out.println("link : " + element.attr("href"));
				System.out.println("text : " + element.text());
				result.put(element.text(), element.attr("href"));
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取所有链接
	 * @param url
	 * @return
	 */
	private static Map getHrefToMap(String url) {
		try {
			Document document = Jsoup.connect(url).get();
			Elements links = document.select("a[href]");
			Map<String,String> result = new HashMap<String,String>();
			for (Element element : links) {
//				System.out.println("link : " + element.attr("href"));
//				System.out.println("text : " + element.text());
				result.put(element.attr("href"), element.text());
			}
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
