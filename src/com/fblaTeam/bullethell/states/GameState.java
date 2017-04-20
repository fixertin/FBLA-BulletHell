package com.alexnaustin.bullethell.states;

import java.awt.Graphics;

import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.ui.UserInterface;
import com.alexnaustin.bullethell.worlds.HighscoreWorld;
import com.alexnaustin.bullethell.worlds.PlayerNameWorld;
import com.alexnaustin.bullethell.worlds.Score;
import com.alexnaustin.bullethell.worlds.World;
import com.alexnaustin.bullethell.worlds.World1;
import com.alexnaustin.bullethell.worlds.World2;



public class GameState extends State{
	public int currentWorldIndex, playerLives;
	public String playerName;
	public World[] worlds = new World[4];
	private UserInterface ui = new UserInterface(handler);
	
	public GameState(Handler handler){
		super(handler);
		worlds[0] = new World1(handler);
		worlds[1] = new World2(handler);
		worlds[2] = new HighscoreWorld(handler);
		worlds[3] = new PlayerNameWorld(handler);
		handler.setWorld(worlds[0]);
		
		//handler.getCamera().move(player.getX(), player.getY());
	}
	
	public World getCurrentWorld(){
		return worlds[currentWorldIndex];
	}
	
	public void setHighScoreList(Score[] scores){
		worlds[worlds.length-1].setScores(scores); 
	}
	
	public HighscoreWorld getHighScoreWorld(){
		return (HighscoreWorld) worlds[worlds.length-2];
	}
	
	@Override
	public void tick() {
		
		handler.getWorld().tick();
		if(currentWorldIndex <= 1){
			playerLives = getCurrentWorld().getPlayerLives();
		}
		ui.tick();
	}

	@Override
	public void render(Graphics g) {
		handler.getWorld().render(g);
		ui.render(g);
	}

}
