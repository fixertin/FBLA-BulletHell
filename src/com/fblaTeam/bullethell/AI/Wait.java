package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.clock.Timer;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

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
