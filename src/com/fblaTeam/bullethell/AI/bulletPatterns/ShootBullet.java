package com.alexnaustin.bullethell.AI.bulletPatterns;

import com.alexnaustin.bullethell.creatures.BasicBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

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
