package com.alexnaustin.bullethell.worlds;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.Background;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.entities.Player;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.sounds.AudioPlayer;
import com.alexnaustin.bullethell.tools.HighscoreReader;
import com.alexnaustin.bullethell.worlds.waves.Wave;
import com.alexnaustin.bullethell.worlds.waves.Wave1World1;
import com.alexnaustin.bullethell.worlds.waves.Wave2World1;
import com.alexnaustin.bullethell.worlds.waves.Wave3World1;
import com.alexnaustin.bullethell.worlds.waves.Wave4World1;
import com.alexnaustin.bullethell.worlds.waves.Wave5World1;

public class World1 extends World{
	public int waveIndex;
	public boolean gameWon, highScoreChange;
	public ArrayList<String> highScores;
	public int highScoreAmount, framegap = 0;
	private String message = "Press enter to continue";
	public boolean isPlayingMusic = false;
	public Background background;
	
	
	public World1(Handler handler) {
		super(handler);
		highScoreFilePath = "highscores/world1.txt";
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
		p = new Player(handler, handler.getWidth()/2 -32, 300);
		worldName = "world 1";
		waves = new Wave[6];
		highScores = HighscoreReader.getLines("highscores/world1.txt");
		highScoreAmount = highScores.size();
		for(int i=0; i<highScoreAmount; i++)
			fillHighscoreMap(i);
		for(int i=0; i<highScores.size(); i++)
			System.out.println(highScores.get(i));
		fillWaves();
		background = new Background(handler);
	}
	
	private void fillHighscoreMap(int index){
		String[] temp;
		temp = highScores.get(index).split(" ");
		scores[index] = new Score(temp[0], Integer.parseInt(temp[1]));
	}
	
	public void fillWaves(){
		waves[0] = new Wave1World1(handler, this);
		waves[1] = new Wave2World1(handler, this);
		waves[2] = new Wave3World1(handler, this);
		waves[3] = new Wave2World1(handler, this);
		waves[4] = new Wave4World1(handler, this);
		waves[5] = new Wave5World1(handler, this);
	}
	
	public void checkWaveInit(){
		if(waveIndex+1 > waves.length){
			gameWon = true;
			return;
		}
		waves[waveIndex].addEnemies();
		waves[waveIndex].addCommands();
	}

	public void tick(){
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
	public void render(Graphics g){
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
	
	//cleanup functions
	public void tickBullets(){
		for(int i=0; i<bullets.size(); i++){
			bullets.get(i).tick();
			if(bullets.get(i).isAtEdge())
				bullets.remove(i);
		}
	}
	public void tickEnemies(){
		for(int i=0; i<enemies.size(); i++){
			if(playerLives > 0){
				for(int ii=0; ii<bullets.size(); ii++){
					if(bullets.get(ii).getHitbox().intersects(enemies.get(i).getHitbox()) && (bullets.get(ii).getShooter() instanceof Player) && !enemies.get(i).isDead()){
						enemies.get(i).setHealth(enemies.get(i).getHealth() - 1);
						bullets.remove(ii);
						if(enemies.get(i).getHealth() <= 0){
							enemies.get(i).setDead(true);
							playerScore += enemies.get(i).getScoreReward();
						}
					}
					if(ii<bullets.size() && bullets.get(ii).getHitbox().intersects(p.getHitbox()) && (bullets.get(ii).getShooter() instanceof Enemy) ){
						p.isDead = true;
						bullets.remove(ii);
						if(playerLives > 0){
							playerLives -= 1;
						}
					}
				}
				
				if(enemies.get(i).isRemoved())
					enemies.remove(i);
				else
					enemies.get(i).tick();
			} else if(!enemies.get(i).isRemoved() && enemies.get(i).isDead())
				enemies.get(i).tick();
			else if(enemies.get(i).isRemoved())
				enemies.remove(i);
			
		}
	}
	


}
