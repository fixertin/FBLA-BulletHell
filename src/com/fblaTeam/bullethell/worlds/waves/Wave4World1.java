package com.fblaTeam.bullethell.worlds.waves;

import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;

public class Wave4World1 extends Wave{

	public Wave4World1(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, -64, 64));
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, -64, 64));
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, handler.getWidth(), 64));
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, handler.getWidth(), 145));
		
		getEnemy(0).setSpeed(3);
		getEnemy(1).setSpeed(3);
		getEnemy(2).setSpeed(3);
		getEnemy(3).setSpeed(3);
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(75, 0);
		getEnemy(0).addInfinShootStraightMoving(90, 0, .3*60);
		
		getEnemy(1).addWait(1);
		getEnemy(1).addMovement(75, 0);
		getEnemy(1).addInfinShootStraightMoving(90, 0, .3*60);
		
		getEnemy(2).addMovement(75, 180);
		getEnemy(2).addInfinShootStraightMoving(90, 180, .3*60);
		
		getEnemy(3).addWait(1);
		getEnemy(3).addMovement(75, 180);
		getEnemy(3).addInfinShootStraightMoving(90, 180, .3*60);
	}

}
