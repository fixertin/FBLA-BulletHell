package com.fblaTeam.bullethell.ui;

import java.awt.Graphics;

import com.fblaTeam.bullethell.GFX.Assets;
import com.fblaTeam.bullethell.main.Handler;

public class UserInterface {
	public Handler handler;
	public String score = "";
	public String lives = "lives ";
	
	
	public UserInterface(Handler handler){
		this.handler = handler;
	}
	
	public void tick(){
		score = "";
		char[] temp = Integer.toString(handler.getGameState().getCurrentWorld().getPlayerScore()).toCharArray();
		int tempIndex = 0;
		for(int i=0; i<10; i++){
			if(i<(10-temp.length))
				score += 0;
			else{
				score += temp[tempIndex];
				tempIndex++;
			}
		}
		lives = "lives ";
		for(int i=0; i<handler.getGameState().getCurrentWorld().getPlayerLives(); i++){
			lives += '*';
		}
		
	}
	public void render(Graphics g){
		g.drawImage(Assets.ui, handler.getWidth(), 0, null);
		Assets.drawSentence32(handler.getWidth()+5, 16, "score", g);
		Assets.drawSentence(handler.getWidth()+5, 50, score, g);
		Assets.drawSentence(handler.getWidth()+5, 82, lives, g);
	}
	
}
