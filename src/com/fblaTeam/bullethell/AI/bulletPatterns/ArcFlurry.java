package com.fblaTeam.bullethell.AI.bulletPatterns;

import java.util.Random;

import com.fblaTeam.bullethell.creatures.LargeBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ArcFlurry extends Pattern{
	public int arcStart, arcLength;
	public Random r = new Random();

	public ArcFlurry(Handler handler, Enemy shooter, int arcStart, int arcLength) {
		super(handler, shooter);
		this.arcStart = arcStart;
		this.arcLength = arcLength;
	}
	


	@Override
	public void fillBullets() {
		handler.getWorld().getBullets().add(new LargeBullet(handler, shooter.getX(), shooter.getY(), r.nextInt(arcLength - arcStart)+arcStart, shooter, r.nextInt(6-4)+4));
	}

}
