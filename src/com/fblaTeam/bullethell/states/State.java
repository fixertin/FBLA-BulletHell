package com.fblaTeam.bullethell.states;

import java.awt.Graphics;

import com.fblaTeam.bullethell.main.Handler;



public abstract class State {
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void init(){
		
	}
	
}
