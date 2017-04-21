package com.fblaTeam.bullethell.worlds.waves;


import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;

public abstract class Wave {
	protected Handler handler;
	protected World world;
	
	public Wave(Handler handler, World world){
		this.handler = handler;
		this.world = world;
	}
	
	public abstract void addEnemies();
	public abstract void addCommands();

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public World getWorld(){
		return world;
	}
	public void setWorld(World world){
		this.world = world;
	}
	
	protected Enemy getEnemy(int i){
		return world.getEnemies().get(i);
	}
	protected void addEnemy(Enemy e){
		handler.getWorld().getEnemies().add(e);
	}
	
	
}
