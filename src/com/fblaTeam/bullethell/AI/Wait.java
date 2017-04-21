package com.fblaTeam.bullethell.AI;

import com.fblaTeam.bullethell.clock.Timer;
import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public class Wait extends AI{
	private Timer timer;
	
	
	public Wait(Handler handler, Enemy e, Timer timer) {
		super(handler, e);
		this.timer = timer;
		timer.reset();
	}

	@Override
	public void reset(Enemy e) {
		timer.reset();
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			timer.tick();
			hasReachedTime();
		}
	}
	
	private void hasReachedTime(){
		if(timer.hasReachedTime()){
			succeed();
		}
	}

}
