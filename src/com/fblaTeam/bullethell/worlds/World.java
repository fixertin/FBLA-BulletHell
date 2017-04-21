package com.fblaTeam.bullethell.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import com.fblaTeam.bullethell.creatures.Bullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.entities.Player;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.waves.Wave;


public abstract class World {
	protected Handler handler;
	protected Player p;
	protected Wave[] waves;
	protected Score[] scores;
	protected String worldName;
	protected String highScoreFilePath;
	protected int playerScore, playerLives;
	protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	protected ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	public World(Handler handler){
		this.handler = handler;
		scores = new Score[8];
	}
	

	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//cleanup
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
					if(ii<bullets.size() && bullets.get(ii).getHitbox().intersects(p.getHitbox()) && (bullets.get(ii).getShooter() instanceof Enemy) && !p.isInvincible){
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

	public String getName(){
		return worldName;
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public Wave[] getWaves() {
		return waves;
	}
	public void setWaves(Wave[] waves) {
		this.waves = waves;
	}
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}


	public Score[] getScores() {
		return scores;
	}


	public void setScores(Score[] scores) {
		this.scores = scores;
	}


	public String getWorldName() {
		return worldName;
	}


	public void setWorldName(String worldName) {
		this.worldName = worldName;
	}
	
	public String getPath(){
		return highScoreFilePath;
	}


	public int getPlayerScore() {
		return playerScore;
	}
	public int getPlayerLives() {
		return playerLives;
	}


	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
}
