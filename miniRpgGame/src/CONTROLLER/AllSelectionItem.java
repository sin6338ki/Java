package CONTROLLER;

import java.util.ArrayList;

import MODEL.BowVO;
import MODEL.DAO;
import MODEL.ItemVO;

public class AllSelectionItem {
	
//	전체 아이템 조회
	public void rangeAll(int select) {
		if(select == 1) {
//			전체 아이템 조회
			allWeapon();
		}else if(select == 2) {
//			검 아이템 조회
			allSword();
		}else if(select == 3) {
//			활 아이템 조회
			allBow();
		}else {
			System.out.println("번호를 다시 입력하세요.");
		}
	}
	
//	전체 아이템 조회
	public void allWeapon() {
		DAO dao = new DAO();
		ArrayList<ItemVO> bowList = dao.bowList();
		ArrayList<ItemVO> swordList = dao.swordList();
		ArrayList<ItemVO> totalList = new ArrayList<ItemVO>();
		
		totalList.addAll(bowList); 
		totalList.addAll(swordList);
		
		System.out.println("num\tname\tpower\tdurablity");
		System.out.println("---------------------------");
		
		for(ItemVO item : totalList) {
			System.out.print(item.getItemNum() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAttackPower() + "\t");
			
			try {
				System.out.println(((BowVO)item).getDurability());
			}catch(Exception classCaseException) {
				System.out.println("");
			
			}
			System.out.println();
		}
	}
	
//	검 아이템 조회
	public void allSword() {
		DAO dao = new DAO();
		ArrayList<ItemVO> swordList = dao.swordList();
		
		System.out.println("num\tname\tpower\tdurablity");
		System.out.println("---------------------------");
		
		for(ItemVO item : swordList) {
			System.out.print(item.getItemNum() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAttackPower() + "\t");
			System.out.println();
		}
	}
	
//	Bow 아이템 조회
	public void allBow() {
		DAO dao = new DAO();
		ArrayList<ItemVO> BowList = dao.bowList();
		
		System.out.println("num\tname\tpower\tdurablity");
		System.out.println("---------------------------");
		
		for(ItemVO item : BowList) {
			System.out.print(item.getItemNum() + "\t");
			System.out.print(item.getName() + "\t");
			System.out.print(item.getAttackPower() + "\t");
			System.out.println(((BowVO)item).getDurability());
			System.out.println();
		}
	}
}
