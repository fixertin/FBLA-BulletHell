package com.fblaTeam.bullethell.AI.bulletPatterns;

import com.fblaTeam.bullethell.creatures.BasicBullet;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.entities.Player;
import com.fblaTeam.bullethell.main.Handler;

public class ShootAtPlayerPattern extends Pattern{
	private double playerx, playery;
	
	public ShootAtPlayerPattern(Handler handler, Enemy shooter) {
		super(handler, shooter);
	}

	@Override
	public void fillBullets() {
		handler.getWorld().getBullets().add(new BasicBullet(handler, shooter.getX(), shooter.getY(), 
				checkAngle(handler.getWorld().getP()), 
				shooter));
	}
	
	public double checkAngle(Player p){
		if(playerx == 0)
			playerx = p.getX();
		if(playery == 0)
			playery = p.getY();
		double angle = Math.toDegrees(Math.atan2((playery - shooter.getY()),(playerx - shooter.getX())));
		return angle;
	}

}
