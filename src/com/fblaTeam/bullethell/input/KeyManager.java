package com.alexnaustin.bullethell.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.alexnaustin.bullethell.clock.Timer;

public class KeyManager implements KeyListener{
	public boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, space, shift, enter, upArrow, downArrow, leftArrow, rightArrow, esc;
	public boolean hasPressed = false, canPress = true;
	public Timer t = new Timer(5);
	
	public KeyManager(){
		keys = new boolean[256];
		justPressed = new boolean[256];
		cantPress = new boolean[256];
	}
	
	public void tick(){
		for(int i=0; i<keys.length; i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i] = false;
			}else if(justPressed[i]){
				cantPress[i] = true;
				justPressed[i] = false;
			}if(!cantPress[i] && keys[i]){
				justPressed[i] = true;
			}
		}
		
		up = keys[KeyEvent.VK_W];
		upArrow = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S];
		downArrow = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A];
		leftArrow = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D];
		rightArrow = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
		shift = keys[KeyEvent.VK_SHIFT];
		enter = keys[KeyEvent.VK_ENTER];
		esc = keys[KeyEvent.VK_ESCAPE];
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	
	
}
