package com.alexnaustin.bullethell.worlds.waves;

import com.alexnaustin.bullethell.entities.enemies.BasicTestEnemy;
import com.alexnaustin.bullethell.entities.enemies.SmallEnemyBlue;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.worlds.World;

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
		getEnemy(0).addShootFlurry(.1, 20);
	}

}
