package com.alexnaustin.bullethell.AI.bulletPatterns;

import com.alexnaustin.bullethell.creatures.LargeBullet;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class Arc extends Pattern{
	public double shotgap, startAngle, arcSize;
	
	
	public Arc(Handler handler, Enemy shooter, double shotgap, double startAngle, double arcSize) {
		super(handler, shooter);
		this.shotgap = shotgap;
		this.startAngle = startAngle;
		this.arcSize = arcSize;
	}

	@Override
	public void fillBullets() {
		int bulletAmount = (int) (arcSize / shotgap);
		for(int i=0; i<bulletAmount; i++){
			handler.getWorld().getBullets().add(new LargeBullet(handler, shooter.getX(), shooter.getY(), startAngle + (i*shotgap), shooter));
		}
	}

}
