package com.alexnaustin.bullethell.entities.enemies;

import java.awt.Color;
import java.awt.Graphics;

import com.alexnaustin.bullethell.AI.ArcObserver;
import com.alexnaustin.bullethell.AI.MoveArc;
import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.animation.Animation;
import com.alexnaustin.bullethell.entities.Enemy;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.sounds.AudioPlayer;

public class BasicTestEnemy extends Enemy{
	public int index = 0;
	public Animation explosionAnimation;
	public ArcObserver ao = new ArcObserver();
	
	

	public BasicTestEnemy(Handler handler, double x, double y) {
		super(handler, x, y);
		explosionAnimation = new Animation(1, Assets.explosion, 1);
		health = 2;
	}
	public BasicTestEnemy(Handler handler, double x, double y, int speed) {
		super(handler, x, y);
		this.speed = speed;
	}

	@Override
	public void setHitboxBounds() {
		hitbox.setBounds((int)x+3, (int)y+23, 58, 27);
		movementHitbox.setBounds((int)x+(32-8), (int)y+(32-8), 16, 16);
	}

	@Override
	public void tick() {
		if(isDead && explosionAnimation.getFrame() == 1 && handler.isSoundToggle())
			AudioPlayer.getSound("explosion").play();
		if(isDead)
			explosionAnimation.tick();
		if(explosionAnimation.isFinished)
			isRemoved = true;
		setHitboxBounds();
		if(movements.get(index).getState() == null &&  !isDead)
			movements.get(index).start();
		if(movements.get(index).isSuccess() && index+1 < movements.size() && !isDead){
			index+=1;
			movements.get(index).reset(this);
		}
		if(!isDead && movements.get(index) instanceof MoveArc){
			ao.tick(this, (MoveArc)movements.get(index));
			movements.get(index).tick();
		}
		if(!isDead)
			movements.get(index).tick();
		x += velx;
		y += vely;
		velx = 0;
		vely = 0;
	}

	@Override
	public void render(Graphics g) {
		if(!isDead)
			g.drawImage(Assets.enemy, (int)x, (int)y, null);
		else
			g.drawImage(explosionAnimation.getCurrentFrame(), (int)x, (int)y, null);
		//g.setColor(Color.ORANGE);
		//g.drawRect(hitbox.getBounds().x, hitbox.getBounds().y, hitbox.getBounds().width, hitbox.getBounds().height);
		//g.setColor(Color.CYAN);
		//g.drawRect(movementHitbox.x, movementHitbox.y, movementHitbox.width, movementHitbox.height);
		//if(test.getBounds() != null){
			//g.drawRect(test.getBounds().x, test.getBounds().y, test.getBounds().width, test.getBounds().height);
		//}
		
	}

}
