package com.fblaTeam.bullethell.worlds.waves.world2;

import com.fblaTeam.bullethell.entities.enemies.SmallEnemy2;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave4World2 extends Wave{

	public Wave4World2(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		addEnemy(new SmallEnemy2(handler, 0, -64));
		addEnemy(new SmallEnemy2(handler, handler.getWidth()-64, -128));
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(200, 90);
		getEnemy(0).addShootShotgun(65, 75, 10);
		getEnemy(0).addWait(.6);
		getEnemy(0).addInfinShootStraightMoving(90, 25, 30);
		
		getEnemy(1).addMovement(200, 90);
		getEnemy(1).addShootShotgun(105, 115, 10);
		getEnemy(1).addWait(.6);
		getEnemy(1).addInfinShootStraightMoving(90, 180-25, 30);
	}
	
}
