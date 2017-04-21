package com.fblaTeam.bullethell.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.fblaTeam.bullethell.GFX.Assets;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.tools.HighscoreReader;

public class HighscoreWorld extends World{
	public String message = "press enter to continue";
	public String playerName;
	
	public HighscoreWorld(Handler handler) {
		super(handler);
	}

	
	public void checkAndAddHighscore(){
		int scoreIndex = 8;
		int highScoreAmount = 8;
		if(highScoreAmount != 0){
			for(int i=0; i<=highScoreAmount; i++){
				if(i == 8){
					return;
				}
				if(scores[i] != null && playerScore > scores[i].getScore() && i<highScoreAmount){
					scoreIndex = i;
					i = 10;
				}else if(scores[i] == null && i<=highScoreAmount){
					scoreIndex = i;
					i=10;
				}
			}
		}else{
			scoreIndex = 0;
		}
		Score[] temp;
		
		if(highScoreAmount < 8){
			temp = new Score[highScoreAmount+1];
		} else {
			temp = new Score[8];
		}
		
		if(highScoreAmount < 8){
			for(int ii=0; ii<=highScoreAmount; ii++){
				if(scoreIndex > ii){
					temp[ii] = scores[ii];
				} else if(scoreIndex == ii){
					temp[ii] = new Score(playerName, playerScore);
				} else {
					temp[ii] = scores[ii-1];
				}
			}
		} else {
			for(int ii=0; ii<highScoreAmount; ii++){
				if(scoreIndex > ii){
					temp[ii] = scores[ii];
				} else if(scoreIndex == ii){
					temp[ii] = new Score(playerName, playerScore);
				} else {
					temp[ii] = scores[ii-1];
				}
			}
		}
		this.scores = temp;
		HighscoreReader.reWriteHighScores(handler.getGameState().worlds[handler.getGameState().currentWorldIndex].highScoreFilePath, scores);
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
			if(handler.getGameState().currentWorldIndex+3 < handler.getGameState().worlds.length){
				handler.getGameState().currentWorldIndex++;
				handler.setWorld(handler.getGameState().worlds[handler.getGameState().currentWorldIndex]);
			} else {
				handler.getGame().resetGame();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		for(int i=0; i<scores.length; i++){
			if(scores[i] != null){
				Assets.drawSentence32(handler.getWidth()/2 - (32*10 /2), 32 + (i*34 ), scores[i].getName() + " " + scores[i].getScore(), g);
				//System.out.println(scores[i].getScore());
			}
		}
		Assets.drawSentence(handler.getWidth()/2 - (16*message.length() /2), 600-32, message, g);
	}

}
