package org.jsoup.userInterface;

import java.util.Scanner;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TraverseController {
	Traverse traverseBehavior;
	Scanner sc = new Scanner(System.in);
	int run_code;
	private int current_index = 0;
	
	public TraverseController() {}
	
	public void run(Elements els) {
		Element e = els.get(0);
		while(true) {
			System.out.println("무슨 행동을 할까유?");
			System.out.println("1. UP!");
			System.out.println("2. DOWN!");
			System.out.println("3. NEXT!");
			System.out.println("4. PREVIOUS!");
			System.out.println("5. 그만두기");
			run_code = sc.nextInt();
			if(run_code == 5 ) break;
			
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
			
			e = traverseBehavior.traverse(e);
			System.out.println(e + "\n");
		}
	}
	
	
	void setTraverseBehavior(Traverse tb) {
		this.traverseBehavior = tb;
	}
	
	public int getCurrent_index() {
		return current_index;
	}
	public void setCurrent_index(int current_index) {
		this.current_index = current_index;
	}

}
