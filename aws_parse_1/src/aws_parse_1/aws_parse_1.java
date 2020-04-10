package aws_parse_1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class aws_parse_1 {

	private final String USER_AGENT = "Mozilla/5.0";
	
	public static void main(String[] args) throws Exception {
		aws_parse_1 http = new aws_parse_1();
		http.sendGet();
	}
	
	private void sendGet() throws Exception{
		String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="
				+ "1WPLDyhzVn3Toh%2B6fn7xtwW0vaa6NU1zp07%2FxWOROvBBz1nYUSa6Pf4Sk7rcElstQ8zFWWfIJH7huYTmJpWbgw%3D%3D&contentTypeId=&areaCode=31&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=12&pageNo=1";
		Node seoul = null;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			response.append(inputLine);
		}
		in.close();
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			FileOutputStream output = new FileOutputStream("./tlqkf");
			output.write(response.toString().getBytes());
			output.close();
			
			Document doc = dBuilder.parse("./tlqkf");
			doc.getDocumentElement().normalize();
			
			Element body = (Element) doc.getElementsByTagName("body").item(0);
			Element items = (Element) doc.getElementsByTagName("items").item(0);
			Element item = (Element) doc.getElementsByTagName("item").item(7);
			seoul = item.getElementsByTagName("addr1").item(0);
			
			//System.out.println(seoul.getNodeName());
			System.out.println(seoul.getChildNodes().item(0).getNodeValue());
			
		}catch (Exception e) {e.printStackTrace();}
	}
}
