package com.fblaTeam.bullethell.worlds.waves;

import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;

public class Wave5World1 extends Wave{

	public Wave5World1(Handler handler, World world) {
		super(handler, world);
		
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, -64, 64));
		handler.getWorld().getEnemies().add(new SmallEnemyBlue(handler, handler.getWidth(), 145));
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(180, 0);
		getEnemy(0).addShootArc(20, 0, 180);
		getEnemy(0).addMoveToEdge(0);
		
		getEnemy(1).addMovement(180, 180);
		getEnemy(1).addShootArc(20, 0, 180);
		getEnemy(1).addMoveToEdge(180);

	}

}
