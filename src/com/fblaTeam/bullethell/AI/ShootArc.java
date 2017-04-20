package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.AI.bulletPatterns.Arc;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class ShootArc extends AI{
	public double shotgap, startAngle, arcSize;
	public Arc pattern;

	public ShootArc(Handler handler, Enemy shooter, double shotgap, double startAngle, double arcSize) {
		super(handler, shooter);
		this.shotgap = shotgap;
		this.startAngle = startAngle;
		this.arcSize = arcSize;
		pattern = new Arc(handler, shooter, shotgap, startAngle, arcSize);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			pattern.fillBullets();
			succeed();
		}
	}

	

}
