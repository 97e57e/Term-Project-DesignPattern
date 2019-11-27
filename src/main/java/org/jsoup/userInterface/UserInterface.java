package org.jsoup.userInterface;

import java.util.Iterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UserInterface {
	private static UserInterface userInterface = null;
	
	Scanner scan;
	
	TraverseController controller;
	
	/* Parse Condition */
	private String address;
	private String inputName;
	
	/* Procedure Condition */
	boolean isFinish;
	int run_code;
	int current_position = 0;
	
	/* Jsoup Object */
	Document doc;
	Elements elems;
	
	private UserInterface() {
		scan = new Scanner(System.in);
		isFinish = false;
		controller = new TraverseController();
	}
	
	/* Singleton */
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
			
			System.out.println("\n"+ address + " 를 가져오는중....");
			
			/*문서 가져오기*/
			try {
			doc = Jsoup.connect(address).get();
			System.out.println("문서 가져오기 완료.\n");
			}catch(Exception e) {}
			
			while(true) {
				
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
				
				/* 조건에 따른 CSS query */
				Elements els = doc.select(inputName);
				
				if (els.size() == 0 ) {
					System.out.println("결과가 없습니다.");
				} else {
					System.out.println("\n" + els.size() + "개의 " + inputName.substring(1, inputName.length()) + "을(를) 찾았습니다.");
					System.out.println(els.get(0));
					System.out.println("( " + 1 + " / " + els.size() + " )\n");
					Element e = els.get(0);
					while(true) {
						System.out.println("1. NEXT ");
						System.out.println("2. PREVIOUS");
						System.out.println("3. 결정");
						run_code = scan.nextInt();
						if (run_code == 3)break;
						
						if(run_code == 1) {
							if (current_position == els.size()- 1) {
								System.err.println("마지막 입니다.");
							} else {
								e = els.get(current_position);
								current_position++;
							}
						} else if (run_code ==2) {
							if (current_position==0) {
								System.err.println("첫 번째 입니다.");
							} else {
								e = els.get(current_position);
								current_position--;
							}
						}
						System.out.println("\n( " + Integer.toString(current_position+1) + " / " + els.size() + " )");
						System.out.println(e);
					}
					/* Query Results 의 행동 UP / DOWN / NEXT / PREVIOUS */
					controller.run(e);
				}
			}
			
			/* 프로그램 종료 조건 : 0 입력시 종료*/
			if (run_code ==0) isFinish=true;
		}	
		
		System.out.println("프로그램을 종료합니다.");
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
