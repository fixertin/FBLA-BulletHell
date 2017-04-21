package com.fblaTeam.bullethell.AI;

import java.util.Random;

import com.fblaTeam.bullethell.AI.bulletPatterns.ArcFlurry;
import com.fblaTeam.bullethell.clock.Timer;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class ShootArcFlurry extends AI{
	public double shotGap, length;
	public Timer gapTimer, lengthTimer;
	public ArcFlurry pattern;
	public Random r = new Random();
	public boolean hasStartedTimer;
	public int arcStart, arcLength;

	public ShootArcFlurry(Handler handler, Enemy e, double shotGap, double length, int arcStart, int arcLength) {
		super(handler, e);
		this.shotGap = shotGap;
		this.length = length;
		this.arcStart = arcStart;
		this.arcLength = arcLength;
		gapTimer = new Timer(shotGap);
		lengthTimer = new Timer(length);
		gapTimer.reset();
		lengthTimer.reset();
		pattern = new ArcFlurry(handler, e, arcStart, arcLength);
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
				pattern.fillBullets();
			}
			
			if(lengthTimer.hasReachedTime())
				succeed();
		}
	}

}
