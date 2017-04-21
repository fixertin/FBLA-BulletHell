package com.fblaTeam.bullethell.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.fblaTeam.bullethell.GFX.Assets;
import com.fblaTeam.bullethell.GFX.Background;
import com.fblaTeam.bullethell.entities.Player;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.sounds.AudioPlayer;
import com.fblaTeam.bullethell.tools.HighscoreReader;
import com.fblaTeam.bullethell.worlds.waves.Wave;
import com.fblaTeam.bullethell.worlds.waves.Wave2World1;
import com.fblaTeam.bullethell.worlds.waves.world2.Wave1World2;
import com.fblaTeam.bullethell.worlds.waves.world2.Wave2World2;
import com.fblaTeam.bullethell.worlds.waves.world2.Wave3World2;
import com.fblaTeam.bullethell.worlds.waves.world2.Wave4World2;

public class World2 extends World{
	public int waveIndex;
	public boolean gameWon, highScoreChange;
	public ArrayList<String> highScores;
	public int highScoreAmount, framegap = 0;
	private String message = "Press enter to continue";
	public boolean isPlayingMusic = false;
	public Background background;
	

	public World2(Handler handler) {
		super(handler);
		highScoreFilePath = "highscores/world2.txt";
		playerLives = 5;
		init();
	}
	
	public void goToNextLevel(){
		if(handler.isMusicToggle())
			AudioPlayer.getMusic("test").stop();
		isPlayingMusic = false;
		handler.getGameState().getHighScoreWorld().playerScore = playerScore;
		handler.getGameState().worlds[handler.getGameState().worlds.length-2].setScores(scores);
		if(playerScore > scores[scores.length-1].getScore()){
			handler.setWorld(handler.getGameState().worlds[handler.getGameState().worlds.length-1]);
		} else {
			handler.setWorld(handler.getGameState().worlds[handler.getGameState().worlds.length-2]);
		}
	}

	@Override
	public void init() {
		p = new Player(handler, 100, 300);
		worldName = "world 1";
		waves = new Wave[8];
		highScores = HighscoreReader.getLines("highscores/world2.txt");
		highScoreAmount = highScores.size();
		for(int i=0; i<highScoreAmount; i++)
			fillHighscoreMap(i);
		for(int i=0; i<highScores.size(); i++)
			System.out.println(highScores.get(i));
		fillWaves();
		background = new Background(handler);
	}
	public void fillWaves(){
		waves[0] = new Wave1World2(handler, this);
		waves[1] = new Wave2World2(handler, this);
		waves[2] = new Wave3World2(handler, this);
		waves[3] = new Wave1World2(handler, this);
		waves[4] = new Wave2World1(handler, this);
		waves[5] = new Wave4World2(handler, this);
		waves[6] = new Wave1World2(handler, this);
		waves[7] = new Wave3World2(handler, this);
	}

	@Override
	public void tick() {
		background.tick();
		if(!isPlayingMusic && handler.isMusicToggle()){
			AudioPlayer.getMusic("test").loop();
			isPlayingMusic = true;
		}
		if(playerLives > 0 )
			p.tick();
		else if(playerLives <= 0 && !p.explosionAnimation.isFinished)
			p.tick();
		
		if(gameWon || playerLives <= 0)
			framegap++;
		if(gameWon && handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
			goToNextLevel();
		else if(playerLives <= 0 && handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
			handler.getGame().resetGame();
		if(framegap >= 30)
			framegap = 0;
		if(enemies.size() <= 0 && !gameWon){
			checkWaveInit();
			waveIndex++;
			System.out.println(waveIndex);
		} 
		tickBullets();
		tickEnemies();
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		if(playerLives > 0)
			p.render(g);
		else if(playerLives <= 0 && !p.explosionAnimation.isFinished)
			p.render(g);
		for(int i=0; i<bullets.size(); i++)
			bullets.get(i).render(g);
		for(int i=0; i<enemies.size(); i++)
			enemies.get(i).render(g);
		if(framegap >= 10 && playerLives > 0)
			Assets.drawSentence(handler.getWidth()/2-(message.length()*8), handler.getHeight()/2, message, g);
		else if(framegap >= 10)
			Assets.drawSentence(handler.getWidth()/2-(message.length()*8), handler.getHeight()/2, "press enter to return", g);
	}
	
	private void fillHighscoreMap(int index){
		String[] temp;
		temp = highScores.get(index).split(" ");
		scores[index] = new Score(temp[0], Integer.parseInt(temp[1]));
	}
	
	
	public void checkWaveInit(){
		if(waveIndex+1 > waves.length){
			gameWon = true;
			return;
		}
		waves[waveIndex].addEnemies();
		waves[waveIndex].addCommands();
		
	}

}
