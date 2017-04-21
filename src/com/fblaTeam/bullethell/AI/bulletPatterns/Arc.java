package com.fblaTeam.bullethell.AI.bulletPatterns;

import com.fblaTeam.bullethell.creatures.Bullet;
import com.fblaTeam.bullethell.creatures.LargeBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class Arc extends Pattern{
	public double shotgap, startAngle, arcSize;
	public double speed;
	
	
	public Arc(Handler handler, Enemy shooter, double shotgap, double startAngle, double arcSize) {
		super(handler, shooter);
		this.shotgap = shotgap;
		this.startAngle = startAngle;
		this.arcSize = arcSize;
		speed = Bullet.DEFAULT_SPEED;
	}
	public Arc(Handler handler, Enemy shooter, double shotgap, double startAngle, double arcSize, double speed) {
		super(handler, shooter);
		this.shotgap = shotgap;
		this.startAngle = startAngle;
		this.arcSize = arcSize;
		this.speed = speed;
	}

	@Override
	public void fillBullets() {
		int bulletAmount = (int) (arcSize / shotgap);
		for(int i=0; i<bulletAmount; i++){
			handler.getWorld().getBullets().add(new LargeBullet(handler, shooter.getX(), shooter.getY(), startAngle + (i*shotgap), shooter, speed));
		}
	}

}
