package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.entities.Enemy;

public class ArcObserver {
	
	
	public void tick(Enemy e, MoveArc moveArc){
		moveArc.resetEnemyPosition(e);
	}
	
}
