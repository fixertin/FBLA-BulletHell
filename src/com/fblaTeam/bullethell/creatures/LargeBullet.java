package com.alexnaustin.bullethell.creatures;

import java.awt.Graphics;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.entities.Creature;
import com.alexnaustin.bullethell.main.Handler;

public class LargeBullet extends Bullet{

	public LargeBullet(Handler handler, double x, double y, double angle, Creature shooter) {
		super(handler, x, y, angle, shooter);
		speed = 5;
		velx = getXSpeed();
		vely = getYSpeed();
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
	}
	public LargeBullet(Handler handler, double x, double y, double angle, Creature shooter, int speed) {
		super(handler, x, y, angle, shooter);
		this.speed = speed;
		velx = getXSpeed();
		vely = getYSpeed();
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
	}

	@Override
	public void tick() {
		hitbox.setBounds((int)x+27, (int)y+26, 12, 13);
		if(!isAtEdge()){
			x += velx;
			y += vely;
		}
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.largeBullet, (int)x, (int)y, null);
		//g.setColor(Color.ORANGE);
		//g.drawRect(hitbox.getBounds().x, hitbox.getBounds().y, hitbox.getBounds().width, hitbox.getBounds().height);
	}

}
