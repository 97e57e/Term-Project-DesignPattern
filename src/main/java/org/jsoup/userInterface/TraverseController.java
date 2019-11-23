package org.jsoup.userInterface;

import java.util.Scanner;

import org.jsoup.select.Elements;

public class TraverseController {
	Traverse traverseBehavior;
	Scanner sc = new Scanner(System.in);
	int run_code;
	
	public TraverseController() {}
	
	public void run(Elements els) {
		while(true) {
			System.out.println("무슨 행동을 할까유?");
			System.out.println("1. UP!");
			System.out.println("2. DOWN!");
			System.out.println("3. NEXT!");
			System.out.println("4. PREVIOUS!");
			System.out.println("5. 그만두기\n");
			if(run_code == 5 ) break;
			run_code = sc.nextInt();
			
			/* Strategy Pattern */
			switch(run_code) {
			case 1:
				setTraverseBehavior(new TraverseUp());
				break;
			case 2:
				setTraverseBehavior(new TraverseDown());
				break;
			case 3:
				setTraverseBehavior(new TraverseNext());
				break;
			case 4:
				setTraverseBehavior(new TraversePrevious());
				break;
			}
			
			els = traverseBehavior.traverse(els);
		}
	}
	
	
	void setTraverseBehavior(Traverse tb) {
		this.traverseBehavior = tb;
	}

}
