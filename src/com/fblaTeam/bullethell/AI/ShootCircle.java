package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.AI.bulletPatterns.Circle;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ShootCircle extends AI {
	private Circle p;

	public ShootCircle(Handler handler, Enemy e, double gap) {
		super(handler, e);
		p = new Circle(handler, e, gap);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			p.fillBullets();
			succeed();
		}
	}
	
	
	
}
