package com.alexnaustin.bullethell.worlds.waves;

import com.alexnaustin.bullethell.entities.enemies.BasicTestEnemy;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.worlds.World;

public class Wave2World1 extends Wave{

	public Wave2World1(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		world.getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()+64, -64));
		world.getEnemies().add(new BasicTestEnemy(handler, -64, -64));
	}

	@Override
	public void addCommands() {
		world.getEnemies().get(0).addMovement(280, 135);
		world.getEnemies().get(0).setSpeed(1);
		world.getEnemies().get(0).addInfinShootStraightMoving(90, 180, 15);
		
		world.getEnemies().get(1).addMovement(190, 45);
		world.getEnemies().get(1).addShootPatternAtPlayer(5, .07);
		world.getEnemies().get(1).addMovement(90, 0);
		world.getEnemies().get(1).addShootPatternAtPlayer(5, .07);
		world.getEnemies().get(1).addMovement(90, 0);
		world.getEnemies().get(1).addShootPatternAtPlayer(5, .07);
		world.getEnemies().get(1).addMoveToEdge(0);
	}

}
