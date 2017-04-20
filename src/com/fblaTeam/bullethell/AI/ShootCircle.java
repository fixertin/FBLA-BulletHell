package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.AI.bulletPatterns.Circle;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

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
