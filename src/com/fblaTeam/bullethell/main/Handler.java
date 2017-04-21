package com.fblaTeam.bullethell.main;

import com.fblaTeam.bullethell.GFX.GameCamera;
import com.fblaTeam.bullethell.input.KeyManager;
import com.fblaTeam.bullethell.states.GameState;
import com.fblaTeam.bullethell.states.MenuState;
import com.fblaTeam.bullethell.worlds.World;

public class Handler {
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public double checkAngle(double angle){
		if((0<=angle) && (angle<=90))
			return angle;
		else if((90<=angle) && (angle<=180))
			return 180 - angle;
		else if((180<=angle) && (angle<=270))
			return 90 - (270 - angle);
		else if((270<=angle) && (angle<=360))
			return 360 - angle;
		else
			return 0;
	}
	public boolean checkVelX(double angle){
		if((0<=angle) && (angle<=90))
			return false;
		else if((90<=angle) && (angle<=180))
			return true;
		else if((180<=angle) && (angle<=270))
			return true;
		else if((270<=angle) && (angle<=360))
			return false;
		else
			return false;
	}
	public boolean checkVelY(double angle){
		if((0<=angle) && (angle<=90))
			return false;
		else if((90<=angle) && (angle<=180))
			return false;
		else if((180<=angle) && (angle<=270))
			return true;
		else if((270<=angle) && (angle<=360))
			return true;
		else
			return false;
	}
	public double getXSpeed(double angle, double h){
		double temp = Math.cos(Math.toRadians(angle)) * h;
		return temp;
	}
	public double getYSpeed(double angle, double h){
		double temp = Math.sin(Math.toRadians(angle)) * h;
		return temp;
	}
	
	public int getWidth(){
		return game.width;
	}
	public int getHeight(){
		return game.height;
	}
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	public GameCamera getCamera(){
		return game.getCamera();
	}
	public GameState getGameState(){
		return game.getGameState();
	}
	public MenuState getMenuState(){
		return (MenuState)game.menuState;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public boolean isMusicToggle() {
		return game.getMusicToggle();
	}
	public void setMusicToggle(boolean musicToggle) {
		game.setMusicToggle(musicToggle);
	}
	public boolean isSoundToggle() {
		return game.getSoundToggle();
	}
	public void setSoundToggle(boolean soundToggle) {
		game.setSoundToggle(soundToggle);
	}
}
