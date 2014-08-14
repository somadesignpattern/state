package com.headfirst.state.after;

public class SoldOutState implements State {
	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("동전을 넣을 수 없습니다. 매진입니다.");
	}
	
	public void ejectQuarter() {
		System.out.println("알맹이를 꺼낼 수 없습니다.");
	}

	public void turnCrank() {
		System.out.println("손잡이를 돌리셨습니다. 알맹이가 매진되었습니다.");
	}
	
	public void dispense() {
		System.out.println("알맹이가 매진되었습니다.");
	}
	
	public String toString() {
		return "알맹이 매진";
	}
}