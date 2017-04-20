package com.alexnaustin.bullethell.AI;

import com.alexnaustin.bullethell.AI.bulletPatterns.Shotgun;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;

public class ShootShotgun extends AI{
	public int times = 3, amount = 0, currentFrame = 3;
	public Shotgun pattern;

	public ShootShotgun(Handler handler, Enemy e, int minAngle, int cone, int shotAmount) {
		super(handler, e);
		pattern = new Shotgun(handler, e, minAngle, cone, shotAmount/3);
	}

	@Override
	public void reset(Enemy e) {
		start();
	}

	@Override
	public void tick() {
		if(isRunning()){
			if(amount == times){
				succeed();
				return;
			}
			if(currentFrame == 3){
				pattern.fillBullets();
				currentFrame = 0;
				amount++;
			}else{
				currentFrame++;
			}
			
			
		}
	}

}
