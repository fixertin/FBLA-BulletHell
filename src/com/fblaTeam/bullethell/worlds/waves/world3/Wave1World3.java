package com.fblaTeam.bullethell.worlds.waves.world3;

import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave1World3 extends Wave{

	public Wave1World3(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		world.getEnemies().add(new BasicTestEnemy(handler, 60, -64));
		world.getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()-124, -64));
		world.getEnemies().add(new BasicTestEnemy(handler, (handler.getWidth()/2)-32, -64));
		getEnemy(2).setHealth(10);
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(180, 90);
		getEnemy(0).addShootPatternCircle(30);
		getEnemy(0).addWait(4);
		getEnemy(0).addMoveToEdge(180);
		
		getEnemy(1).addMovement(180, 90);
		getEnemy(1).addShootPatternCircle(30);
		getEnemy(1).addWait(4);
		getEnemy(1).addMoveToEdge(0);
		
		getEnemy(2).addMovement(90, 90);
		getEnemy(2).addShootArc(9, 45, 90, 2);
		getEnemy(2).addWait(1);
		getEnemy(2).addShootArc(9, 40, 90, 2);
	}

}
