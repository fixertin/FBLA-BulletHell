
package com.fblaTeam.bullethell.worlds.waves.world2;

import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave3World2 extends Wave{

	public Wave3World2(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, -32, -32));
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()-32, -32));
		
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, -32, 90));
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, handler.getWidth(), 150));

	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(90, 43);
		getEnemy(0).addShootArc(9, 45, 90, 1.6);
		getEnemy(0).addWait(10);
		
		getEnemy(1).addMovement(90, 135);
		getEnemy(1).addShootArc(9, 45, 90, 1.6);
		getEnemy(1).addWait(10);
		
		getEnemy(2).addWait(2);
		getEnemy(2).addMovement(32, 0);
		getEnemy(2).addInfinShootStraightMoving(90, 0, 30);
		
		getEnemy(3).addWait(2);
		getEnemy(3).addMovement(32, 180);
		getEnemy(3).addInfinShootStraightMoving(90, 180, 30);
		
	}

}
