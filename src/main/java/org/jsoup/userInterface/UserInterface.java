package org.jsoup.userInterface;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class UserInterface {
	private static UserInterface userInterface = null;
	
	Scanner scan;
	
	private String address;
	private String inputName;
	
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
			
			System.out.println(address + "를 가져옵니다.\n");
			
			while(true) {
				/*문서 가져오기*/
				try {
				doc = Jsoup.connect(address).get();
				}catch(Exception e) {}
				
				System.out.println(" *** 무엇을 할까요? ***");
				System.out.println("1. Search by ClassName");
				System.out.println("2. Search by Id");
				System.out.println("3. 다른 주소 입력");
				System.out.println("0. 끝내기");
				run_code = scan.nextInt();
				scan.nextLine(); // 개행문자 제거
				if(run_code == 0 || run_code == 3) break;
				
				
				switch (run_code) {
				case 1:
					System.out.print("찾고자 하는 Class 이름을 입력 해 주세요 : ");
					inputName = scan.nextLine();
					inputName = "." + inputName;
					break;
				case 2:
					System.out.print("찾고자 하는 ID를 입력 해 주세요 : ");
					inputName = scan.nextLine();
					inputName = "#" + inputName;
					break;
				}
				Elements els = doc.select(inputName);
				if (els == null) {
					System.out.println("결과가 없습니다.");
				} else {
					System.out.println(els);
				}
			}
			if (run_code ==0) isFinish=true;
		}
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
