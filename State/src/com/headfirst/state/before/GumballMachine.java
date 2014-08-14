package com.headfirst.state.before;

public class GumballMachine {
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	int state = SOLD_OUT;
	int count = 0;
	
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("동전은 한 개만 넣어주세요");
		} else if (state == NO_QUARTER) {
			System.out.println("동전을 넣으셨습니다.");
			state = HAS_QUARTER;
		} else if (state == SOLD_OUT) {
			System.out.println("매진되었습니다. 다음에 이용해주세요.");
		} else if (state == SOLD) {
			System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
		}
	}
	
	/**
	 * 동전 반환
	 */
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("동전이 반환됩니다.");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD) {
			System.out.println("이미 알맹이를 뽑으셨습니다.");
		} else if (state == SOLD_OUT) {
			System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
		}
	}
	
	public void turnCrank() {
		if (state == SOLD) {
			System.out.println("손잡이는 한 번만 돌려주세요.");
		} else if (state == NO_QUARTER) {
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD_OUT) {
			System.out.println("매진되었습니다.");
		} else if (state == HAS_QUARTER) {
			System.out.println("손잡이를 돌리셨습니다.");
			state = SOLD;
			dispense();
		}
	}

	private void dispense() {
		if (state == SOLD) {
			System.out.println("알맹이가 나가고 있습니다.");
			count -= 1;
			if (count == 0) {
				System.out.println("더 이상 알맹이가 없습니다.");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("동전을 넣어주세요.");
		} else if (state == SOLD_OUT) {
			System.out.println("매진입니다.");
		} else if (state == HAS_QUARTER) {
			System.out.println("알맹이가 나갈 수 없습니다.");
		}
	}
	
	public String toString() {
		String stateStr = null;
		if (state == SOLD_OUT)
			stateStr = "알맹이 매진";
		else if (state == NO_QUARTER)
			stateStr = "동전없음(투입 대기중)";
		else if (state == HAS_QUARTER)
			stateStr = "동전있음";
		else if (state == SOLD) {
			stateStr = "알맹이판매";
		}
		return "남은 개수: "+ count + "\n기계상태: " + stateStr;
	}
}
