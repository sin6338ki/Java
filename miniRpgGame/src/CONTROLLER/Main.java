package CONTROLLER;

import java.util.Scanner;

import VIEW.Main_display;

public class Main {

	public static void main(String[] args) {
		
		Main_display mdp = new Main_display();
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		while(true) {
			mdp.render();
			choice = sc.nextInt();
			
			if(choice == 1) {
//				아이템 조회
				System.out.print("1.전체 아이템 조회 2.검 아이템 조회 3.활 아이템 조회 >>");
				choice = sc.nextInt();
				AllSelectionItem allSelect = new AllSelectionItem();
				allSelect.rangeAll(choice);
				
				
			}else if(choice == 2) {
//				캐릭터 생성
				
			}else if(choice == 3) {
//				장비 장착
				
			}else if(choice == 4) { 
//				게임 종료
				System.out.println("게임을 종료합니다.");
				break;
				
			}else {
				System.out.println("번호를 다시 입력하세요.");
			}
		}
	
	}


}
