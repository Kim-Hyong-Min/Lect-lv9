package Game;

public class Main {
	// 유닛
	// ㄴ 이름, 기본 채력, 현제 채력, 공격력, 사망여부
	// ㄴ 고유 스킬
	
	// 유닛메니저
	// ㄴ 아군 유닛 세팅
	// ㄴ 적군 파티 세팅 : 적군의 클래스를 받아서 배열생성
	
	// 스테이지
	// 아군
	// ㄴ 순서별 공격 / 스킬
	// 적군
	// ㄴ 공격 / 스킬시전
	
	// 사망시 행동 X
	
	// 전부 사망시 종료 : 각 상대별 전체 사망자수 총합으로 비교
	// 한명이라도 남으면 전투 종료 후 다음 스테이지
	public static void main(String[] args) {
		StageManager sm = new StageManager();
		sm.StageMenu();
	}
}
