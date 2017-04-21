package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.AI.bulletPatterns.ShootAtPlayerPattern;
import com.fblaTeam.bullethell.clock.Timer;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ShootAtPlayer extends AI{
	private int amount, amountShot;
	private ShootAtPlayerPattern p;
	private Timer timer;

	public ShootAtPlayer(Handler handler, Enemy e, int amount, double gap) {
		super(handler, e);
		this.amount = amount;
		amountShot = 0;
		timer = new Timer(gap);
		p = new ShootAtPlayerPattern(handler, e);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			timer.tick();
			if(timer.hasReachedTime() && amountShot < amount){
				timer.reset();
				p.fillBullets();
				amountShot++;
			}
			if(amountShot >= amount)
				succeed();
		}
	}

}
