package controller;

import java.util.Scanner;

import models.Bank;

public class BankManager {
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	private FileManager fm = FileManager.instance;
	public static BankManager instance = new BankManager();
	private BankManager() {}
	
	public void run() {
		// 실행 시작
		fm.load();
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.getName() + "ATM");
			printMenu();
			selectMenu();
		}
	}
	
	private void printMenu() {
		fm.save();
		if(Bank.log == -1) {
			System.out.println("1.로그인\n2.회원가입\n3.종료");
		}
		else {
			System.out.println("1.계좌\n2.뱅킹\n3.종료");
		}
	}
	
	private void selectMenu() {
		String input = Bank.sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			if(Bank.log == -1) {
				if(sel == 1) {
					Bank.log = um.loginUser();
				}
				else if(sel == 2) {
					// 회원가입 메소드를 호출
					um.joinUser();
//					UserManager.instance.joinUser();
				}
				else if(sel == 3) {
					
				}
			}
			else {
				if(sel == 1) {// Account
					am.accountMenu();
				}
				else if(sel == 2) { // Bank
					bankMenu();
				}
				else if(sel == 3) {
					
				}
			}
		} catch (Exception e) {
			System.out.println("입력값을 확인하세요.");
		}
	}
	
	// bank 기능
	private void bankMenu() {
		while(true) {
			fm.save();
			System.out.println("1.입금\n2.출금\n3.이체\n4.조회\n5.뒤로가기");
			String input = Bank.sc.next();
			
			try {
				int sel = Integer.parseInt(input);
				if(sel == 1) {
					accountCheck(sel);
				}
				else if(sel == 2) {
					accountCheck(sel);
				}
				else if(sel == 3) {
					accountCheck(sel);
				}
				else if(sel == 4) {
					
				}
				else if(sel == 5) {
					break;
				}
			}catch (Exception e) {
				System.out.println("입력값을 확인하세요.");
			}
		}
	}
	
	// 계좌 채크
	
	private void accountCheck(int sel) {
		if(um.users.get(Bank.log).getAccounts().size()>0) {
			System.out.println("계좌번호를 입력하세요.");
			String acc = Bank.sc.next();
			try {
				int account = Integer.parseInt(acc);
				int check = -1;
				for(int i=0; i<um.users.get(Bank.log).getAccounts().size(); i++) {
					if(um.users.get(Bank.log).getAccounts().get(i).getAccount() == account) {
						check = i;
					}
				}
				if(check != -1) {
					if(sel==1) {
						inMoney(check);						
					}
					else if(sel == 2) {
						outMoney(check);
					}
					else if(sel == 3) {
						sendAccountCheck(check);
					}
					else if(sel == 4) {
						checkMoney(check);
					}
				}
				else System.out.println("계좌번호를 다시 확인해 주세요");
				
			} catch (Exception e) {
				System.out.println("입력값을 확인하세요.");
			}
		}
		else System.out.println("계좌가 존재하지 않습니다.");
	}
	
	//입금
	
	private void inMoney(int idx) {
		System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
		System.out.println("금액을 입력하세요.");
		String my = Bank.sc.next();
		try {
			int money = Integer.parseInt(my);
			if(money>0) {
				um.users.get(Bank.log).getAccounts().get(idx).setMoney(money);
				System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
				System.out.println("입금 완료!");
			}
			else System.out.println("잘못된 금액 입니다.");
			
		}catch (Exception e) {
			System.out.println("입력값을 확인하세요.");
		}
	}
	
	//출금
	
	private void outMoney(int idx) {
		System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
		System.out.println("금액을 입력하세요.");
		String my = Bank.sc.next();
		try {
			int money = Integer.parseInt(my);
			if(money>0 && money<=um.users.get(Bank.log).getAccounts().get(idx).getMoney()) {
				um.users.get(Bank.log).getAccounts().get(idx).setMoney(-money);
				System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
				System.out.println("출금 완료!");
			}
			else System.out.println("잘못된 금액 입니다.");
			
		}catch (Exception e) {
			System.out.println("입력값을 확인하세요.");
		}
	}
	
	//이체
	private void sendAccountCheck(int idx) {
		if(um.users.get(Bank.log).getAccounts().size()>1) {
			System.out.println("상대방 계좌번호를 입력하세요.");
			String acc = Bank.sc.next();
			try {
				int account = Integer.parseInt(acc);
				int check = -1;
				for(int i=0; i<um.users.size(); i++) {
					if(um.users.get(i).getAccounts().size()>0) {
						for(int j=0; j<um.users.get(i).getAccounts().size(); j++) {
							if(i != Bank.log && um.users.get(i).getAccounts().get(j).getAccount() == account) {
								check = i;
							}
						}
					}
				}
				
				if(check != -1) {
					sendMoney(idx, check);
				}
				else System.out.println("계좌번호를 다시 확인해 주세요");
				
			} catch (Exception e) {
				System.out.println("입력값을 확인하세요.");
			}
		}
		else System.out.println("가입된 계좌가 부족합니다.");
	}
	
	private void sendMoney(int myIdx, int idx) {
		System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(myIdx).getMoney());
		System.out.println("보내실 금액을 입력하세요.");
		String my = Bank.sc.next();
		try {
			int money = Integer.parseInt(my);
			if(money>0 && money<=um.users.get(Bank.log).getAccounts().get(myIdx).getMoney()) {
				um.users.get(Bank.log).getAccounts().get(myIdx).setMoney(-money);
				um.users.get(Bank.log).getAccounts().get(idx).setMoney(money);
				System.out.printf("나의 현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
				System.out.printf("상대방의 현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(myIdx).getMoney());
				System.out.println("이체 완료!");
			}
			else System.out.println("잘못된 금액 입니다.");
			
		}catch (Exception e) {
			System.out.println("입력값을 확인하세요.");
		}
	}
	
	//조회
	private void checkMoney(int idx) {
		System.out.printf("현재 잔액 : %d원\n",um.users.get(Bank.log).getAccounts().get(idx).getMoney());
	}
	
}
