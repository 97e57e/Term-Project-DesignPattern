package org.jsoup.userInterface;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class UserInterface {
	private static UserInterface userInterface = null;
	
	Scanner scan;
	
	private String address;
	private String className;
	private String idName;
	
	boolean isFinish;
	int run_code;
	
	Document doc;
	
	private UserInterface() {
		scan = new Scanner(System.in);
		isFinish = false;
	}
	
	public static UserInterface getUserInterface() {
		if (userInterface == null) {
			userInterface = new UserInterface();
		}
		return userInterface;
	}
	
	public void run() {
		while(!isFinish) {
			// https://jsoup.org/download 로 테스트
			System.out.println(" *** Jsoup Interface ***");
			System.out.print("주소를 입력 해 주세요 : ");
			address = scan.nextLine();
			System.out.println(address + "를 파싱합니다.\n");
			/*문서 가져오기*/
			try {
			doc = Jsoup.connect(address).get();
//			Elements els = doc.select(".header").select(".nav-sections");
			System.out.println("문서 가져오기 완료!");
			}catch(Exception e) {}
			
			System.out.println(" *** 무엇을 할까요? ***");
			System.out.println("1. Search by ClassName");
			System.out.println("2. Search by Id");
			System.out.println("0. 끝내기");
			run_code = scan.nextInt();
			if(run_code == 0 ) break;
			
			
			switch (run_code) {
			case 1:
				className = scan.nextLine();
				className = "." + className;
				System.out.println(className + "가지고 찾아보자!");
				break;
			case 2:
				idName = scan.nextLine();
				break;
			}
			
		}
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
