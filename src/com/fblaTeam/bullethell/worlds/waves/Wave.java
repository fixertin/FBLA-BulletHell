package com.alexnaustin.bullethell.worlds.waves;


import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.worlds.World;

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
	
	
}
