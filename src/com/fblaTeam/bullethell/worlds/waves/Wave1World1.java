package com.fblaTeam.bullethell.worlds.waves;

import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.entities.enemies.BasicTestEnemy;
import com.fblaTeam.bullethell.entities.enemies.SmallEnemyBlue;
import com.fblaTeam.bullethell.main.Handler;
import com.fblaTeam.bullethell.worlds.World;

public class Wave1World1 extends Wave{

	public Wave1World1(Handler handler, World world) {
		super(handler, world);
	}

	@Override
	public void addEnemies() {
		world.getEnemies().add(new SmallEnemyBlue(handler, -32, -32));
		world.getEnemies().add(new SmallEnemyBlue(handler, handler.getWidth(), -32));
		world.getEnemies().add(new BasicTestEnemy(handler, 60, -32));
		world.getEnemies().add(new BasicTestEnemy(handler, handler.getWidth()-124, -32));
	}

	@Override
	public void addCommands() {
		fillCommands();
	}
	
	public void fillCommands(){
		getEnemy(0).addWait(.5);
		getEnemy(0).addMovement(200, 65);
		getEnemy(0).addShootShotgun(65, 75, 24);
		getEnemy(0).addWait(1);
		getEnemy(0).addShootPatternAtPlayer(5, .08);
		getEnemy(0).addWait(1);
		getEnemy(0).addShootPatternAtPlayer(5, .08);
		getEnemy(0).addWait(1);
		getEnemy(0).addMoveToEdge(0);
		
		getEnemy(1).addWait(.5);
		getEnemy(1).addMovement(200, 115);
		getEnemy(1).addShootShotgun(115, 125, 24);
		getEnemy(1).addWait(1);
		getEnemy(1).addShootPatternAtPlayer(5, .08);
		getEnemy(1).addWait(1);
		getEnemy(1).addShootPatternAtPlayer(5, .08);
		getEnemy(1).addWait(1);
		getEnemy(1).addMoveToEdge(200);
		
		getEnemy(2).addMovement(180, 90);
		getEnemy(2).addShootPatternCircle(30);
		getEnemy(2).addWait(2);
		getEnemy(2).addMoveToEdge(180);
		
		getEnemy(3).addMovement(180, 90);
		getEnemy(3).addShootPatternCircle(30);
		getEnemy(3).addWait(2);
		getEnemy(3).addMoveToEdge(0);
		
	}
	
	
	
}
