package com.fblaTeam.bullethell.AI.bulletPatterns;

import com.fblaTeam.bullethell.creatures.BasicBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ShootBullet extends Pattern{
	private double angle;

	public ShootBullet(Handler handler, Enemy shooter, double angle) {
		super(handler, shooter);
		this.angle = angle;
		
	}

	@Override
	public void fillBullets() {
		handler.getWorld().getBullets().add(new BasicBullet(handler, shooter.getX(), shooter.getY(), angle, shooter));
	}

}
