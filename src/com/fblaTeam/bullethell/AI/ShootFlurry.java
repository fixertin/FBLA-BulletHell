package com.alexnaustin.bullethell.AI;

import java.util.Random;

import com.alexnaustin.bullethell.AI.bulletPatterns.Flurry;
import com.alexnaustin.bullethell.clock.Timer;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class ShootFlurry extends AI{
	public double shotGap, length;
	public Timer gapTimer, lengthTimer;
	public Flurry pattern;
	public Random r = new Random();
	public boolean hasStartedTimer;

	public ShootFlurry(Handler handler, Enemy e, double shotGap, double length) {
		super(handler, e);
		this.shotGap = shotGap;
		this.length = length;
		gapTimer = new Timer(shotGap);
		lengthTimer = new Timer(length);
		gapTimer.reset();
		lengthTimer.reset();
		pattern = new Flurry(handler, e);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		
		if(isRunning()){
			System.out.println("isrunning");
			if(!hasStartedTimer){
				gapTimer.reset();
				lengthTimer.reset();
				hasStartedTimer = true;
			}
			gapTimer.tick();
			lengthTimer.tick();
			
			if(gapTimer.hasReachedTime()){
				gapTimer.reset();
				pattern.setNewAngle(r.nextInt(360));
				pattern.fillBullets();
			}
			
			if(lengthTimer.hasReachedTime())
				succeed();
		}
	}

}
