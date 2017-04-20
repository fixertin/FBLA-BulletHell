package com.alexnaustin.bullethell.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.Background;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.ui.SelectableOption;

public class MenuState extends State{
	public SelectableOption[] buttons = new SelectableOption[3];
	public int selectedIndex;
	public Background background = new Background(handler, 200);
	
	public MenuState(Handler handler) {
		super(handler);
	}
	
	public void init(){
		buttons[0] = new SelectableOption(handler, "play", handler.getGame().gameState, 250, 400);
		buttons[1] = new SelectableOption(handler, "options", handler.getGame().optionsState, 250, 425);
		buttons[2] = new SelectableOption(handler, "help", handler.getGame().helpState, 250, 450);
		selectedIndex = 0;
		buttons[selectedIndex].isSelected = true;
	}

	@Override
	public void tick() {
		background.tick();
		
		//System.out.println(buttons[1].isActivated);
		
		for(int i=0; i<buttons.length; i++){
			buttons[i].tick();
		}
		if((handler.getKeyManager().keyJustPressed(KeyEvent.VK_W) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)) && selectedIndex != 0){
			buttons[selectedIndex].isSelected = false;
			selectedIndex--;
			buttons[selectedIndex].isSelected = true;
		}
		if((handler.getKeyManager().keyJustPressed(KeyEvent.VK_S) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)) && selectedIndex < buttons.length-1){
			buttons[selectedIndex].isSelected = false;
			selectedIndex++;
			buttons[selectedIndex].isSelected = true;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
			buttons[selectedIndex].isActivated = true;
		}
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		g.drawImage(Assets.titleScreen, 0, 0, null);
		for(int i=0; i<buttons.length; i++){
			buttons[i].render(g);
		}
	}

}
