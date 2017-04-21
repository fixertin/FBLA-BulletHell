package com.fblaTeam.bullethell.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.fblaTeam.bullethell.GFX.Assets;
import com.fblaTeam.bullethell.GFX.animation.Animation;
import com.fblaTeam.bullethell.entities.Creature;
import com.fblaTeam.bullethell.entities.Player;
import com.fblaTeam.bullethell.main.Handler;


public class BasicBullet extends Bullet{
	private Animation animation;


	public BasicBullet(Handler handler, double x, double y, double angle, Creature shooter) {
		super(handler, x, y, angle, shooter);
		createAnimate();
		speed = 5;
		velx = getXSpeed();
		vely = getYSpeed();
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
	}
	public BasicBullet(Handler handler, double x, double y, double angle, Creature shooter, double speed) {
		super(handler, x, y, angle, shooter);
		this.speed = speed;
		createAnimate();
		velx = getXSpeed();
		vely = getYSpeed();
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
	}
	
	private void createAnimate(){
		if(shooter instanceof Player){
			animation = new Animation(5, Assets.pBulletA, 1);
		}else{
			animation = new Animation(5, Assets.eBulletA, 1);
		}
	}

	@Override
	public void tick() {
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
		animation.tick();
		if(!isAtEdge()){
			x += velx;
			y += vely;
		}
	}
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(angle), (int)x+32, (int)y+32);                                 
		if(!isAtEdge()){
			g2d.drawImage(animation.getCurrentFrame(), (int)x, (int)y, null);
		}
		g2d.rotate(Math.toRadians(-angle), (int)x+32, (int)y+32);
		//g.setColor(Color.ORANGE);
		//g.drawRect(hitbox.getBounds().x, hitbox.getBounds().y, hitbox.getBounds().width, hitbox.getBounds().height);
	}
}
