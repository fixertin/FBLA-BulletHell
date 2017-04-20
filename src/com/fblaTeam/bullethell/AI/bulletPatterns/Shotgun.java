package com.alexnaustin.bullethell.AI.bulletPatterns;

import java.util.Random;

import com.alexnaustin.bullethell.creatures.LargeBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class Shotgun extends Pattern{
	public int minAngle, cone, shotAmount;

	public Shotgun(Handler handler, Enemy shooter, int minAngle, int cone, int shotAmount) {
		super(handler, shooter);
		this.minAngle = minAngle;
		this.cone = cone;
		this.shotAmount = shotAmount;
	}

	@Override
	public void fillBullets() {
		Random r = new Random();
		for(int i=0; i<shotAmount; i++){
			handler.getWorld().getBullets().add(new LargeBullet(handler, shooter.getX(), shooter.getY(), r.nextInt(cone-minAngle)+minAngle, shooter));
		}
	}

}
