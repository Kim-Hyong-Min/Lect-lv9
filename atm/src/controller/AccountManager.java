package controller;

import java.util.Random;

import models.Account;
import models.Bank;
import models.User;

public class AccountManager {
	public static AccountManager instance = new AccountManager();

	private Random rn = new Random();
	private UserManager um = UserManager.instance;
	private int check;

	public void setCheck(int check) {
		this.check = check;
	}

	public boolean back() {
		if (this.check == 0) {
			return true;
		} else
			return false;
	}

	public void accountMenu() {
		System.out.println(Bank.getName() + "ATM");
		while (back()) {
			printMenu();
			selectMenu();
		}
	}

	private void selectMenu() {
		String input = Bank.sc.next();

		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				createAccount();
			} else if (sel == 2) {
				deleteAccount();
			} else if (sel == 3) {
				this.check = 1;
			}
		} catch (Exception e) {
			System.out.println("입력값을 확인하세요.");
		}
	}

	private void printMenu() {
		System.out.println("1.계좌 개설\n2.계좌 철회\n3.뒤로가기");
	}

	public void createAccount() {
		if (UserManager.instance.users.get(Bank.log).getAccounts().size() < 3) {
			while (true) {
				System.out.println("신규 계좌를 개설 하시겠습니까? (1.Yes/2.No)");
				String input = Bank.sc.next();
				try {
					int sel = Integer.parseInt(input);
					if (sel == 1) {
						newAccount();
						break;
					} else if (sel == 2) {
						break;
					}

				} catch (Exception e) {
					System.out.println("입력값을 확인하세요.");
				}
			}
		} else
			System.out.println("계좌는 최대 3개까지 가지실 수 있습니다.");
	}

	public void newAccount() {
		if (um.users.get(Bank.log).getAccCnt() < 3) {
			while (true) {
				int rNum = rn.nextInt(89999) + 10000;
				if (um.users.size() > 0) {
					for (int i = 0; i < um.users.size(); i++) {
						if (um.users.get(i).getAccounts().size() > 0) {
							for (int j = 0; j < um.users.get(i).getAccounts().size(); j++) {
								if (rNum == um.users.get(i).getAccounts().get(j).getAccount()) {
									rNum = 0;
								}
							}
						}
					}
				}
				if (rNum != 0) {
					Account ac = new Account(rNum);
					um.users.get(Bank.log).getAccounts().add(ac);
					um.users.get(Bank.log).setAccCnt(1);
					System.out.println("생성된 계좌번효 : " + rNum);
					break;
				}
			}
		} else
			System.out.println("이미 3개의 계좌가 존재합니다.");
	}

	public void deleteAccount() {
		if (um.users.get(Bank.log).getAccCnt() > 0) {
			System.out.println("삭제하실 계좌번호를 입력하세요.");
			String acc = Bank.sc.next();
			try {
				int account = Integer.parseInt(acc);
				for (int i = 0; i < um.users.get(Bank.log).getAccounts().size(); i++) {
					if (um.users.get(Bank.log).getAccounts().get(i).getAccount() == account) {
						um.users.get(Bank.log).getAccounts().remove(i);
						um.users.get(Bank.log).setAccCnt(-1);
						System.out.println("계좌가 삭제 되었습니다");
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("입력값을 확인하세요.");
			}
		} else
			System.out.println("계좌가 존재하지 않습니다.");
	}

	public void adminAccountCheck() {
		int total = 0;
		for (int i = 0; i < um.users.size(); i++) {
			total += um.users.get(i).getAccCnt();
		}
		if (total > 0) {
			System.out.printf("전체 회원의 총 계좌 수 : %d개\n", total);
			int cnt = 1;
			for (int i = 0; i < um.users.size(); i++) {
				if (um.users.get(i).getAccCnt() > 0) {
					System.out.println(cnt + ". 회원번호 : " + um.users.get(i).getuserCode());
					cnt++;
					for (int j = 0; j < um.users.get(i).getAccCnt(); j++) {
						System.out.println(
								"     " + (j + 1) + ". 계좌번호 : " + um.users.get(i).getAccounts().get(j).getAccount()
										+ " / 금액 : " + um.users.get(i).getAccounts().get(j).getMoney() + "원");
					}
				}
			}

		} else
			System.out.println("전체 회원의 총 계좌 수 : 0개");
	}
}
