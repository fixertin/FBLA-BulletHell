package com.fblaTeam.bullethell.worlds.waves;

import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;

public class Wave3World1 extends Wave{

	public Wave3World1(Handler handler, World world) {
		super(handler, world);
		
	}

	@Override
	public void addEnemies() {
		handler.getWorld().getEnemies().add(new BasicTestEnemy(handler, (handler.getWidth()/2)-32, -32));
		getEnemy(0).setHealth(10);
	}

	@Override
	public void addCommands() {
		getEnemy(0).addMovement(45, 90);
		getEnemy(0).addShootArcFlurry(.1, 20, 0, 180);
	}

}
