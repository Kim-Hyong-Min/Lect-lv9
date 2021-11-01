package models;

public class Player extends Unit implements Attack, Damage, input{
	
	Player(String name, int Max_Hp, int Atk,  int Def, int Potion){
		super(name, Max_Hp, Atk, Def, Potion);
	}
	
	public void gearUp(int num) {
		if(num == 0 && this.getDef()<=25) {
			int rNum = rn.nextInt(10)+1;
			this.setDef(rNum);
		}
		else if(num == 1 || getDef()>25) {
			int rNum = rn.nextInt(10)+1;
			this.setAtk(rNum);
		}
	}
	
	public void healthUp() {
		int rNum = rn.nextInt(10)+20;
		this.setMax_Hp(rNum);
	}
	
	public void sleep() {
			int rNum = rn.nextInt(10)+30;
			this.setHp(rNum);
	}
	
	public void printPotion() {
		System.out.printf("[포션수량 %d 개]\n",this.getPotion());
	}
	
	public void drinkPotion() {
		System.out.println("[포션]을 마셨다!");
		this.setPotion(-1);
		int rNum = rn.nextInt(5)+50;
		this.setHp(rNum);
	}
	
	@Override
	public void attack(int num) {
		int rNum = rn.nextInt(10)+this.getAtk()-5-num;
		System.out.printf("%s는 %d의 데미지를 주었다!\n",this.getName(), rNum);
		setState(rNum);
	}
	
	public void defense() {
		int rNum = rn.nextInt(2)-1;
		System.out.printf("%s는 [방어]를 시도했다!\n",this.getName());
		setState(rNum);
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}


}
