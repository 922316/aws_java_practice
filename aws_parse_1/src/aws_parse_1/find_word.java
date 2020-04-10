package aws_parse_1;
import java.util.*;

public class find_word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user ="I want to go to famous tourist attractions in Seoul. "
				+ "I like places with few people. "
				+ "I like a nature-friendly place. "
				+ "I want to see a cultural event.";
		
		int[] areaCode = {1,2,3,4,5,6,7,8,
				31,32,33,34,35,36,37,38,39}; // 서울 인천 대전 대구 광주 부산 울산 세종 경기 강원 충북 충남 경북 경남 전북 전남 제주
		
		StringTokenizer user2 = new StringTokenizer(user," .");
		
		String[] tlqkf = new String[user2.countTokens()] ;
		
		int i = 0;
		while(user2.hasMoreTokens()) {
			tlqkf[i] = user2.nextToken();
			System.out.println(tlqkf[i++]);
		}
		
		for(int j = 0; j < tlqkf.length ; j++) {
			if (tlqkf[j].equals("Seoul"))
				System.out.println(tlqkf[j]);
		}
	}
	
	public static String djtlqkf(String[] arr, String arr2) {
		for(int j = 0; j < arr.length ; j++) {
			if (arr[j].equals("Seoul"))
				arr2 = arr[j];
			return arr2;
		}
		return arr2;
	}
}
