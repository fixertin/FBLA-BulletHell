package com.alexnaustin.bullethell.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.animation.Animation;
import com.alexnaustin.bullethell.clock.Timer;
import com.alexnaustin.bullethell.creatures.BasicBullet;
import com.alexnaustin.bullethell.creatures.Bullet;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.sounds.AudioPlayer;

public class Player extends Creature {
	private Timer timer, invinTimer;
	private int spawnX, spawnY;
	public Animation explosionAnimation, respawnAnimation;
	public boolean isDead, isRespawning, isInvincible, isRespawnable = true;
	
	
	public Player(Handler handler, double x, double y) {
		super(handler, x, y);
		timer = new Timer(0.05);
		invinTimer = new Timer(3);
		hitbox = new Rectangle();
		spawnX = handler.getWidth() /2 -48;
		spawnY = handler.getHeight() - 98;
		setHitboxBounds();
		explosionAnimation = new Animation(1, Assets.explosion, 1);
		respawnAnimation = new Animation(3, Assets.playerRespawn, 1);
	}
	
	public void getInput(){
		velx = 0;
		vely = 0;
		if(isDead || isRespawning)
			return;
		if(handler.getKeyManager().shift)
			speed = 2;
		else
			speed = 4;
		if(handler.getKeyManager().up && y > 0)
			vely = -speed;
		if(handler.getKeyManager().down && y+64 < handler.getHeight())
			vely = speed;
		if(handler.getKeyManager().left && x > -10)
			velx = -speed;
		if(handler.getKeyManager().right && x+64 < handler.getWidth()+10)
			velx = speed;
		if(handler.getKeyManager().space)
			shoot();
	}
	
	public void shoot(){
		if(timer.hasReachedTime()){
			handler.getWorld().getBullets().add(new BasicBullet(handler, x, y, 270, this, 15));
			timer.reset();
		}
	}
	
	@Override
	public void tick() {
		if(isDead && explosionAnimation.getFrame() == 1)
			AudioPlayer.getSound("explosion").play();
		if(isDead){
			explosionAnimation.tick();
			isInvincible = true;
		}
		if(isDead && explosionAnimation.isFinished){
			x = spawnX;
			y = spawnY;
		}
		if(!isRespawnable){
			isDead = false;
		}
		if(explosionAnimation.isFinished && isRespawnable){
			isDead = false;
			isRespawning = true;
			respawnAnimation.tick();
		}
		if(respawnAnimation.isFinished && isRespawnable){
			isDead = false;
			isRespawning = false;
			explosionAnimation = new Animation(1, Assets.explosion, 1);
			respawnAnimation = new Animation(3, Assets.playerRespawn, 1);
		}
		if(isInvincible && (!isDead && !isRespawning) && isRespawnable)
			invinTimer.tick();
		if(invinTimer.hasReachedTime()){
			isInvincible = false;
			invinTimer.reset();
		}
		
		timer.tick();
		setHitboxBounds();
		getInput();
		move();
		
	}

	@Override
	public void render(Graphics g) {
		if(isDead){
			g.drawImage(explosionAnimation.getCurrentFrame(), (int)x, (int)y, null);
		}else if(isRespawning){
			g.drawImage(respawnAnimation.getCurrentFrame(), (int)x, (int)y, null);
		}else if(isRespawnable){
			g.drawImage(Assets.player, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), null);
		}
		//g.setColor(Color.ORANGE);
		//g.drawRect(hitbox.getBounds().x, hitbox.getBounds().y, hitbox.getBounds().width, hitbox.getBounds().height);
	}

	@Override
	public void setHitboxBounds() {
		if(isInvincible){
			hitbox.setBounds(-75, -75, 1, 1);
			return;
		}
		hitbox.setBounds((int)x+27, (int)y+23, 8, 12);
	}
	
	
}
