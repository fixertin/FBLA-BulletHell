package com.fblaTeam.bullethell.worlds.waves.world2;

import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;
import com.fblaTeam.bullethell.worlds.waves.Wave;

public class Wave1World2 extends Wave{

	public Wave1World2(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, -32, -32));
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()-32, -32));
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(90, 43);
		getEnemy(0).addShootArc(9, 45, 90, 2);
		getEnemy(0).addWait(1);
		getEnemy(0).addShootArc(9, 40, 90, 2);
		
		getEnemy(1).addMovement(90, 135);
		getEnemy(1).addShootArc(9, 45, 90, 2);
		getEnemy(1).addWait(1);
		getEnemy(1).addShootArc(9, 50, 90, 2);
	}

}
