package com.fblaTeam.bullethell.worlds.waves.world2;

import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.entities.enemies.SmallEnemy2;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave2World2 extends Wave{

	public Wave2World2(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()/2-32, -64));
		handler.getWorld().getEnemies().add(new SmallEnemy2(handler, -64, -32));
		handler.getWorld().getEnemies().add(new SmallEnemy2(handler, handler.getWidth(), -32));
	}

	@Override
	public void addCommands() {
		getEnemy(0).addWait(2);
		getEnemy(0).addMovement(120+32, 90);
		getEnemy(0).addShootArc(10, 45, (90+45)-45, 2);
		getEnemy(0).addWait(1.5);
		getEnemy(0).addShootArc(10, 45, (90+45)-45, 2);
		getEnemy(0).addWait(1.5);
		getEnemy(0).addShootArc(10, 45, (90+45)-45, 2);
		getEnemy(0).addWait(1.5);
		getEnemy(0).addShootArc(10, 45, (90+45)-45, 2);
		getEnemy(0).addMoveToEdge(0);
		
		
		getEnemy(1).addWait(3);
		getEnemy(1).addMovement(120, 45);
		getEnemy(1).addShootPatternAtPlayer(5, .2);
		getEnemy(1).setSpeed(4);
		getEnemy(1).addInfinShootStraightMoving(90, 0, 90);
		
		getEnemy(2).addWait(3);
		getEnemy(2).addMovement(200, 135);
		getEnemy(2).addShootPatternAtPlayer(5, .2);
		getEnemy(2).setSpeed(4);
		getEnemy(2).addInfinShootStraightMoving(90, 180, 90);
	}

}
