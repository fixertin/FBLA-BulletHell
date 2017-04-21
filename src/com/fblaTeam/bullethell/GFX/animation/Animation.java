package com.fblaTeam.bullethell.GFX.animation;

import java.awt.image.BufferedImage;

public class Animation {
	private int frameGap, index, currentFrame, loopLimit, loopAmount, frameCurrent;
	private BufferedImage[] frames;
	public boolean isFinished;
	
	public Animation(int frameGap, BufferedImage[] frames){
		this.frameGap = frameGap;
		this.frames = frames;
		index = 0;
		currentFrame = 1;
	}
	
	public Animation(int frameGap, BufferedImage[] frames, int loopLimit){
		this.frameGap = frameGap;
		this.frames = frames;
		this.loopLimit = loopLimit;
		index = 0;
		currentFrame = 1;
	}
	
	public void tick(){
		currentFrame++;
		frameCurrent++;
		if(frameGap < currentFrame && loopLimit == 0){
			currentFrame = 0;
			index++;
			if(index >= frames.length)
				index = 0;
		}else if(frameGap < currentFrame){
			currentFrame = 0;
			index++;
			if(index >= frames.length){
				index = 0;
				loopAmount++;
			}
			if(loopAmount >= loopLimit){
				index = frames.length -1;
			}
			if(loopAmount > loopLimit){
				isFinished = true;
			}
		}
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
	public int getFrame(){
		return frameCurrent;
	}
}
