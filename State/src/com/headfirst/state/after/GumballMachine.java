package com.headfirst.state.after;

public class GumballMachine {
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count -= 1;
		}
	}
	
	public void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}
	
	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nMighty Gumball, Inc.");
		sb.append("\nJava-enabled Standing Gumball Model #2004");
		sb.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			sb.append("s");
		}
		sb.append("\nMachine is " + state + "\n");
		return sb.toString();
	}
}