package com.alexnaustin.bullethell.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.GameCamera;
import com.alexnaustin.bullethell.GFX.Window;
import com.alexnaustin.bullethell.input.KeyManager;
import com.alexnaustin.bullethell.sounds.AudioPlayer;
import com.alexnaustin.bullethell.states.GameState;
import com.alexnaustin.bullethell.states.HelpState;
import com.alexnaustin.bullethell.states.MenuState;
import com.alexnaustin.bullethell.states.OptionsState;
import com.alexnaustin.bullethell.states.State;



public class Game implements Runnable{
	
	private Window window;
	private Thread thread;
	private boolean running = false, musicToggle = true, soundToggle = true;
	private BufferStrategy bs;
	private Graphics g;
	private KeyManager keyManager;
	private GameCamera gameCamera;
	private Handler handler;
	
	
	
	public int width, height, uiWidth;
	public String title;
	
	//states
	public State gameState;
	public State menuState;
	public State optionsState;
	public State helpState;
	
	public Game(String title, int width, int height, int uiWidth){
		this.width = width;
		this.height = height;
		this.uiWidth = uiWidth;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		window = new Window(title, width+uiWidth, height);
		window.getFrame().addKeyListener(keyManager);
		Assets.init();
		AudioPlayer.init();
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		optionsState = new OptionsState(handler);
		helpState = new HelpState(handler);
		menuState.init();
		
		State.setState(menuState);
	}
	private void tick(){
		if(State.getState() != null)
			State.getState().tick();
		keyManager.tick();
		if(keyManager.esc)
			System.exit(0);
	}
	private void render(){
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null){
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width+200, height);
		
		//draw
		
		if(State.getState() != null)
			State.getState().render(g);
		//don't draw
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public GameCamera getCamera(){
		return gameCamera;
	}
	public GameState getGameState(){
		return (GameState)gameState;
	}
	public void resetGame(){
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		menuState.init();
		State.setState(menuState);
	}

	public boolean getMusicToggle() {
		return musicToggle;
	}
	public void setMusicToggle(boolean musicToggle) {
		this.musicToggle = musicToggle;
	}
	public boolean getSoundToggle() {
		return soundToggle;
	}
	public void setSoundToggle(boolean soundToggle) {
		this.soundToggle = soundToggle;
	}
	
}
