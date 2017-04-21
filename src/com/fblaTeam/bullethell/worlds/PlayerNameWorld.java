package com.fblaTeam.bullethell.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.fblaTeam.bullethell.GFX.Assets;
import com.fblaTeam.bullethell.clock.Timer;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.sounds.AudioPlayer;
import com.fblaTeam.bullethell.tiles.Letter;

public class PlayerNameWorld extends World{
	public Character[] playerName = new Character[3];
	public Letter[][] characters = new Letter[8][4];
	public int xStart, yStart, selectedX, selectedY, amountOfNameLetters, framegap;
	public Timer timer = new Timer(3);
	public boolean invalidName;

	public PlayerNameWorld(Handler handler) {
		super(handler);
		init();
	}

	@Override
	public void init() {
		timer.reset();
		xStart = handler.getWidth()/2 - (52*4);
		yStart = 72;
		fillCharacters();
	}
	

	@Override
	public void tick() {
		for(int i=0; i<4; i++){
			for(int ii=0; ii<8; ii++){
				if(characters[ii][i] != null && (i == selectedY) && (ii == selectedX)){
					characters[ii][i].setSelected(true);
				} else if(characters[ii][i] != null){
					characters[ii][i].setSelected(false);
				}
			}
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A) && selectedX > 0){
			selectedX--;
			AudioPlayer.getSound("select").play();
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D) && selectedX < 7 && (characters[selectedX+1][selectedY] != null)){
			selectedX++;
			AudioPlayer.getSound("select").play();
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S) && selectedY < 3 && (characters[selectedX][selectedY+1] != null)){
			selectedY++;
			AudioPlayer.getSound("select").play();
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W) && selectedY > 0){
			selectedY--;
			AudioPlayer.getSound("select").play();
		}
		playerNameChecker();
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER) && playerName[playerName.length-1] != null){
			AudioPlayer.getSound("select").play();
			String temp = turnNameToString();
			handler.getGameState().getHighScoreWorld().playerName = temp;
			handler.getGameState().getHighScoreWorld().checkAndAddHighscore();
			handler.setWorld(handler.getGameState().worlds[handler.getGameState().worlds.length-2]);
		} else if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
			invalidName = true;
			timer.reset();
		}
		if(invalidName){
			framegap++;
			timer.tick();
		}
		if(timer.hasReachedTime()){
			invalidName = false;
		}
		
		if(framegap >= 30)
			framegap = 0;
		
	}
	
	public void playerNameChecker(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E) && amountOfNameLetters != playerName.length){
			playerName[amountOfNameLetters] = characters[selectedX][selectedY].getCharacter();
			amountOfNameLetters++;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_BACK_SPACE) && amountOfNameLetters != 0){
			playerName[amountOfNameLetters-1] = null;
			amountOfNameLetters--;
		}
	}

	@Override
	public void render(Graphics g) {
		for(int i=0; i<4; i++){
			for(int ii=0; ii<8; ii++){
				if(characters[ii][i] != null){
					String temp = Character.toString(characters[ii][i].getCharacter());
					Assets.drawSentence32((int)characters[ii][i].getX(), (int)characters[ii][i].getY(), temp, g);
					
					if(characters[ii][i].isSelected()){
						g.drawImage(Assets.selectedLetter, (int)characters[ii][i].getX()-2, (int)characters[ii][i].getY()-1, null);
					}
				}
			}
		}
		
		for(int x=0; x<playerName.length; x++){
			if(playerName[x] != null){
				String temp2 = playerName[x].toString();
				Assets.drawSentence32(handler.getWidth()/2 - (52*2) + (x*32), 32, temp2, g);
			}
		}
		
		
		Assets.drawSentence(handler.getWidth()/2-("press e to select letter".length()*8), 532, "press e to select letter", g);
		Assets.drawSentence(handler.getWidth()/2-("press Backspace to go back".length()*8), 550, "press Backspace to go back", g);
		if(!invalidName)
			Assets.drawSentence(handler.getWidth()/2-("press enter to continue".length()*8), 568, "press enter to continue", g);
		else if(framegap >= 10)
			Assets.drawSentence(handler.getWidth()/2-("please enter a name".length()*8), 568, "please enter a name", g);
	}

	public void fillCharacters(){
		char[] temp = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int index = 0;
		for(int i=0; i<4; i++){
			for(int ii=0; ii<8; ii++){
				if(index < temp.length){
					characters[ii][i] = new Letter(temp[index], xStart + (52 * ii), yStart + (52 * i));
					index++;
				}
			}
		}
		characters[0][0].setSelected(true);
	}
	
	public String turnNameToString(){
		String temp = "";
		for(int i=0; i<playerName.length; i++){
			temp += playerName[i];
		}
		return temp;
	}
	
}
