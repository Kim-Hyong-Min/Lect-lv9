package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Account;
import models.User;

public class FileManager {
	File file = new File("Bank.txt");
	private UserManager um = UserManager.instance;
	private String tempArr[];
	public static FileManager instance = new FileManager();

	private FileManager() {
	}

	// 전체 회원수
	// userCode / id / pw / name / accCnt / account / money ...
	public void save() {
		try {
			FileWriter fw = new FileWriter(this.file);
			if (this.um.users.size() > 0) {
				fw.write(this.um.users.size() + "\n");
				for (int i = 0; i < this.um.users.size(); i++) {
					fw.write(this.um.users.get(i).getuserCode() + "/");
					fw.write(this.um.users.get(i).getId() + "/");
					fw.write(this.um.users.get(i).getPw() + "/");
					fw.write(this.um.users.get(i).getName() + "/");
					fw.write(this.um.users.get(i).getAccCnt() + "/");
					if (this.um.users.get(i).getAccCnt() > 0) {
						for (int j = 0; j < this.um.users.get(i).getAccounts().size(); j++) {
							fw.write(this.um.users.get(i).getAccounts().get(j).getAccount() + "/");
							fw.write(this.um.users.get(i).getAccounts().get(j).getMoney() + "/");
						}
					}
					fw.write("\n");
				}
			} else {
				User admin = new User(0, "admin", "0000", "admin");
				this.um.users.add(admin);
				for (int i = 0; i < this.um.users.size(); i++) {
					fw.write(this.um.users.get(i).getuserCode() + "/");
					fw.write(this.um.users.get(i).getId() + "/");
					fw.write(this.um.users.get(i).getPw() + "/");
					fw.write(this.um.users.get(i).getName() + "/");
					fw.write(this.um.users.get(i).getAccCnt() + "/");
				}
				fw.write("\n");
			}
			fw.close();
		} catch (Exception e) {

		}
	}

	public void load() {
		if (file.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(this.file);
				br = new BufferedReader(fr);
				String UserNum = br.readLine();
				if (Integer.parseInt(UserNum) > 0) {
					for (int i = 0; i < Integer.parseInt(UserNum); i++) {
						String temp = br.readLine();
						String tempArr[] = temp.split("/");
						User User = new User(Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3]);
						this.um.users.add(User);
						if (Integer.parseInt(tempArr[4]) > 0) {
							this.um.users.get(i).setAccCnt(Integer.parseInt(tempArr[4]));
							for (int j = 0; j < Integer.parseInt(tempArr[4]); j++) {
								Account ac = new Account(Integer.parseInt(tempArr[5 + j * 2]));
								this.um.users.get(i).getAccounts().add(ac);
								this.um.users.get(i).getAccounts().get(j)
										.setLoadMoney(Integer.parseInt(tempArr[6 + j * 2]));
							}
						}
					}
				}
				fr.close();
				br.close();

			} catch (Exception e) {
			}
		}
	}
}
