package com.alexnaustin.bullethell.GFX;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.alexnaustin.bullethell.clock.Timer;
import com.alexnaustin.bullethell.main.Handler;

public class Background {
	public Timer timer = new Timer(0.05);
	public Handler handler;
	public ArrayList<Star> stars = new ArrayList<Star>();
	public int extension;
	
	public Background(Handler handler){
		this.handler = handler;
		this.extension = 0;
	}
	public Background(Handler handler, int extension){
		this.handler = handler;
		this.extension = extension;
	}
	
	public void tick(){
		timer.tick();
		if(timer.hasReachedTime()){
			Random r = new Random();
			stars.add(new Star(handler, r.nextInt(handler.getWidth()+extension), -10, 2, 0, r.nextInt((15 - 7) + 1) + 7));
			timer.reset();
		}
		
		
		for(int i=0; i<stars.size(); i++){
			stars.get(i).tick();
			if(stars.get(i).getY() >= handler.getHeight())
				stars.remove(i);
		}
		
	}
	public void render(Graphics g){
		for(int i=0; i<stars.size(); i++){
			stars.get(i).render(g);
		}
	}
}
