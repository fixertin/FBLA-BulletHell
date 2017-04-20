package com.alexnaustin.bullethell.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import com.alexnaustin.bullethell.creatures.Bullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.entities.Player;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.worlds.waves.Wave;


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
