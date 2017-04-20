package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.entities.Enemy;

public class ArcObserver {
	
	
	public void tick(Enemy e, MoveArc moveArc){
		moveArc.resetEnemyPosition(e);
	}
	
}
