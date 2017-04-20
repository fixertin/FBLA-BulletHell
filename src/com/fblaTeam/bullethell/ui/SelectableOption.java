package com.alexnaustin.bullethell.ui;

import java.awt.Graphics;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.states.MenuState;
import com.alexnaustin.bullethell.states.State;

public class SelectableOption {
	public String sentence;
	public boolean isSelected, isActivated;
	public State goToState;
	public Handler handler;
	public double x, y;
	
	public SelectableOption(Handler handler, String sentence, State goToState, double x, double y){
		this.handler = handler;
		this.sentence = sentence;
		isSelected = false;
		this.goToState = goToState;
		this.x = x;
		this.y = y;
		
	}
	
	public void tick(){
		if(isActivated && goToState != null && (goToState instanceof MenuState)){
			handler.getGame().resetGame();
		} else if(isActivated && goToState != null)
			State.setState(goToState);
		else if(isActivated)
			System.out.println("is null bro");
	}
	public void render(Graphics g){
		if(isSelected)
			Assets.drawSentence((int)x-16, (int)y, ">"+sentence, g);
		else
			Assets.drawSentence((int)x, (int)y, sentence, g);
	}
}
