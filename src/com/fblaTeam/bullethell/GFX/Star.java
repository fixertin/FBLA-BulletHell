package com.fblaTeam.bullethell.GFX;

import java.awt.Color;
import java.awt.Graphics;

import com.fblaTeam.bullethell.creatures.Entity;
import com.fblaTeam.bullethell.main.Handler;

public class Star extends Entity{
	public int d;

	public Star(Handler handler, double x, double y, int d, double velx, double vely) {
		super(handler, x, y);
		this.velx = velx;
		this.vely = vely;
		this.d = d;
	}

	@Override
	public void tick() {
		x += velx;
		y += vely;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)x, (int)y, d, d);
	}

}
