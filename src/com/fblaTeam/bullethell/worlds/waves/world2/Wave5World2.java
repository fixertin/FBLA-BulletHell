package com.fblaTeam.bullethell.worlds.waves.world2;

import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave5World2 extends Wave{

	public Wave5World2(Handler handler, World world) {
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
		getEnemy(0).addShootShotgun(65, 75, 10);
		getEnemy(0).addWait(1.5);
		getEnemy(0).addInfinShootStraightMoving(90, 0, .3*60);
		
		getEnemy(1).addWait(3);
		getEnemy(1).addMovement(75, 0);
		getEnemy(1).addInfinShootStraightMoving(90, 0, .3*60);
		
		getEnemy(2).addMovement(75, 180);
		getEnemy(2).addShootShotgun(180-75, 180-65, 10);
		getEnemy(2).addWait(2.5);
		getEnemy(2).addInfinShootStraightMoving(90, 180, .3*60);
		
		getEnemy(3).addWait(3);
		getEnemy(3).addMovement(75, 180);
		getEnemy(3).addInfinShootStraightMoving(90, 180, .3*60);
	}

}
