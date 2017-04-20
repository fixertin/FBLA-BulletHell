package com.alexnaustin.bullethell.AI.bulletPatterns;


import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public abstract class Pattern {
	protected Enemy shooter;
	protected Handler handler;
	
	public Pattern(Handler handler, Enemy shooter){
		this.handler = handler;
		this.shooter = shooter;
	}
	
	public abstract void fillBullets();

	public Enemy getShooter() {
		return shooter;
	}

	public void setShooter(Enemy shooter) {
		this.shooter = shooter;
	}
	
}
